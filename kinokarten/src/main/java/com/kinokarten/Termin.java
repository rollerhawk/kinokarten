package com.kinokarten;

import java.time.LocalDateTime;

public class Termin {
    public Film _film;
    public Saal _saal;
    private LocalDateTime _startUhrzeit;
    public LocalDateTime get_startUhrzeit() {
        return _startUhrzeit;
    }

    public void set_startUhrzeit(LocalDateTime _startUhrzeit) {
        this._startUhrzeit = _startUhrzeit;
    }

    private LocalDateTime _endUhrzeit;

    public Film getFilm() {  
        return _film;
    }
    
}
