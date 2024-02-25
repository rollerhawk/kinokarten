package com.kinokarten;
/**
 * Bildet die Sitzplätze
 */
public class Sitzplatz {
    private Saal _saal;
    private int _reihe;
    private int _sitzNummer;
    private Reservierung _reservierung;

    /**
     * Cunstructor für den Saal, die Reihen und der Sitznummern
     * @param _saal
     * @param _reihe
     * @param _sitzNummer
     */

    public Sitzplatz(Saal _saal, int _reihe, int _sitzNummer) {
        this._saal = _saal;
        this._reihe = _reihe;
        this._sitzNummer = _sitzNummer;
    }
    /**
     * Erhält den Saal 
     * @return Rückgabe des Saals
     */
    public Saal get_saal() {
        return _saal;
    }
    /**
     * Erhält die Reihe im Saal
     * @return Rückgabe der Saal Reihe
     */
    public int get_reihe() {
        return _reihe;
    }

    /**
     * Erhält die Sitznummer
     * @return Rückgabe der Sitznummer
     */
    public int get_sitzNummer() {
        return _sitzNummer;
    }
    /**
     * Erhält die Reservierung
     * @return Rückgabe der Reservierung
     */

    public Reservierung get_reservierung() {
        return _reservierung;
    }  

    /**
     * Setzt die Reservierung 
     * @param _reservierung Die Reservierung
     * @return Zeigt an ob die Reservierung erfolgreich war oder nicht
     */
    public boolean set_reservierung(Reservierung _reservierung){
        boolean result = false;
        if(_reservierung != null) {
            result = true;
            this._reservierung = _reservierung;
        }            
        return result;
    }
    /**
     * Entfernt die Reservierung
     */
    public void remove_reservierung(){
        this._reservierung = null;
    }
    /**
     * Abfrage ob die Reservierung reserviert ist oder nicht 
     * @return true or false
     */
    public boolean get_isReserviert(){
        return _reservierung != null;
    }    
}
