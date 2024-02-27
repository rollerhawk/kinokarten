package com.kinokarten.Objects;

import java.time.LocalDateTime;

import com.kinokarten.Managers.SitzplatzManager;
/**
 * Bildet den Termin
 */
public class Termin {
    private Film _film;
    private Saal _saal;
    private LocalDateTime _startUhrzeit;   
    private LocalDateTime _endUhrzeit;
    private SitzplatzManager _sitzplatzManager;


    public SitzplatzManager get_sitzplatzManager() {
        return _sitzplatzManager;
    }

    /**
     * Erstellt eine neue Instanz vom Termin
     * @param _film Das Film
     * @param _saal Der Saal
     * @param _startUhrzeit Die Start Uhrzeit
     * @param _endUhrzeit Die End Uhrzeit
     */
    public Termin(Film _film, Saal _saal, LocalDateTime _startUhrzeit, LocalDateTime _endUhrzeit) {
        this._film = _film;
        this._saal = _saal;
        this._startUhrzeit = _startUhrzeit;
        this._endUhrzeit = _endUhrzeit;
        this._sitzplatzManager = new SitzplatzManager(_saal);
    }

    /**
     * Erhält die Start Uhrzeit des Termins
     * @return Rückgabe der Start Uhrzeit
     */
    public LocalDateTime get_startUhrzeit() {
        return _startUhrzeit;
    }
    
    public void set_startUhrzeit(LocalDateTime _startUhrzeit) {
        this._startUhrzeit = _startUhrzeit;
    }

    /**
     * Erhält den Film
     * @return Rückgabe des Films
     */
    public Film getFilm() {  
        return _film;
    }

    /**
     * Erhält den Saal
     * @return Rückgabe des Saals
     */
    public Saal get_saal() {
        return _saal;
    }

    /**
     * Erhält die Schluss Uhrzeit des Termins
     * @return Rückgabe der Schluss Uhrzeit
     */
    public LocalDateTime get_endUhrzeit() {
        return _endUhrzeit;
    }
    
    @Override
    public String toString(){
        return "Saal:" + _saal.get_saalnummer() + " | " + "Film: "+_film+ " | " + "Start: " + _startUhrzeit + " | " + "Ende: " + _endUhrzeit;
    }
}
