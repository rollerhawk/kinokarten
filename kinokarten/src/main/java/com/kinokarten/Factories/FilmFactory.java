package com.kinokarten.Factories;

import com.kinokarten.Objects.FSK;
import com.kinokarten.Objects.Film;

public class FilmFactory {
    public Film Create(String titel, int dauer, FSK fsk){
        Film film = new Film(titel, dauer, fsk);
        return film;
    }
}
