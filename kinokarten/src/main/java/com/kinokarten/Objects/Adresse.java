package com.kinokarten.Objects;
/**
 * Bildet die Adresse des Kinos ab 
 */
public class Adresse {
    private String _Land;
    private String _Ort;
    private String _PLZ;
    private String _Straße;
    private String _Hausnummer;
    public Adresse(String _Land, String _Ort, String _PLZ, String _Straße, String _Hausnummer) {
        this._Land = _Land;
        this._Ort = _Ort;
        this._PLZ = _PLZ;
        this._Straße = _Straße;
        this._Hausnummer = _Hausnummer;
    }
    
    
    
}