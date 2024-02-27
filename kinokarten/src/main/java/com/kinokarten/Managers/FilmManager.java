package com.kinokarten.Managers;

import java.util.ArrayList;
import java.util.List;

import com.kinokarten.Factories.FilmFactory;
import com.kinokarten.Objects.FSK;
import com.kinokarten.Objects.Film;
/**
 * Erstellung des Grundgerüsts des Films, hier befindet sich die Logik der Erstellung eines Films 
 */
public class FilmManager {
    FilmFactory _filmFactory;
    List<Film> _filme;

    /**
     * Constructor der Filme festlegt 
     */
    public FilmManager() {
        this._filme = new ArrayList<Film>();
        this._filmFactory = new FilmFactory();
    }

    /**
     * Rückgabe einer Liste der Filme
     * @return List mit allen Filmen
     */
    public List<Film> get_filme() {
        return _filme;
    }

    /**
     * Hinzufügung eines Films
     * @param titel Angabe des Titels
     * @param dauer Angabe der Dauer
     * @param fsk Angabe der Altersbeschränkung
     */
    public void addFilm(String titel, int dauer, FSK fsk){
        _filme.add(_filmFactory.Create(titel, dauer, fsk));
    }
    
}
