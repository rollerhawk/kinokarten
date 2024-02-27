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
     * @param _dauer Angabe der Filmdauer
     * @param _altersBeschraenkung Angabe der Altersbeschraenkung
     */
    public Film(String _titel, int _dauer, FSK _altersBeschraenkung) {
        this._titel = _titel;
        this._dauer = _dauer;
        this._altersBeschraenkung = _altersBeschraenkung;
    }    
    /**
     * Erhält den Titel des Films
     * @return Rückgabe des Film Titels
     */
    public String get_titel() {
        return _titel;
    }
    /**
     * Erhält die Dauer des Films
     * @return Rückgabe der Filmdauer
     */
    public int get_dauer() {
        return _dauer;
    }
    /**
     * Erhält die Altersbeschränkung
     * @return Gibt die Altersbeschränkung zurück
     */
    public FSK get_altersBeschraenkung() {
        return _altersBeschraenkung;
    }
}
