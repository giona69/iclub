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
 * on 2017-03-20 at 12:07:10 UTC 
 * Modify at your own risk.
 */

package it.hearst.iclub.databaseApi.model;

/**
 * Model definition for Database.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the databaseApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Database extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean deleted;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean mainrepo;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String namespace;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String nomedb;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String project;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer userCount;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getDeleted() {
    return deleted;
  }

  /**
   * @param deleted deleted or {@code null} for none
   */
  public Database setDeleted(java.lang.Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Database setId(java.lang.String id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getMainrepo() {
    return mainrepo;
  }

  /**
   * @param mainrepo mainrepo or {@code null} for none
   */
  public Database setMainrepo(java.lang.Boolean mainrepo) {
    this.mainrepo = mainrepo;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getNamespace() {
    return namespace;
  }

  /**
   * @param namespace namespace or {@code null} for none
   */
  public Database setNamespace(java.lang.String namespace) {
    this.namespace = namespace;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getNomedb() {
    return nomedb;
  }

  /**
   * @param nomedb nomedb or {@code null} for none
   */
  public Database setNomedb(java.lang.String nomedb) {
    this.nomedb = nomedb;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getProject() {
    return project;
  }

  /**
   * @param project project or {@code null} for none
   */
  public Database setProject(java.lang.String project) {
    this.project = project;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getUserCount() {
    return userCount;
  }

  /**
   * @param userCount userCount or {@code null} for none
   */
  public Database setUserCount(java.lang.Integer userCount) {
    this.userCount = userCount;
    return this;
  }

  @Override
  public Database set(String fieldName, Object value) {
    return (Database) super.set(fieldName, value);
  }

  @Override
  public Database clone() {
    return (Database) super.clone();
  }

}
