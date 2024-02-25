package com.kinokarten.Objects;
/**
 * Bildet den Film
 */
public class Film {

    private String _titel;
    private int _daurer;
    private FSK _altersBeschraenkung;  

    public Film(String _titel, int _daurer, FSK _altersBeschraenkung) {
        this._titel = _titel;
        this._daurer = _daurer;
        this._altersBeschraenkung = _altersBeschraenkung;
    }    

    public String get_titel() {
        return _titel;
    }

    public int get_daurer() {
        return _daurer;
    }

    public FSK get_altersBeschraenkung() {
        return _altersBeschraenkung;
    }
}
