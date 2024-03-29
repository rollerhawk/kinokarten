package com.kinokarten.Factories;

import com.kinokarten.Objects.FSK;
import com.kinokarten.Objects.Film;
/**
 * Erzeugt den Film
 */
public class FilmFactory {
    
    /** 
     * @param titel
     * @param dauer
     * @param fsk
     * @return Film
     */
    public Film Create(String titel, int dauer, FSK fsk){
        Film film = new Film(titel, dauer, fsk);
        return film;
    }
}
