package com.kinokarten.Managers;

import java.util.ArrayList;
import java.util.List;

import com.kinokarten.Factories.FilmFactory;
import com.kinokarten.Objects.FSK;
import com.kinokarten.Objects.Film;

public class FilmManager {
    FilmFactory _filmFactory;
    List<Film> _filme;

    public FilmManager() {
        this._filme = new ArrayList<Film>();
        this._filmFactory = new FilmFactory();
    }

    public List<Film> get_filme() {
        return _filme;
    }

    public void addFilm(String titel, int dauer, FSK fsk){
        _filme.add(_filmFactory.Create(titel, dauer, fsk));
    }
    
}
