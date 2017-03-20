/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2017-02-15 17:18:02 UTC)
 * on 2017-03-20 at 12:07:11 UTC 
 * Modify at your own risk.
 */

package it.hearst.iclub.utenteApi;

/**
 * Service definition for UtenteApi (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link UtenteApiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class UtenteApi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.22.0 of the utenteApi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myApplicationId.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "utenteApi/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public UtenteApi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  UtenteApi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "deleteUtente".
   *
   * This request holds the parameters needed by the utenteApi server.  After setting any optional
   * parameters, call the {@link DeleteUtente#execute()} method to invoke the remote operation.
   *
   * @param id
   * @param ns
   * @param content the {@link it.hearst.iclub.utenteApi.model.Utente}
   * @return the request
   */
  public DeleteUtente deleteUtente(java.lang.String id, java.lang.String ns, it.hearst.iclub.utenteApi.model.Utente content) throws java.io.IOException {
    DeleteUtente result = new DeleteUtente(id, ns, content);
    initialize(result);
    return result;
  }

  public class DeleteUtente extends UtenteApiRequest<it.hearst.iclub.utenteApi.model.Utente> {

    private static final String REST_PATH = "deleteUtente";

    /**
     * Create a request for the method "deleteUtente".
     *
     * This request holds the parameters needed by the the utenteApi server.  After setting any
     * optional parameters, call the {@link DeleteUtente#execute()} method to invoke the remote
     * operation. <p> {@link
     * DeleteUtente#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @param ns
     * @param content the {@link it.hearst.iclub.utenteApi.model.Utente}
     * @since 1.13
     */
    protected DeleteUtente(java.lang.String id, java.lang.String ns, it.hearst.iclub.utenteApi.model.Utente content) {
      super(UtenteApi.this, "DELETE", REST_PATH, content, it.hearst.iclub.utenteApi.model.Utente.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      this.ns = com.google.api.client.util.Preconditions.checkNotNull(ns, "Required parameter ns must be specified.");
    }

    @Override
    public DeleteUtente setAlt(java.lang.String alt) {
      return (DeleteUtente) super.setAlt(alt);
    }

    @Override
    public DeleteUtente setFields(java.lang.String fields) {
      return (DeleteUtente) super.setFields(fields);
    }

    @Override
    public DeleteUtente setKey(java.lang.String key) {
      return (DeleteUtente) super.setKey(key);
    }

    @Override
    public DeleteUtente setOauthToken(java.lang.String oauthToken) {
      return (DeleteUtente) super.setOauthToken(oauthToken);
    }

    @Override
    public DeleteUtente setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (DeleteUtente) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public DeleteUtente setQuotaUser(java.lang.String quotaUser) {
      return (DeleteUtente) super.setQuotaUser(quotaUser);
    }

    @Override
    public DeleteUtente setUserIp(java.lang.String userIp) {
      return (DeleteUtente) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public DeleteUtente setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String ns;

    /**

     */
    public java.lang.String getNs() {
      return ns;
    }

    public DeleteUtente setNs(java.lang.String ns) {
      this.ns = ns;
      return this;
    }

    @Override
    public DeleteUtente set(String parameterName, Object value) {
      return (DeleteUtente) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getUtente".
   *
   * This request holds the parameters needed by the utenteApi server.  After setting any optional
   * parameters, call the {@link GetUtente#execute()} method to invoke the remote operation.
   *
   * @param id
   * @param ns
   * @return the request
   */
  public GetUtente getUtente(java.lang.String id, java.lang.String ns) throws java.io.IOException {
    GetUtente result = new GetUtente(id, ns);
    initialize(result);
    return result;
  }

  public class GetUtente extends UtenteApiRequest<it.hearst.iclub.utenteApi.model.Utente> {

    private static final String REST_PATH = "getUtente";

    /**
     * Create a request for the method "getUtente".
     *
     * This request holds the parameters needed by the the utenteApi server.  After setting any
     * optional parameters, call the {@link GetUtente#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetUtente#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @param ns
     * @since 1.13
     */
    protected GetUtente(java.lang.String id, java.lang.String ns) {
      super(UtenteApi.this, "GET", REST_PATH, null, it.hearst.iclub.utenteApi.model.Utente.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      this.ns = com.google.api.client.util.Preconditions.checkNotNull(ns, "Required parameter ns must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetUtente setAlt(java.lang.String alt) {
      return (GetUtente) super.setAlt(alt);
    }

    @Override
    public GetUtente setFields(java.lang.String fields) {
      return (GetUtente) super.setFields(fields);
    }

    @Override
    public GetUtente setKey(java.lang.String key) {
      return (GetUtente) super.setKey(key);
    }

    @Override
    public GetUtente setOauthToken(java.lang.String oauthToken) {
      return (GetUtente) super.setOauthToken(oauthToken);
    }

    @Override
    public GetUtente setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetUtente) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetUtente setQuotaUser(java.lang.String quotaUser) {
      return (GetUtente) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetUtente setUserIp(java.lang.String userIp) {
      return (GetUtente) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetUtente setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String ns;

    /**

     */
    public java.lang.String getNs() {
      return ns;
    }

    public GetUtente setNs(java.lang.String ns) {
      this.ns = ns;
      return this;
    }

    @Override
    public GetUtente set(String parameterName, Object value) {
      return (GetUtente) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "importUtente".
   *
   * This request holds the parameters needed by the utenteApi server.  After setting any optional
   * parameters, call the {@link ImportUtente#execute()} method to invoke the remote operation.
   *
   * @param ns
   * @param content the {@link it.hearst.iclub.utenteApi.model.ListUtenti}
   * @return the request
   */
  public ImportUtente importUtente(java.lang.String ns, it.hearst.iclub.utenteApi.model.ListUtenti content) throws java.io.IOException {
    ImportUtente result = new ImportUtente(ns, content);
    initialize(result);
    return result;
  }

  public class ImportUtente extends UtenteApiRequest<it.hearst.iclub.utenteApi.model.Entity> {

    private static final String REST_PATH = "importUtente";

    /**
     * Create a request for the method "importUtente".
     *
     * This request holds the parameters needed by the the utenteApi server.  After setting any
     * optional parameters, call the {@link ImportUtente#execute()} method to invoke the remote
     * operation. <p> {@link
     * ImportUtente#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param ns
     * @param content the {@link it.hearst.iclub.utenteApi.model.ListUtenti}
     * @since 1.13
     */
    protected ImportUtente(java.lang.String ns, it.hearst.iclub.utenteApi.model.ListUtenti content) {
      super(UtenteApi.this, "POST", REST_PATH, content, it.hearst.iclub.utenteApi.model.Entity.class);
      this.ns = com.google.api.client.util.Preconditions.checkNotNull(ns, "Required parameter ns must be specified.");
    }

    @Override
    public ImportUtente setAlt(java.lang.String alt) {
      return (ImportUtente) super.setAlt(alt);
    }

    @Override
    public ImportUtente setFields(java.lang.String fields) {
      return (ImportUtente) super.setFields(fields);
    }

    @Override
    public ImportUtente setKey(java.lang.String key) {
      return (ImportUtente) super.setKey(key);
    }

    @Override
    public ImportUtente setOauthToken(java.lang.String oauthToken) {
      return (ImportUtente) super.setOauthToken(oauthToken);
    }

    @Override
    public ImportUtente setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ImportUtente) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ImportUtente setQuotaUser(java.lang.String quotaUser) {
      return (ImportUtente) super.setQuotaUser(quotaUser);
    }

    @Override
    public ImportUtente setUserIp(java.lang.String userIp) {
      return (ImportUtente) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String ns;

    /**

     */
    public java.lang.String getNs() {
      return ns;
    }

    public ImportUtente setNs(java.lang.String ns) {
      this.ns = ns;
      return this;
    }

    @Override
    public ImportUtente set(String parameterName, Object value) {
      return (ImportUtente) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertUtente".
   *
   * This request holds the parameters needed by the utenteApi server.  After setting any optional
   * parameters, call the {@link InsertUtente#execute()} method to invoke the remote operation.
   *
   * @param ns
   * @param content the {@link it.hearst.iclub.utenteApi.model.Utente}
   * @return the request
   */
  public InsertUtente insertUtente(java.lang.String ns, it.hearst.iclub.utenteApi.model.Utente content) throws java.io.IOException {
    InsertUtente result = new InsertUtente(ns, content);
    initialize(result);
    return result;
  }

  public class InsertUtente extends UtenteApiRequest<it.hearst.iclub.utenteApi.model.Utente> {

    private static final String REST_PATH = "insertUtente";

    /**
     * Create a request for the method "insertUtente".
     *
     * This request holds the parameters needed by the the utenteApi server.  After setting any
     * optional parameters, call the {@link InsertUtente#execute()} method to invoke the remote
     * operation. <p> {@link
     * InsertUtente#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param ns
     * @param content the {@link it.hearst.iclub.utenteApi.model.Utente}
     * @since 1.13
     */
    protected InsertUtente(java.lang.String ns, it.hearst.iclub.utenteApi.model.Utente content) {
      super(UtenteApi.this, "POST", REST_PATH, content, it.hearst.iclub.utenteApi.model.Utente.class);
      this.ns = com.google.api.client.util.Preconditions.checkNotNull(ns, "Required parameter ns must be specified.");
    }

    @Override
    public InsertUtente setAlt(java.lang.String alt) {
      return (InsertUtente) super.setAlt(alt);
    }

    @Override
    public InsertUtente setFields(java.lang.String fields) {
      return (InsertUtente) super.setFields(fields);
    }

    @Override
    public InsertUtente setKey(java.lang.String key) {
      return (InsertUtente) super.setKey(key);
    }

    @Override
    public InsertUtente setOauthToken(java.lang.String oauthToken) {
      return (InsertUtente) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertUtente setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertUtente) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertUtente setQuotaUser(java.lang.String quotaUser) {
      return (InsertUtente) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertUtente setUserIp(java.lang.String userIp) {
      return (InsertUtente) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String ns;

    /**

     */
    public java.lang.String getNs() {
      return ns;
    }

    public InsertUtente setNs(java.lang.String ns) {
      this.ns = ns;
      return this;
    }

    @Override
    public InsertUtente set(String parameterName, Object value) {
      return (InsertUtente) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listUtente".
   *
   * This request holds the parameters needed by the utenteApi server.  After setting any optional
   * parameters, call the {@link ListUtente#execute()} method to invoke the remote operation.
   *
   * @param ns
   * @return the request
   */
  public ListUtente listUtente(java.lang.String ns) throws java.io.IOException {
    ListUtente result = new ListUtente(ns);
    initialize(result);
    return result;
  }

  public class ListUtente extends UtenteApiRequest<it.hearst.iclub.utenteApi.model.CollectionResponseUtente> {

    private static final String REST_PATH = "listUtente";

    /**
     * Create a request for the method "listUtente".
     *
     * This request holds the parameters needed by the the utenteApi server.  After setting any
     * optional parameters, call the {@link ListUtente#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListUtente#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param ns
     * @since 1.13
     */
    protected ListUtente(java.lang.String ns) {
      super(UtenteApi.this, "GET", REST_PATH, null, it.hearst.iclub.utenteApi.model.CollectionResponseUtente.class);
      this.ns = com.google.api.client.util.Preconditions.checkNotNull(ns, "Required parameter ns must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListUtente setAlt(java.lang.String alt) {
      return (ListUtente) super.setAlt(alt);
    }

    @Override
    public ListUtente setFields(java.lang.String fields) {
      return (ListUtente) super.setFields(fields);
    }

    @Override
    public ListUtente setKey(java.lang.String key) {
      return (ListUtente) super.setKey(key);
    }

    @Override
    public ListUtente setOauthToken(java.lang.String oauthToken) {
      return (ListUtente) super.setOauthToken(oauthToken);
    }

    @Override
    public ListUtente setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListUtente) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListUtente setQuotaUser(java.lang.String quotaUser) {
      return (ListUtente) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListUtente setUserIp(java.lang.String userIp) {
      return (ListUtente) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String ns;

    /**

     */
    public java.lang.String getNs() {
      return ns;
    }

    public ListUtente setNs(java.lang.String ns) {
      this.ns = ns;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListUtente setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListUtente set(String parameterName, Object value) {
      return (ListUtente) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "searchUtente".
   *
   * This request holds the parameters needed by the utenteApi server.  After setting any optional
   * parameters, call the {@link SearchUtente#execute()} method to invoke the remote operation.
   *
   * @param ns
   * @param search
   * @return the request
   */
  public SearchUtente searchUtente(java.lang.String ns, java.lang.String search) throws java.io.IOException {
    SearchUtente result = new SearchUtente(ns, search);
    initialize(result);
    return result;
  }

  public class SearchUtente extends UtenteApiRequest<it.hearst.iclub.utenteApi.model.CollectionResponseUtente> {

    private static final String REST_PATH = "searchUtente";

    /**
     * Create a request for the method "searchUtente".
     *
     * This request holds the parameters needed by the the utenteApi server.  After setting any
     * optional parameters, call the {@link SearchUtente#execute()} method to invoke the remote
     * operation. <p> {@link
     * SearchUtente#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param ns
     * @param search
     * @since 1.13
     */
    protected SearchUtente(java.lang.String ns, java.lang.String search) {
      super(UtenteApi.this, "GET", REST_PATH, null, it.hearst.iclub.utenteApi.model.CollectionResponseUtente.class);
      this.ns = com.google.api.client.util.Preconditions.checkNotNull(ns, "Required parameter ns must be specified.");
      this.search = com.google.api.client.util.Preconditions.checkNotNull(search, "Required parameter search must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public SearchUtente setAlt(java.lang.String alt) {
      return (SearchUtente) super.setAlt(alt);
    }

    @Override
    public SearchUtente setFields(java.lang.String fields) {
      return (SearchUtente) super.setFields(fields);
    }

    @Override
    public SearchUtente setKey(java.lang.String key) {
      return (SearchUtente) super.setKey(key);
    }

    @Override
    public SearchUtente setOauthToken(java.lang.String oauthToken) {
      return (SearchUtente) super.setOauthToken(oauthToken);
    }

    @Override
    public SearchUtente setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SearchUtente) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SearchUtente setQuotaUser(java.lang.String quotaUser) {
      return (SearchUtente) super.setQuotaUser(quotaUser);
    }

    @Override
    public SearchUtente setUserIp(java.lang.String userIp) {
      return (SearchUtente) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String ns;

    /**

     */
    public java.lang.String getNs() {
      return ns;
    }

    public SearchUtente setNs(java.lang.String ns) {
      this.ns = ns;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String search;

    /**

     */
    public java.lang.String getSearch() {
      return search;
    }

    public SearchUtente setSearch(java.lang.String search) {
      this.search = search;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public SearchUtente setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public SearchUtente set(String parameterName, Object value) {
      return (SearchUtente) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateUtente".
   *
   * This request holds the parameters needed by the utenteApi server.  After setting any optional
   * parameters, call the {@link UpdateUtente#execute()} method to invoke the remote operation.
   *
   * @param id
   * @param ns
   * @param content the {@link it.hearst.iclub.utenteApi.model.Utente}
   * @return the request
   */
  public UpdateUtente updateUtente(java.lang.String id, java.lang.String ns, it.hearst.iclub.utenteApi.model.Utente content) throws java.io.IOException {
    UpdateUtente result = new UpdateUtente(id, ns, content);
    initialize(result);
    return result;
  }

  public class UpdateUtente extends UtenteApiRequest<it.hearst.iclub.utenteApi.model.Utente> {

    private static final String REST_PATH = "updateUtente";

    /**
     * Create a request for the method "updateUtente".
     *
     * This request holds the parameters needed by the the utenteApi server.  After setting any
     * optional parameters, call the {@link UpdateUtente#execute()} method to invoke the remote
     * operation. <p> {@link
     * UpdateUtente#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @param ns
     * @param content the {@link it.hearst.iclub.utenteApi.model.Utente}
     * @since 1.13
     */
    protected UpdateUtente(java.lang.String id, java.lang.String ns, it.hearst.iclub.utenteApi.model.Utente content) {
      super(UtenteApi.this, "PUT", REST_PATH, content, it.hearst.iclub.utenteApi.model.Utente.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      this.ns = com.google.api.client.util.Preconditions.checkNotNull(ns, "Required parameter ns must be specified.");
    }

    @Override
    public UpdateUtente setAlt(java.lang.String alt) {
      return (UpdateUtente) super.setAlt(alt);
    }

    @Override
    public UpdateUtente setFields(java.lang.String fields) {
      return (UpdateUtente) super.setFields(fields);
    }

    @Override
    public UpdateUtente setKey(java.lang.String key) {
      return (UpdateUtente) super.setKey(key);
    }

    @Override
    public UpdateUtente setOauthToken(java.lang.String oauthToken) {
      return (UpdateUtente) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateUtente setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateUtente) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateUtente setQuotaUser(java.lang.String quotaUser) {
      return (UpdateUtente) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateUtente setUserIp(java.lang.String userIp) {
      return (UpdateUtente) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public UpdateUtente setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String ns;

    /**

     */
    public java.lang.String getNs() {
      return ns;
    }

    public UpdateUtente setNs(java.lang.String ns) {
      this.ns = ns;
      return this;
    }

    @Override
    public UpdateUtente set(String parameterName, Object value) {
      return (UpdateUtente) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link UtenteApi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link UtenteApi}. */
    @Override
    public UtenteApi build() {
      return new UtenteApi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link UtenteApiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setUtenteApiRequestInitializer(
        UtenteApiRequestInitializer utenteapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(utenteapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
