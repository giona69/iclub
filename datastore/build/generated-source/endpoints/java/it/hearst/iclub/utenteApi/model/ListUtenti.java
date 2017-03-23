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
 * on 2017-03-22 at 10:54:13 UTC 
 * Modify at your own risk.
 */

package it.hearst.iclub.utenteApi.model;

/**
 * Model definition for ListUtenti.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the utenteApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class ListUtenti extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<Utente> listUtente;

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<Utente> getListUtente() {
    return listUtente;
  }

  /**
   * @param listUtente listUtente or {@code null} for none
   */
  public ListUtenti setListUtente(java.util.List<Utente> listUtente) {
    this.listUtente = listUtente;
    return this;
  }

  @Override
  public ListUtenti set(String fieldName, Object value) {
    return (ListUtenti) super.set(fieldName, value);
  }

  @Override
  public ListUtenti clone() {
    return (ListUtenti) super.clone();
  }

}
