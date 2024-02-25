package com.kinokarten;

import java.time.LocalDateTime;

public class Termin {
    private Film _film;
    private Saal _saal;
    private LocalDateTime _startUhrzeit;   
    private LocalDateTime _endUhrzeit;

    public LocalDateTime get_startUhrzeit() {
        return _startUhrzeit;
    }

    public void set_startUhrzeit(LocalDateTime _startUhrzeit) {
        this._startUhrzeit = _startUhrzeit;
    }

    public Film getFilm() {  
        return _film;
    }

    public Saal get_saal() {
        return _saal;
    }

    public LocalDateTime get_endUhrzeit() {
        return _endUhrzeit;
    }
    
}
