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
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "utenteApi",
        version = "v1",
        resource = "utente",
        namespace = @ApiNamespace(
                ownerDomain = "iclub.hearst.it",
                ownerName = "iclub.hearst.it",
                packagePath = ""
        )
)
public class UtenteEndpoint {

    private static final Logger logger = Logger.getLogger(UtenteEndpoint.class.getName());

    /**
     * This method gets the <code>Database</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>Database</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getUtente",
            path = "getUtente",
            httpMethod = ApiMethod.HttpMethod.GET)
    public Utente getUtente(@Named("ns") String ns, @Named("id") String id) throws NotFoundException {
        logger.info("UTENTE: get");

        Utente utente;

        try {
            NamespaceManager.set(ns);
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            Entity thisU = datastore.get(myKey);
            utente = new Utente();
            utente.setId(id);
            utente.setUser_login((String) thisU.getProperty("user_login"));
            utente.setFirst_name((String) thisU.getProperty("first_name"));
            utente.setUser_email((String) thisU.getProperty("user_email"));
            utente.setGenre((String) thisU.getProperty("genre"));
            utente.setYear_birth((String) thisU.getProperty("year_birth"));
            utente.setData_nascita((String) thisU.getProperty("data_nascita"));
            utente.setPassword((String) thisU.getProperty("password"));
            utente.setUrlPhoto((String) thisU.getProperty("urlPhoto"));
            utente.setNewsletter((String) thisU.getProperty("newsletter"));
            utente.setTerms((String) thisU.getProperty("terms"));
            utente.setPrivacy((String) thisU.getProperty("privacy"));
            utente.setMarketing((String) thisU.getProperty("marketing"));
            utente.setIndirizzo((String) thisU.getProperty("indirizzo"));
            utente.setCivico((String) thisU.getProperty("civico"));
            utente.setCap((String) thisU.getProperty("cap"));
            utente.setCitta((String) thisU.getProperty("citta"));
            utente.setProvincia((String) thisU.getProperty("provincia"));
            utente.setNazione((String) thisU.getProperty("nazione"));
            utente.setPrefisso((String) thisU.getProperty("prefisso"));
            utente.setTelefono((String) thisU.getProperty("telefono"));
            utente.setAbbonamento_privacy((String) thisU.getProperty("abbonamento_privacy"));
            utente.setAbbonamento_marketing((String) thisU.getProperty("abbonamento_marketing"));
            utente.setNewsletter_elleactive((String) thisU.getProperty("newsletter_elleactive"));
            utente.setImport_id((String) thisU.getProperty("import_id"));
            utente.setImport_source((String) thisU.getProperty("import_source"));
            utente.setAbbonamento_form((String) thisU.getProperty("abbonamento_form"));
            utente.setAbbonamento_source((String) thisU.getProperty("abbonamento_source"));
            utente.setAbbonamento_sito((String) thisU.getProperty("abbonamento_sito"));
            utente.setAbbonamento_url((String) thisU.getProperty("abbonamento_url"));
            utente.setImport_date((Date) thisU.getProperty("import_date"));
            utente.setToken((String) thisU.getProperty("token"));
            utente.setSource_registrazione((String) thisU.getProperty("source_registrazione"));
            utente.setLang((String) thisU.getProperty("lang"));
            utente.setCodice_coupon((String) thisU.getProperty("codice_coupon"));
            utente.setStato_coupon((String) thisU.getProperty("stato_coupon"));
            utente.setAbbonamento_form_date((Date) thisU.getProperty("abbonamento_form_date"));
            utente.setUser_registered((Date) thisU.getProperty("user_registered"));
            utente.setUser_status((String) thisU.getProperty("user_status"));
            utente.setDeleted((Boolean) thisU.getProperty("deleted"));

        } catch (EntityNotFoundException e) {
            logger.warning("UTENTE: not found " + id);
            logger.warning("UTENTE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("utente non trovato " + id);
        } catch (Exception e) {
            logger.severe("UTENTE: errore " + id);
            logger.severe("UTENTE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("utente non esiste " + id);
        }

        return utente;
    }

    /**
     * List of databases
     */
    @ApiMethod(name = "listUtente",
            path = "listUtente",
            httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<Utente> listUtente(@Named("ns") String ns, @Nullable @Named("cursor") String cursorString) throws ServiceUnavailableException {
        logger.info("UTENTE: list");

        List<Utente> records = new ArrayList<Utente>();

        try {
            NamespaceManager.set(ns);
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Query q = new Query("Utente").addSort("user_registered", Query.SortDirection.DESCENDING);

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
                Utente thisU = new Utente();
                thisU.setId(KeyFactory.keyToString(myEntity.getKey()));
                thisU.setUser_login((String) myEntity.getProperty("user_login"));
                thisU.setFirst_name((String) myEntity.getProperty("first_name"));
                thisU.setUser_email((String) myEntity.getProperty("user_email"));
                thisU.setGenre((String) myEntity.getProperty("genre"));
                thisU.setYear_birth((String) myEntity.getProperty("year_birth"));
                thisU.setData_nascita((String) myEntity.getProperty("data_nascita"));
                thisU.setPassword((String) myEntity.getProperty("password"));
                thisU.setUrlPhoto((String) myEntity.getProperty("urlPhoto"));
                thisU.setNewsletter((String) myEntity.getProperty("newsletter"));
                thisU.setTerms((String) myEntity.getProperty("terms"));
                thisU.setPrivacy((String) myEntity.getProperty("privacy"));
                thisU.setMarketing((String) myEntity.getProperty("marketing"));
                thisU.setIndirizzo((String) myEntity.getProperty("indirizzo"));
                thisU.setCivico((String) myEntity.getProperty("civico"));
                thisU.setCap((String) myEntity.getProperty("cap"));
                thisU.setCitta((String) myEntity.getProperty("citta"));
                thisU.setProvincia((String) myEntity.getProperty("provincia"));
                thisU.setNazione((String) myEntity.getProperty("nazione"));
                thisU.setPrefisso((String) myEntity.getProperty("prefisso"));
                thisU.setTelefono((String) myEntity.getProperty("telefono"));
                thisU.setAbbonamento_privacy((String) myEntity.getProperty("abbonamento_privacy"));
                thisU.setAbbonamento_marketing((String) myEntity.getProperty("abbonamento_marketing"));
                thisU.setNewsletter_elleactive((String) myEntity.getProperty("newsletter_elleactive"));
                thisU.setImport_id((String) myEntity.getProperty("import_id"));
                thisU.setImport_source((String) myEntity.getProperty("import_source"));
                thisU.setAbbonamento_form((String) myEntity.getProperty("abbonamento_form"));
                thisU.setAbbonamento_source((String) myEntity.getProperty("abbonamento_source"));
                thisU.setAbbonamento_sito((String) myEntity.getProperty("abbonamento_sito"));
                thisU.setAbbonamento_url((String) myEntity.getProperty("abbonamento_url"));
                thisU.setImport_date((Date) myEntity.getProperty("import_date"));
                thisU.setToken((String) myEntity.getProperty("token"));
                thisU.setSource_registrazione((String) myEntity.getProperty("source_registrazione"));
                thisU.setLang((String) myEntity.getProperty("lang"));
                thisU.setCodice_coupon((String) myEntity.getProperty("codice_coupon"));
                thisU.setStato_coupon((String) myEntity.getProperty("stato_coupon"));
                thisU.setAbbonamento_form_date((Date) myEntity.getProperty("abbonamento_form_date"));
                thisU.setUser_registered((Date) myEntity.getProperty("user_registered"));
                thisU.setUser_status((String) myEntity.getProperty("user_status"));
                thisU.setDeleted((Boolean) myEntity.getProperty("deleted"));
                records.add(thisU);
            }
        } catch (Exception e) {
            logger.severe("UTENTE: errore ");
            e.printStackTrace();
            throw new ServiceUnavailableException("impossibile eseguire la query");
        }

        return CollectionResponse.<Utente>builder().setItems(records).setNextPageToken(cursorString).build();
    }

