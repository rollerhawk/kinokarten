package com.kinokarten;

import java.util.ArrayList;
import java.util.List;

/**
 * Bildet das Kino ab
 */
public class Kino {
    private String _name;
    private Adresse _adresse;
    private List<Saal> _saale; 
    /**
     * Cunstructor für das Kino 
     * @param _name Der Name des Kinos 
     * @param _adresse Die Adresse des Kinos
     */
    public Kino(String _name, Adresse _adresse) {
        this._name = _name;
        this._adresse = _adresse;
        this._saale = new ArrayList<Saal>();
    }

    /**
     * Erhält den Namen
     * @return Gibt uns den Namen wieder 
     */
    public String get_name() {
        return _name;
    }
    /**
     * Erhält die Adresse
     * @return Gibt uns die Adresse wieder 
     */
    public Adresse get_adresse() {
        return _adresse;
    }
    /**
     * Gibt uns eine Liste der Sälle wieder 
     * @return Liste der Sälle
     */
    public List<Saal> get_saale() {
        return _saale;
    }

    
}