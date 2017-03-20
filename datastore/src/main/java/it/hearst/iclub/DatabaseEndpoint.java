package it.hearst.iclub;

import com.google.api.server.spi.config.Api;
//import com.google.api.server.spi.config.ApiIssuer;
//import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.NotFoundException;
import com.google.api.server.spi.response.ServiceUnavailableException;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
//import com.google.api.server.spi.auth.EspAuthenticator;
//import com.google.api.server.spi.auth.common.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "databaseApi",
        version = "v1",
        resource = "database",
        namespace = @ApiNamespace(
                ownerDomain = "iclub.hearst.it",
                ownerName = "iclub.hearst.it",
                packagePath = ""
        )
//        authenticators = {EspAuthenticator.class},
//        issuers = {
//                @ApiIssuer(
//                        name = "firebase",
//                        issuer = "https://securetoken.google.com/hearst-it",
//                        jwksUri = "https://www.googleapis.com/service_accounts/v1/metadata/x509/securetoken@system.gserviceaccount.com")
//        },
//        issuerAudiences = {
//                @ApiIssuerAudience(name = "firebase", audiences = "hearst-it")
//        }
)
public class DatabaseEndpoint {

    private static final Logger logger = Logger.getLogger(DatabaseEndpoint.class.getName());

    /**
     * This method gets the <code>Database</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>Database</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getDatabase",
               path = "getDatabase",
               httpMethod = ApiMethod.HttpMethod.GET)
    public Database getDatabase(@Named("id") String id) throws NotFoundException, UnauthorizedException {
        logger.info("DATABASE: get");

//        if (user == null) {
//            throw new UnauthorizedException("Utente non autorizzato");
//        }

        Database database;

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            Entity datab = datastore.get(myKey);
            database = new Database();
            database.setId(id);
            database.setNomedb((String) datab.getProperty("nomedb"));
            database.setProject((String) datab.getProperty("project"));
            database.setNamespace((String) datab.getProperty("namespace"));
            database.setMainrepo((Boolean) datab.getProperty("mainrepo"));
            database.setDeleted((Boolean) datab.getProperty("deleted"));

            NamespaceManager.set((String) datab.getProperty("namespace"));
            Query q = new Query("Utente");
            PreparedQuery pq = datastore.prepare(q);
            database.setUserCount(pq.countEntities(FetchOptions.Builder.withDefaults()));

            } catch (EntityNotFoundException e) {
            logger.warning("DATABASE: not found " + id);
            logger.warning("DATABASE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("database non trovato " + id);
        } catch (Exception e) {
            logger.severe("DATABASE: errore " + id);
            logger.severe("DATABASE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("il database non esiste " + id);
        }

        return database;
    }

    /**
     * List of databases
     */
    @ApiMethod(name = "listDatabase",
               path = "listDatabase",
               httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<Database> listDatabase() throws ServiceUnavailableException {
        logger.info("DATABASE: list");

        List<Database> records = new ArrayList<Database>();

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Query q = new Query("Database");

            PreparedQuery pq = datastore.prepare(q);
            List<Entity> lista = pq.asList(FetchOptions.Builder.withLimit(5000));

            for (Entity myEntity: lista) {
                Database thisDb = new Database();
                thisDb.setId(KeyFactory.keyToString(myEntity.getKey()));
                thisDb.setNomedb((String) myEntity.getProperty("nomedb"));
                thisDb.setProject((String) myEntity.getProperty("project"));
                thisDb.setNamespace((String) myEntity.getProperty("namespace"));
                thisDb.setMainrepo((Boolean) myEntity.getProperty("mainrepo"));
                thisDb.setDeleted((Boolean) myEntity.getProperty("deleted"));

                NamespaceManager.set((String) myEntity.getProperty("namespace"));
                Query qu = new Query("Utente");
                PreparedQuery pqu = datastore.prepare(qu);
                thisDb.setUserCount(pqu.countEntities(FetchOptions.Builder.withDefaults()));

                records.add(thisDb);
            }
        } catch (Exception e) {
            logger.severe("DATABASE: errore ");
            e.printStackTrace();
            throw new ServiceUnavailableException("impossibile eseguire la query");
        }

        return CollectionResponse.<Database>builder().setItems(records).build();
    }

    /**
     * This inserts a new <code>Database</code> object.
     *
     * @param database The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertDatabase",
               path = "insertDatabase",
               httpMethod = ApiMethod.HttpMethod.POST)
    public Database insertDatabase(Database database) throws ServiceUnavailableException {
        logger.info("DATABASE: insert");

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Entity datab = new Entity("Database");
            datab.setUnindexedProperty("nomedb", database.getNomedb());
            datab.setUnindexedProperty("project", database.getProject());
            datab.setUnindexedProperty("namespace", database.getNamespace());
            datab.setUnindexedProperty("mainrepo", database.getMainrepo());
            datab.setProperty("deleted", database.getDeleted());

            datastore.put(datab);

            database.setId(KeyFactory.keyToString(datab.getKey()));
        } catch (Exception e) {
            logger.warning("DATABASE: insert " + e.getMessage());
            e.printStackTrace();
            throw new ServiceUnavailableException("impossibile inserire il record");
        }

        return database;
    }

    /**
     *
     */
    @ApiMethod(name = "updateDatabase",
               path = "updateDatabase",
               httpMethod = ApiMethod.HttpMethod.PUT)
    public Database updateDatabase(@Named("id") String id, Database database)
            throws NotFoundException, ServiceUnavailableException    {
        logger.info("DATABASE: update");

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            Entity datab = datastore.get(myKey);
            datab.setUnindexedProperty("nomedb", database.getNomedb());
            datab.setUnindexedProperty("project", database.getProject());
            datab.setUnindexedProperty("namespace", database.getNamespace());
            datab.setUnindexedProperty("mainrepo", database.getMainrepo());
            datab.setProperty("deleted", database.getDeleted());
            datastore.put(datab);
        } catch (EntityNotFoundException e) {
            logger.warning("DATABASE: not found " + id);
            logger.warning("DATABASE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("database non trovato " + id);
        } catch (Exception e) {
            logger.severe("DATABASE: errore " + id);
            logger.severe("DATABASE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("il database non esiste " + id);
        }

        return database;
    }

    /**
     *
     */
    @ApiMethod(name = "deleteDatabase",
               path = "deleteDatabase",
               httpMethod = ApiMethod.HttpMethod.DELETE)
    public Database deleteDatabase(@Named("id") String id, Database database)
            throws NotFoundException {
        logger.info("DATABASE: delete");

        try {
            NamespaceManager.set("iclub");
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

            Key myKey = KeyFactory.stringToKey(id);
            datastore.delete(myKey);
        } catch (Exception e) {
            logger.severe("DATABASE: errore " + id);
            logger.severe("DATABASE: not found " + e.getMessage());
            e.printStackTrace();
            throw new NotFoundException("il database non esiste " + id);
        }

        return database;
    }
}