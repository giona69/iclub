package it.hearst.iclub;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.NotFoundException;
import com.google.api.server.spi.response.ServiceUnavailableException;
import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.QueryResultList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "pianificazioneApi",
        version = "v1",
        resource = "pianificazione",
        namespace = @ApiNamespace(
                ownerDomain = "iclub.hearst.it",
                ownerName = "iclub.hearst.it",
                packagePath = ""
        )
)
public class PianificazioneEndpoint {

    private static final Logger logger = Logger.getLogger(PianificazioneEndpoint.class.getName());

    /**
     * This method gets the <code>Database</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>Database</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getPianificazione",
            path = "getPianificazione",
            httpMethod = ApiMethod.HttpMethod.GET)
    public Pianificazione getPianificazione(@Named("id") String id) throws NotFoundException {
        logger.info("PIANIFICAZIONE: get");

        Pianificazione pianificazione;

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            Entity thisU = datastore.get(myKey);
            pianificazione = new Pianificazione();
            pianificazione.setId(id);
            pianificazione.setTitolo((String) thisU.getProperty("titolo"));
            pianificazione.setData((Date) thisU.getProperty("data"));
            pianificazione.setDatabase((String) thisU.getProperty("database"));
            pianificazione.setUrl((String) thisU.getProperty("url"));
            pianificazione.setText((String) thisU.getProperty("text"));
            pianificazione.setTerms((String) thisU.getProperty("terms"));
            pianificazione.setMarketing((String) thisU.getProperty("marketing"));
            pianificazione.setNewsletter((String) thisU.getProperty("newsletter"));
            pianificazione.setPrivacy((String) thisU.getProperty("privacy"));
            pianificazione.setStatus((String) thisU.getProperty("status"));
            pianificazione.setDeleted((Boolean) thisU.getProperty("deleted"));

        } catch (EntityNotFoundException e) {
            logger.warning("PIANIFICAZIONE: not found " + id);
            logger.warning("PIANIFICAZIONE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("pianificazione non trovato " + id);
        } catch (Exception e) {
            logger.severe("PIANIFICAZIONE: errore " + id);
            logger.severe("PIANIFICAZIONE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("pianificazione non esiste " + id);
        }

        return pianificazione;
    }

    /**
     * List of databases
     */
    @ApiMethod(name = "listPianificazione",
            path = "listPianificazione",
            httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<Pianificazione> listPianificazione(@Nullable @Named("cursor") String cursorString) throws ServiceUnavailableException {
        logger.info("PIANIFICAZIONE: list");

        List<Pianificazione> records = new ArrayList<Pianificazione>();

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Query q = new Query("Pianificazione").addSort("data", Query.SortDirection.DESCENDING);

            Cursor cursor = null;
            QueryResultList<Entity> lista = null;
            PreparedQuery pq = datastore.prepare(q);
            if (cursorString != null && cursorString != "") {
                cursor = Cursor.fromWebSafeString(cursorString);
                lista = pq.asQueryResultList(FetchOptions.Builder.withStartCursor(cursor).limit(20));
                cursorString = lista.getCursor().toWebSafeString();
            } else {
                lista = pq.asQueryResultList(FetchOptions.Builder.withLimit(20));
                cursorString = lista.getCursor().toWebSafeString();
            }

            for (Entity myEntity: lista) {
                Pianificazione thisU = new Pianificazione();
                thisU.setId(KeyFactory.keyToString(myEntity.getKey()));
                thisU.setTitolo((String) myEntity.getProperty("titolo"));
                thisU.setData((Date) myEntity.getProperty("data"));
                thisU.setDatabase((String) myEntity.getProperty("database"));
                thisU.setUrl((String) myEntity.getProperty("url"));
                thisU.setText((String) myEntity.getProperty("text"));
                thisU.setStatus((String) myEntity.getProperty("status"));
                thisU.setNewsletter((String) myEntity.getProperty("newsletter"));
                thisU.setTerms((String) myEntity.getProperty("terms"));
                thisU.setPrivacy((String) myEntity.getProperty("privacy"));
                thisU.setMarketing((String) myEntity.getProperty("marketing"));
                thisU.setDeleted((Boolean) myEntity.getProperty("deleted"));
                records.add(thisU);
            }
        } catch (Exception e) {
            logger.severe("PIANIFICAZIONE: errore ");
            e.printStackTrace();
            throw new ServiceUnavailableException("impossibile eseguire la query");
        }

        return CollectionResponse.<Pianificazione>builder().setItems(records).setNextPageToken(cursorString).build();
    }

