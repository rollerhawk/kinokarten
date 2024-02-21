package com.kinokarten;

import java.util.ArrayList;
import java.util.List;

public class Kino {
    private String _name;
    private Adresse _adresse;
    private List<Saal> _saale; 
            
    public Kino(String _name, Adresse _adresse) {
        this._name = _name;
        this._adresse = _adresse;
        this._saale = new ArrayList<Saal>();
    }
    public String get_name() {
        return _name;
    }
    public Adresse get_adresse() {
        return _adresse;
    }
    public List<Saal> get_saale() {
        return _saale;
    }

    
}