    /**
     * List of databases
     */
    @ApiMethod(name = "searchUtente",
            path = "searchUtente",
            httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<Utente> searchUtente(@Named("ns") String ns, @Named("search") String search, @Nullable @Named("cursor") String cursorString) throws ServiceUnavailableException {
        logger.info("UTENTE: search");

        List<Utente> records = new ArrayList<Utente>();

        try {
            NamespaceManager.set(ns);
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Query q = new Query("Utente")
                            .setFilter(new Query.FilterPredicate("user_email", Query.FilterOperator.GREATER_THAN_OR_EQUAL, search))
                            .addSort("user_email", Query.SortDirection.ASCENDING);

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
                String emailcheck = (String) myEntity.getProperty("user_email");
                if (emailcheck.contains(search)) {
                    Utente thisU = new Utente();
                    thisU.setId(KeyFactory.keyToString(myEntity.getKey()));
                    thisU.setUser_login((String) myEntity.getProperty("user_login"));
                    thisU.setFirst_name((String) myEntity.getProperty("first_name"));
                    thisU.setUser_email((String) myEntity.getProperty("user_email"));
                    thisU.setGenre((String) myEntity.getProperty("genre"));
                    thisU.setYear_birth((String) myEntity.getProperty("year_birth"));
                    thisU.setData_nascita((String) myEntity.getProperty("data_nascita"));
                    thisU.setPassword((String) myEntity.getProperty("password"));
                    thisU.setUrlPhoto((String) myEntity.getProperty("urlPhoto"));
                    thisU.setNewsletter((String) myEntity.getProperty("newsletter"));
                    thisU.setTerms((String) myEntity.getProperty("terms"));
                    thisU.setPrivacy((String) myEntity.getProperty("privacy"));
                    thisU.setMarketing((String) myEntity.getProperty("marketing"));
                    thisU.setIndirizzo((String) myEntity.getProperty("indirizzo"));
                    thisU.setCivico((String) myEntity.getProperty("civico"));
                    thisU.setCap((String) myEntity.getProperty("cap"));
                    thisU.setCitta((String) myEntity.getProperty("citta"));
                    thisU.setProvincia((String) myEntity.getProperty("provincia"));
                    thisU.setNazione((String) myEntity.getProperty("nazione"));
                    thisU.setPrefisso((String) myEntity.getProperty("prefisso"));
                    thisU.setTelefono((String) myEntity.getProperty("telefono"));
                    thisU.setAbbonamento_privacy((String) myEntity.getProperty("abbonamento_privacy"));
                    thisU.setAbbonamento_marketing((String) myEntity.getProperty("abbonamento_marketing"));
                    thisU.setNewsletter_elleactive((String) myEntity.getProperty("newsletter_elleactive"));
                    thisU.setImport_id((String) myEntity.getProperty("import_id"));
                    thisU.setImport_source((String) myEntity.getProperty("import_source"));
                    thisU.setAbbonamento_form((String) myEntity.getProperty("abbonamento_form"));
                    thisU.setAbbonamento_source((String) myEntity.getProperty("abbonamento_source"));
                    thisU.setAbbonamento_sito((String) myEntity.getProperty("abbonamento_sito"));
                    thisU.setAbbonamento_url((String) myEntity.getProperty("abbonamento_url"));
                    thisU.setImport_date((Date) myEntity.getProperty("import_date"));
                    thisU.setToken((String) myEntity.getProperty("token"));
                    thisU.setSource_registrazione((String) myEntity.getProperty("source_registrazione"));
                    thisU.setLang((String) myEntity.getProperty("lang"));
                    thisU.setCodice_coupon((String) myEntity.getProperty("codice_coupon"));
                    thisU.setStato_coupon((String) myEntity.getProperty("stato_coupon"));
                    thisU.setAbbonamento_form_date((Date) myEntity.getProperty("abbonamento_form_date"));
                    thisU.setUser_registered((Date) myEntity.getProperty("user_registered"));
                    thisU.setUser_status((String) myEntity.getProperty("user_status"));
                    thisU.setDeleted((Boolean) myEntity.getProperty("deleted"));
                    records.add(thisU);
                } else {
                    cursorString = "lasttoken";
                }
            }
        } catch (Exception e) {
            logger.severe("UTENTE: errore ");
            e.printStackTrace();
            throw new ServiceUnavailableException("impossibile eseguire la query");
        }

        return CollectionResponse.<Utente>builder().setItems(records).setNextPageToken(cursorString).build();
    }

