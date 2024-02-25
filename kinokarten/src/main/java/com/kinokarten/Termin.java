package com.kinokarten;

import java.time.LocalDateTime;
/**
 * Bildet den Termin
 */
public class Termin {
    private Film _film;
    private Saal _saal;
    private LocalDateTime _startUhrzeit;   
    private LocalDateTime _endUhrzeit;

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
    
}
