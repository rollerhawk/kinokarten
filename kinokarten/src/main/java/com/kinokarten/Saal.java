package com.kinokarten;

import java.util.ArrayList;
import java.util.List;

/**
 * Bildet den Saal ab
 */
public class Saal {
    private int _saalnummer;
    private List<Termin> _termine;
    private List<Sitzplatz> _sitzplaetze;

    /**
     * Constructor für den Saal
     * @param _saalnummer Die Saalnummer
     */
    //Constructor
    public Saal(int _saalnummer) {
        this._saalnummer = _saalnummer;
        this._termine = new ArrayList<Termin>();
        this._sitzplaetze = new ArrayList<Sitzplatz>();
    }

    /**
     * Erhält die Saalnummer
     * @return Gibt die Saalnummer herraus
     */
    public int get_saalnummer() {
        return _saalnummer;
    }
    /**
     * Erhält eine Liste der Termine die im Saal stattfinden
     * @return Gibt uns die Termine zurück
     */
    public List<Termin> get_termine() {
        return _termine;
    }
    /**
     * Erhält eine Liste der Sitzplätze des Saals ab
     * @return Gibt uns die Sitzplätze herraus
     */
    public List<Sitzplatz> get_sitzplaetze() {
        return _sitzplaetze;
    }
    
}
