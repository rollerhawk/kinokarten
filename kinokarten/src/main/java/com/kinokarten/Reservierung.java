package com.kinokarten;

import java.util.ArrayList;
import java.util.List;
/**
 * Bildet die Reservierung ab
 */
public class Reservierung {
    private long _reservierungsNr;
    private Kunde _kunde;
    private Termin _termin;
    private List<Sitzplatz> _sitzplaetze;

    /**
     * 
     * @param _reservierungsNr
     * @param _kunde
     * @param _termin
     */

    public Reservierung(long _reservierungsNr, Kunde _kunde, Termin _termin) {
        this._reservierungsNr = _reservierungsNr;
        this._kunde = _kunde;
        this._termin = _termin;
        this._sitzplaetze = new ArrayList<Sitzplatz>();
        /**
         * Zieht sich alle Attribute die die Reservierung benötigt
         */
    }    

    public Saal get_saal(){
        return this._termin.get_saal();
        /**
         * Erhält den Saal zu dem Termin
         */
    }
 
    public long get_reservierungsNr() {
        return _reservierungsNr;
        /**
         * Erhält die Reservierungs Nummer
         */
    }

    public Kunde get_kunde() {
        return _kunde;
        /**
         * Erhält den Kunden der reserviert hat
         */
    }

    public List<Sitzplatz> get_sitzplaetze() {
        return _sitzplaetze;
        /**
         * Erhält eine Liste an Sitzplätzen
         */
    }

    public Termin get_termin() {
        return _termin;
        /**
         * Bekommt den Termin zur Reservierung
         */
    }   
    
}