    /**
     * List of databases
     */
    @ApiMethod(name = "searchPianificazione",
            path = "searchPianificazione",
            httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<Pianificazione> searchPianificazione(@Named("search") String search, @Nullable @Named("cursor") String cursorString) throws ServiceUnavailableException {
        logger.info("PIANIFICAZIONE: search");

        List<Pianificazione> records = new ArrayList<Pianificazione>();

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Query q = new Query("Pianificazione")
                    .setFilter(new Query.FilterPredicate("titolo", Query.FilterOperator.GREATER_THAN_OR_EQUAL, search))
                    .addSort("titolo", Query.SortDirection.ASCENDING);

            Cursor cursor = null;
            QueryResultList<Entity> lista = null;
            PreparedQuery pq = datastore.prepare(q);
            if (cursorString != null && cursorString != "") {
                cursor = Cursor.fromWebSafeString(cursorString);
                lista = pq.asQueryResultList(FetchOptions.Builder.withStartCursor(cursor).limit(20));
                cursorString = lista.getCursor().toWebSafeString();
            } else {
                lista = pq.asQueryResultList(FetchOptions.Builder.withLimit(20));
                cursorString = lista.getCursor().toWebSafeString();
            }

            for (Entity myEntity: lista) {
                String titolocheck = (String) myEntity.getProperty("titolo");
                if (titolocheck.contains(search)) {
                    Pianificazione thisU = new Pianificazione();
                    thisU.setId(KeyFactory.keyToString(myEntity.getKey()));
                    thisU.setTitolo((String) myEntity.getProperty("titolo"));
                    thisU.setData((Date) myEntity.getProperty("data"));
                    thisU.setDatabase((String) myEntity.getProperty("database"));
                    thisU.setUrl((String) myEntity.getProperty("url"));
                    thisU.setText((String) myEntity.getProperty("text"));
                    thisU.setStatus((String) myEntity.getProperty("status"));
                    thisU.setNewsletter((String) myEntity.getProperty("newsletter"));
                    thisU.setTerms((String) myEntity.getProperty("terms"));
                    thisU.setPrivacy((String) myEntity.getProperty("privacy"));
                    thisU.setMarketing((String) myEntity.getProperty("marketing"));
                    thisU.setDeleted((Boolean) myEntity.getProperty("deleted"));
                    records.add(thisU);
                } else {
                    cursorString = "lasttoken";
                }
            }
        } catch (Exception e) {
            logger.severe("PIANIFICAZIONE: errore ");
            e.printStackTrace();
            throw new ServiceUnavailableException("impossibile eseguire la query");
        }

        return CollectionResponse.<Pianificazione>builder().setItems(records).setNextPageToken(cursorString).build();
    }

    /**
     * This inserts a new <code>Pianificazione</code> object.
     *
     * @param pianificazione The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertPianificazione",
            path = "insertPianificazione",
            httpMethod = ApiMethod.HttpMethod.POST)
    public Pianificazione insertPianificazione(Pianificazione pianificazione) throws ServiceUnavailableException {
        logger.info("PIANIFICAZIONE: insert");

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Entity thisU = new Entity("Pianificazione");
            thisU.setProperty("titolo", pianificazione.getTitolo());
            thisU.setProperty("data", pianificazione.getData());
            thisU.setUnindexedProperty("database", pianificazione.getDatabase());
            thisU.setUnindexedProperty("url", pianificazione.getUrl());
            thisU.setUnindexedProperty("text", pianificazione.getText());
            thisU.setUnindexedProperty("status", pianificazione.getStatus());
            thisU.setUnindexedProperty("newsletter", pianificazione.getNewsletter());
            thisU.setUnindexedProperty("terms", pianificazione.getTerms());
            thisU.setUnindexedProperty("privacy", pianificazione.getPrivacy());
            thisU.setUnindexedProperty("marketing",  pianificazione.getMarketing());
            thisU.setProperty("deleted", pianificazione.getDeleted());

            datastore.put(thisU);

            pianificazione.setId(KeyFactory.keyToString(thisU.getKey()));
        } catch (Exception e) {
            logger.warning("PIANIFICAZIONE: insert " + e.getMessage());
            e.printStackTrace();
            throw new ServiceUnavailableException("impossibile inserire il record");
        }

        return pianificazione;
    }

    /**
     *
     */
    @ApiMethod(name = "updatePianificazione",
            path = "updatePianificazione",
            httpMethod = ApiMethod.HttpMethod.PUT)
    public Pianificazione updatePianificazione(@Named("id") String id, Pianificazione pianificazione)
            throws NotFoundException, ServiceUnavailableException    {
        logger.info("PIANIFICAZIONE: update");

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            Entity thisU = datastore.get(myKey);
            thisU.setProperty("titolo", pianificazione.getTitolo());
            thisU.setProperty("data", pianificazione.getData());
            thisU.setUnindexedProperty("database", pianificazione.getDatabase());
            thisU.setUnindexedProperty("url", pianificazione.getUrl());
            thisU.setUnindexedProperty("text", pianificazione.getText());
            thisU.setUnindexedProperty("status", pianificazione.getStatus());
            thisU.setUnindexedProperty("newsletter", pianificazione.getNewsletter());
            thisU.setUnindexedProperty("terms", pianificazione.getTerms());
            thisU.setUnindexedProperty("privacy", pianificazione.getPrivacy());
            thisU.setUnindexedProperty("marketing",  pianificazione.getMarketing());
            thisU.setProperty("deleted", pianificazione.getDeleted());

            datastore.put(thisU);
        } catch (EntityNotFoundException e) {
            logger.warning("PIANIFICAZIONE: not found " + id);
            logger.warning("PIANIFICAZIONE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("pianificazione non trovato " + id);
        } catch (Exception e) {
            logger.severe("PIANIFICAZIONE: errore " + id);
            logger.severe("PIANIFICAZIONE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("pianificazione non esiste " + id);
        }

        return pianificazione;
    }

    /**
     *
     */
    @ApiMethod(name = "deletePianificazione",
            path = "deletePianificazione",
            httpMethod = ApiMethod.HttpMethod.DELETE)
    public Pianificazione deletePianificazione(@Named("id") String id, Pianificazione pianificazione)
            throws NotFoundException {
        logger.info("PIANIFICAZIONE: delete");

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            datastore.delete(myKey);
        } catch (Exception e) {
            logger.severe("PIANIFICAZIONE: errore " + id);
            logger.severe("PIANIFICAZIONE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("pianificazione non esiste " + id);
        }

        return pianificazione;
    }
}