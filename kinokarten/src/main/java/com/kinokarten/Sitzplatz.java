package com.kinokarten;

public class Sitzplatz {
    private Saal _saal;
    private int _reihe;
    private int _sitzNummer;
    private Reservierung _reservierung;

    public Sitzplatz(Saal _saal, int _reihe, int _sitzNummer) {
        this._saal = _saal;
        this._reihe = _reihe;
        this._sitzNummer = _sitzNummer;
    }

    public Saal get_saal() {
        return _saal;
    }

    public int get_reihe() {
        return _reihe;
    }

    public int get_sitzNummer() {
        return _sitzNummer;
    }

    public Reservierung get_reservierung() {
        return _reservierung;
    }  

    public boolean set_reservierung(Reservierung _reservierung){
        boolean result = false;
        if(_reservierung != null) {
            result = true;
            this._reservierung = _reservierung;
        }            
        return result;
    }

    public void remove_reservierung(){
        this._reservierung = null;
    }
    
    public boolean get_isReserviert(){
        return _reservierung != null;
    }    
}
