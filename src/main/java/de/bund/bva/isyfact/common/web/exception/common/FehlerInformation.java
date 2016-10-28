/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * The Federal Office of Administration (Bundesverwaltungsamt, BVA)
 * licenses this file to you under the Apache License, Version 2.0 (the
 * License). You may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package de.bund.bva.isyfact.common.web.exception.common;

import de.bund.bva.isyfact.common.web.konstanten.FehlerSchluessel;
import de.bund.bva.pliscommon.exception.FehlertextProvider;

/**
 * Klasse beschreibt alle Informationen, die in einem Plis-Fehler vorhanden sind.
 *
 *
 */
public class FehlerInformation {

    /** Fehlertextprovider zum Auslesen von Fehlertexten. */
    private static final FehlertextProvider FEHLERTEXT_PROVIDER = new FehlertextProviderImpl();

    /** Fehlertypen. */
    public static enum Fehlertyp {

        /**
         * Fachlicher Fehler.
         */
        FACHLICH,

        /**
         * Technischer Fehler.
         */
        TECHNISCH;
    }

    /** die FehlerId des Fehlers. */
    private String fehlerId;

    /** die Unique-Id des Fehlers. */
    private String uuid;

    /** die Fehlernachricht des Fehlers. */
    private String fehlernachricht;

    /** der Typ des Fehlers. */
    private Fehlertyp typ;

    /**
     * Liefert das Feld {@link #fehlerId} zurück.
     * @return Wert von fehlerId
     */

    public String getFehlerId() {
        return this.fehlerId;
    }

    /**
     * Setzt das Feld {@link #fehlerId}.
     * @param fehlerId
     *            Neuer Wert für fehlerId
     */

    public void setFehlerId(String fehlerId) {
        this.fehlerId = fehlerId;
    }

    /**
     * Liefert das Feld {@link #uuid} zurück.
     * @return Wert von uuid
     */

    public String getUuid() {
        return this.uuid;
    }

    /**
     * Setzt das Feld {@link #uuid}.
     * @param uuid
     *            Neuer Wert für uuid
     */

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Liefert das Feld {@link #fehlernachricht} zurück.
     * @return Wert von fehlernachricht
     */

    public String getFehlernachricht() {
        return this.fehlernachricht;
    }

    /**
     * Setzt das Feld {@link #fehlernachricht}.
     * @param fehlernachricht
     *            Neuer Wert für fehlernachricht
     */

    public void setFehlernachricht(String fehlernachricht) {
        this.fehlernachricht = fehlernachricht;
    }

    /**
     * Liefert das Feld {@link #typ} zurück.
     * @return Wert von typ
     */

    public Fehlertyp getTyp() {
        return this.typ;
    }

    /**
     * Setzt das Feld {@link #typ}.
     * @param typ
     *            Neuer Wert für typ
     */

    public void setTyp(Fehlertyp typ) {
        this.typ = typ;
    }

    /**
     * Gibt die Fehlernachricht zurück, die durch Log4j geloggt werden soll.
     * @return die Fehlernachricht zurück, die durch Log4j geloggt werden soll
     */
    public String getErrorLogMessage() {
        if (this.typ == Fehlertyp.FACHLICH) {
            return FEHLERTEXT_PROVIDER.getMessage(FehlerSchluessel.FEHLERTEXT_LOG_FACHLICH,
                this.fehlernachricht, this.fehlerId, this.uuid);
        } else {
            return FEHLERTEXT_PROVIDER.getMessage(FehlerSchluessel.FEHLERTEXT_LOG_TECHNISCH,
                this.fehlernachricht, this.fehlerId, this.uuid);
        }
    }

    /**
     * Gibt die Fehlernachricht zurück, die auf der Gui angezeigt werden soll.
     * @return die Fehlernachricht zurück, die auf der Gui angezeigt werden soll.
     */
    public String getGuiErrorMessage() {
        if (this.typ == Fehlertyp.FACHLICH) {
            return FEHLERTEXT_PROVIDER.getMessage(FehlerSchluessel.FEHLERTEXT_GUI_FACHLICH,
                this.fehlernachricht, this.fehlerId, this.uuid);
        } else {
            return FEHLERTEXT_PROVIDER.getMessage(FehlerSchluessel.FEHLERTEXT_GUI_TECHNISCH, this.fehlerId,
                this.uuid);
        }
    }

    /**
     * Gibt den Titel der Fehlernachricht zurück, welcher auf der Gui angezeigt werden soll.
     * @return der Titel der Fehlernachricht, welcher auf der Gui angezeigt werden soll.
     */
    public String getGuiErrorMessageTitle() {
        if (this.typ == Fehlertyp.FACHLICH) {
            return FEHLERTEXT_PROVIDER.getMessage(FehlerSchluessel.FEHLERTEXT_GUI_FACHLICH_UEBERSCHRIFT,
                this.fehlernachricht, this.fehlerId, this.uuid);
        } else {
            return FEHLERTEXT_PROVIDER.getMessage(FehlerSchluessel.FEHLERTEXT_GUI_TECHNISCH_UEBERSCHRIFT,
                this.fehlerId, this.uuid);
        }
    }

}
