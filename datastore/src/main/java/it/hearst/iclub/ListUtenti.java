package it.hearst.iclub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by granatag on 12/03/2017.
 */

public class ListUtenti {
    private Collection<Utente> listUtente;

    public ListUtenti() {
        this.listUtente = new ArrayList<Utente>() {{
        }};
    }

    public ListUtenti(Collection<Utente> utenti) {
        this.listUtente = utenti;
    }

    public Collection<Utente> getListUtente() {
        return this.listUtente;
    }

    public void setListUtente(Collection<Utente> utenti) {
        this.listUtente = utenti;
    }
}