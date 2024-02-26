package com.kinokarten.Objects;
/**
 * Bildet den Film
 */
public class Film {

    private String _titel;
    private int _dauer;
    private FSK _altersBeschraenkung;  
    /**
     * Constructor für den Film
     * @param _titel Angabe des Titels
     * @param _daurer Angabe der Filmdauer
     * @param _altersBeschraenkung Angabe der Altersbeschraenkung
     */
    public Film(String _titel, int _daurer, FSK _altersBeschraenkung) {
        this._titel = _titel;
        this._dauer = _daurer;
        this._altersBeschraenkung = _altersBeschraenkung;
    }    

    public String get_titel() {
        return _titel;
    }

    public int get_dauer() {
        return _dauer;
    }

    public FSK get_altersBeschraenkung() {
        return _altersBeschraenkung;
    }

    @Override
    public String toString(){
        return "Titel:" + this._titel+ " | " + "Dauer: "+this._dauer+ " Min" + " | " + "FSK: " + _altersBeschraenkung;
    }
}
