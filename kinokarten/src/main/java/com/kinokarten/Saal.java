package com.kinokarten;

import java.util.ArrayList;
import java.util.List;

public class Saal {
    private int _saalnummer;
    private List<Termin> _termine;
    private List<Sitzplatz> _sitzplaetze;

    //Constructor
    public Saal(int _saalnummer) {
        this._saalnummer = _saalnummer;
        this._termine = new ArrayList<Termin>();
        this._sitzplaetze = new ArrayList<Sitzplatz>();
    }

    public int get_saalnummer() {
        return _saalnummer;
    }
    public List<Termin> get_termine() {
        return _termine;
    }
    public List<Sitzplatz> get_sitzplaetze() {
        return _sitzplaetze;
    }
    
}
