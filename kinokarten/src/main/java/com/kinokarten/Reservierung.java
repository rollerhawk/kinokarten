package com.kinokarten;

import java.util.ArrayList;
import java.util.List;

public class Reservierung {
    private long _reservierungsNr;
    private Kunde _kunde;
    private Termin _termin;
    private List<Sitzplatz> _sitzplaetze;

    public Reservierung(long _reservierungsNr, Kunde _kunde, Termin _termin) {
        this._reservierungsNr = _reservierungsNr;
        this._kunde = _kunde;
        this._termin = _termin;
        this._sitzplaetze = new ArrayList<Sitzplatz>();
    }    

    public Saal get_saal(){
        return this._termin.get_saal();
    }

    public long get_reservierungsNr() {
        return _reservierungsNr;
    }

    public Kunde get_kunde() {
        return _kunde;
    }

    public List<Sitzplatz> get_sitzplaetze() {
        return _sitzplaetze;
    }

    public Termin get_termin() {
        return _termin;
    }   
    
}
