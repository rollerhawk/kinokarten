package com.kinokarten.Objects;
import java.util.ArrayList;
import java.util.List;

import com.kinokarten.Interfaces.BuildInterface;

/**
 * Bildet die Reservierung ab
 */
public class Reservierung implements BuildInterface {
    private long _reservierungsNr;
    private Kunde _kunde;
    private Termin _termin;
    private List<Sitzplatz> _sitzplaetze;

    /**
     * 
     * @param _reservierungsNr Die reservierungs Nummer
     * @param _kunde Der Kunde
     * @param _termin Der Termin
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

    /**
     * Erhält den Saal zu dem Termin
     */
    public Saal get_saal(){
        return this._termin.get_saal();
        
    }
    /**
     * Erhält die Reservierungs Nummer
     */
    public long get_reservierungsNr() {
        return _reservierungsNr;
        
    }

    /**
     * Erhält den Kunden der reserviert hat
     */
    public Kunde get_kunde() {
        return _kunde;
        
    }

    /**
     * Erhält eine Liste an Sitzplätzen
     */
    public List<Sitzplatz> get_sitzplaetze() {
        return _sitzplaetze;
        
    }

    /**
     * Bekommt den Termin zur Reservierung
     */
    public Termin get_termin() {
        return _termin;
        
    }


    public void Build() {
        
    }   
    
}
