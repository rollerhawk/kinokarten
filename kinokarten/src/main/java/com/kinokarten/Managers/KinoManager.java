package com.kinokarten.Managers;

import com.kinokarten.Objects.FSK;
import com.kinokarten.Objects.Kino;

public class KinoManager {
    private Kino _kino;
    private SaalManager _saalManager;

    private FilmManager _filmManager;

    public FilmManager get_filmManager() {
        return _filmManager;
    }

    public SaalManager get_saalManager() {
        return _saalManager;
    }

    public KinoManager(Kino _kino) {
        this._kino = _kino;
        this._saalManager = new SaalManager(_kino);
        this._filmManager = new FilmManager();
    }

    public boolean addNewSaal(int _anzahlReihen, int _anzahlSitzeProReihe){
        return _saalManager.addNewSaal(_anzahlReihen, _anzahlSitzeProReihe);
    }

    public void addNewFilm(String titel, int dauer, FSK fsk){
        _filmManager.addFilm(titel, dauer, fsk);
    }
    
}