    /**
     * This inserts a new <code>Utente</code> object.
     *
     * @param utente The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertUtente",
            path = "insertUtente",
            httpMethod = ApiMethod.HttpMethod.POST)
    public Utente insertUtente(@Named("ns") String ns, Utente utente) throws ServiceUnavailableException {
        logger.info("UTENTE: insert");

        try {
            NamespaceManager.set(ns);
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Entity thisU = new Entity("Utente");
            thisU.setUnindexedProperty("user_login", utente.getUser_login());
            thisU.setUnindexedProperty("first_name", utente.getFirst_name());
            thisU.setProperty("user_email", utente.getUser_email());
            thisU.setProperty("genre", utente.getGenre());
            thisU.setUnindexedProperty("year_birth", utente.getYear_birth());
            thisU.setUnindexedProperty("data_nascita", utente.getData_nascita());
            thisU.setUnindexedProperty("password", utente.getPassword());
            thisU.setUnindexedProperty("urlPhoto", utente.getUrlPhoto());
            thisU.setProperty("newsletter", utente.getNewsletter());
            thisU.setProperty("terms", utente.getTerms());
            thisU.setProperty("privacy", utente.getPrivacy());
            thisU.setProperty("marketing",  utente.getMarketing());
            thisU.setUnindexedProperty("indirizzo", utente.getIndirizzo());
            thisU.setUnindexedProperty("civico", utente.getCivico());
            thisU.setUnindexedProperty("cap", utente.getCap());
            thisU.setUnindexedProperty("citta", utente.getCitta());
            thisU.setUnindexedProperty("provincia", utente.getProvincia());
            thisU.setUnindexedProperty("nazione", utente.getNazione());
            thisU.setUnindexedProperty("prefisso", utente.getPrefisso());
            thisU.setUnindexedProperty("telefono", utente.getTelefono());
            thisU.setProperty("abbonamento_privacy", utente.getAbbonamento_privacy());
            thisU.setProperty("abbonamento_marketing", utente.getAbbonamento_marketing());
            thisU.setProperty("newsletter_elleactive", utente.getNewsletter_elleactive());
            thisU.setUnindexedProperty("import_id", utente.getImport_id());
            thisU.setUnindexedProperty("import_source", utente.getImport_source());
            thisU.setUnindexedProperty("abbonamento_form", utente.getAbbonamento_form());
            thisU.setUnindexedProperty("abbonamento_source", utente.getAbbonamento_source());
            thisU.setUnindexedProperty("abbonamento_sito", utente.getAbbonamento_sito());
            thisU.setUnindexedProperty("abbonamento_url", utente.getAbbonamento_url());
            thisU.setUnindexedProperty("import_date", utente.getImport_date());
            thisU.setUnindexedProperty("token", utente.getToken());
            thisU.setUnindexedProperty("source_registrazione", utente.getSource_registrazione());
            thisU.setProperty("lang", utente.getLang());
            thisU.setUnindexedProperty("codice_coupon", utente.getCodice_coupon());
            thisU.setUnindexedProperty("stato_coupon", utente.getStato_coupon());
            thisU.setUnindexedProperty("abbonamento_form_date", utente.getAbbonamento_form_date());
            thisU.setProperty("user_registered", utente.getUser_registered());
            thisU.setProperty("user_status", utente.getUser_status());
            thisU.setProperty("deleted", utente.getDeleted());

            datastore.put(thisU);

            utente.setId(KeyFactory.keyToString(thisU.getKey()));
        } catch (Exception e) {
            logger.warning("UTENTE: insert " + e.getMessage());
            e.printStackTrace();
            throw new ServiceUnavailableException("impossibile inserire il record");
        }

        return utente;
    }

    /**
     *
     */
    @ApiMethod(name = "updateUtente",
            path = "updateUtente",
            httpMethod = ApiMethod.HttpMethod.PUT)
    public Utente updateUtente(@Named("ns") String ns, @Named("id") String id, Utente utente)
            throws NotFoundException, ServiceUnavailableException    {
        logger.info("UTENTE: update");

        try {
            NamespaceManager.set(ns);
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            Entity thisU = datastore.get(myKey);
            thisU.setUnindexedProperty("user_login", utente.getUser_login());
            thisU.setUnindexedProperty("first_name", utente.getFirst_name());
            thisU.setProperty("user_email", utente.getUser_email());
            thisU.setProperty("genre", utente.getGenre());
            thisU.setUnindexedProperty("year_birth", utente.getYear_birth());
            thisU.setUnindexedProperty("data_nascita", utente.getData_nascita());
            thisU.setUnindexedProperty("password", utente.getPassword());
            thisU.setUnindexedProperty("urlPhoto", utente.getUrlPhoto());
            thisU.setProperty("newsletter", utente.getNewsletter());
            thisU.setProperty("terms", utente.getTerms());
            thisU.setProperty("privacy", utente.getPrivacy());
            thisU.setProperty("marketing",  utente.getMarketing());
            thisU.setUnindexedProperty("indirizzo", utente.getIndirizzo());
            thisU.setUnindexedProperty("civico", utente.getCivico());
            thisU.setUnindexedProperty("cap", utente.getCap());
            thisU.setUnindexedProperty("citta", utente.getCitta());
            thisU.setUnindexedProperty("provincia", utente.getProvincia());
            thisU.setUnindexedProperty("nazione", utente.getNazione());
            thisU.setUnindexedProperty("prefisso", utente.getPrefisso());
            thisU.setUnindexedProperty("telefono", utente.getTelefono());
            thisU.setProperty("abbonamento_privacy", utente.getAbbonamento_privacy());
            thisU.setProperty("abbonamento_marketing", utente.getAbbonamento_marketing());
            thisU.setProperty("newsletter_elleactive", utente.getNewsletter_elleactive());
            thisU.setUnindexedProperty("import_id", utente.getImport_id());
            thisU.setUnindexedProperty("import_source", utente.getImport_source());
            thisU.setUnindexedProperty("abbonamento_form", utente.getAbbonamento_form());
            thisU.setUnindexedProperty("abbonamento_source", utente.getAbbonamento_source());
            thisU.setUnindexedProperty("abbonamento_sito", utente.getAbbonamento_sito());
            thisU.setUnindexedProperty("abbonamento_url", utente.getAbbonamento_url());
            thisU.setUnindexedProperty("import_date", utente.getImport_date());
            thisU.setUnindexedProperty("token", utente.getToken());
            thisU.setUnindexedProperty("source_registrazione", utente.getSource_registrazione());
            thisU.setProperty("lang", utente.getLang());
            thisU.setUnindexedProperty("codice_coupon", utente.getCodice_coupon());
            thisU.setUnindexedProperty("stato_coupon", utente.getStato_coupon());
            thisU.setUnindexedProperty("abbonamento_form_date", utente.getAbbonamento_form_date());
            thisU.setProperty("user_registered", utente.getUser_registered());
            thisU.setProperty("user_status", utente.getUser_status());
            thisU.setProperty("deleted", utente.getDeleted());

            datastore.put(thisU);
        } catch (EntityNotFoundException e) {
            logger.warning("UTENTE: not found " + id);
            logger.warning("UTENTE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("utente non trovato " + id);
        } catch (Exception e) {
            logger.severe("UTENTE: errore " + id);
            logger.severe("UTENTE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("utente non esiste " + id);
        }

        return utente;
    }

    /**
     *
     */
    @ApiMethod(name = "deleteUtente",
            path = "deleteUtente",
            httpMethod = ApiMethod.HttpMethod.DELETE)
    public Utente deleteUtente(@Named("ns") String ns, @Named("id") String id, Utente utente)
            throws NotFoundException {
        logger.info("UTENTE: delete");

        try {
            NamespaceManager.set(ns);
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            datastore.delete(myKey);
        } catch (Exception e) {
            logger.severe("UTENTE: errore " + id);
            logger.severe("UTENTE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("utente non esiste " + id);
        }

        return utente;
    }

    /**
     *
     */
    @ApiMethod(name = "importUtente",
            path = "importUtente",
            httpMethod = ApiMethod.HttpMethod.POST)
    public Entity importUtente(@Named("ns") String ns, ListUtenti utenti) throws ServiceUnavailableException {
        logger.info("UTENTE: import");

        try {
            NamespaceManager.set(ns);
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Collection<Utente> lista = utenti.getListUtente();
            List<Entity> batch = new ArrayList<Entity>();

            for (Utente utente: lista) {

                Query q = new Query("Utente").setFilter(new Query.FilterPredicate("user_email", Query.FilterOperator.EQUAL, utente.getUser_email()));
                PreparedQuery pq = datastore.prepare(q);

                if (pq.countEntities(FetchOptions.Builder.withLimit(1))==0) {
                    Entity thisU = new Entity("Utente");
                    thisU.setUnindexedProperty("user_login", utente.getUser_login());
                    thisU.setUnindexedProperty("first_name", utente.getFirst_name());
                    thisU.setProperty("user_email", utente.getUser_email());
                    thisU.setProperty("genre", utente.getGenre());
                    thisU.setUnindexedProperty("year_birth", utente.getYear_birth());
                    thisU.setUnindexedProperty("data_nascita", utente.getData_nascita());
                    thisU.setUnindexedProperty("password", utente.getPassword());
                    thisU.setUnindexedProperty("urlPhoto", utente.getUrlPhoto());
                    thisU.setProperty("newsletter", utente.getNewsletter());
                    thisU.setProperty("terms", utente.getTerms());
                    thisU.setProperty("privacy", utente.getPrivacy());
                    thisU.setProperty("marketing",  utente.getMarketing());
                    thisU.setUnindexedProperty("indirizzo", utente.getIndirizzo());
                    thisU.setUnindexedProperty("civico", utente.getCivico());
                    thisU.setUnindexedProperty("cap", utente.getCap());
                    thisU.setUnindexedProperty("citta", utente.getCitta());
                    thisU.setUnindexedProperty("provincia", utente.getProvincia());
                    thisU.setUnindexedProperty("nazione", utente.getNazione());
                    thisU.setUnindexedProperty("prefisso", utente.getPrefisso());
                    thisU.setUnindexedProperty("telefono", utente.getTelefono());
                    thisU.setProperty("abbonamento_privacy", utente.getAbbonamento_privacy());
                    thisU.setProperty("abbonamento_marketing", utente.getAbbonamento_marketing());
                    thisU.setProperty("newsletter_elleactive", utente.getNewsletter_elleactive());
                    thisU.setUnindexedProperty("import_id", utente.getImport_id());
                    thisU.setUnindexedProperty("import_source", utente.getImport_source());
                    thisU.setUnindexedProperty("abbonamento_form", utente.getAbbonamento_form());
                    thisU.setUnindexedProperty("abbonamento_source", utente.getAbbonamento_source());
                    thisU.setUnindexedProperty("abbonamento_sito", utente.getAbbonamento_sito());
                    thisU.setUnindexedProperty("abbonamento_url", utente.getAbbonamento_url());
                    thisU.setUnindexedProperty("import_date", utente.getImport_date());
                    thisU.setUnindexedProperty("token", utente.getToken());
                    thisU.setUnindexedProperty("source_registrazione", utente.getSource_registrazione());
                    thisU.setProperty("lang", utente.getLang());
                    thisU.setUnindexedProperty("codice_coupon", utente.getCodice_coupon());
                    thisU.setUnindexedProperty("stato_coupon", utente.getStato_coupon());
                    thisU.setUnindexedProperty("abbonamento_form_date", utente.getAbbonamento_form_date());
                    thisU.setProperty("user_registered", utente.getUser_registered());
                    thisU.setProperty("user_status", utente.getUser_status());
                    thisU.setProperty("deleted", utente.getDeleted());

                    batch.add(thisU);
                }
            }

            datastore.put(batch);

        } catch (Exception e) {
            logger.warning("UTENTE: insert " + e.getMessage());
            e.printStackTrace();
            throw new ServiceUnavailableException("errore inserimento utenti");
        }

        Entity response = new Entity("Response");
        response.setProperty("import", "ok");
        return response;
    }
}