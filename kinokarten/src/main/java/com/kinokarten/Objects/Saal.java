package com.kinokarten.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Bildet den Saal ab
 */
public class Saal {
    private long _saalnummer;
    private int _anzahlReihen;
    private int _anzahlSitzeProReihe;
    private Kino _kino;
    private List<Termin> _termine;

    /**
     * Constructor für den Saal
     * @param _saalnummer Die Saalnummer
     */    
    public Saal(Kino _kino, long _saalnummer, int _anzahlReihen, int _anzahlSitzeProReihe) {
        this._kino = _kino;
        this._saalnummer = _saalnummer;
        this._anzahlReihen = _anzahlReihen;
        this._anzahlSitzeProReihe = _anzahlSitzeProReihe;
        this._termine = new ArrayList<Termin>();
    }

    public int get_anzahlSitzeProReihe() {
        return _anzahlSitzeProReihe;
    }

    public int get_anzahlReihen() {
        return _anzahlReihen;
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
}
