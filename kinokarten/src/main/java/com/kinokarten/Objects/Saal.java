package com.kinokarten.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Bildet den Saal ab
 */
public class Saal {
    private long _saalnummer;
    private Kino _kino;
    private List<Termin> _termine;
    private List<Sitzplatz> _sitzplaetze;

    /**
     * Constructor für den Saal
     * @param _saalnummer Die Saalnummer
     */    
    public Saal(Kino _kino, long _saalnummer) {
        this._kino = _kino;
        this._saalnummer = _saalnummer;
        this._termine = new ArrayList<Termin>();
        this._sitzplaetze = new ArrayList<Sitzplatz>();
    }

    /**
     * Erhält das Kino
     * @return Gibt das Kino gerraus
     */
    public Kino get_kino() {
        return _kino;
    }    

    /**
     * Erhält die Saalnummer
     * @return Gibt die Saalnummer herraus
     */
    public long get_saalnummer() {
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
