package com.kinokarten;

import java.util.ArrayList;
import java.util.List;

public class Reservierung {
    private long _reservierungsNr;
    private Kunde _kunde;
    private List<Sitzplatz> _sitzplaetze;

    public Reservierung(long _reservierungsNr, Kunde _kunde) {
        this._reservierungsNr = _reservierungsNr;
        this._kunde = _kunde;
        this._sitzplaetze = new ArrayList<Sitzplatz>();
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
    
}
