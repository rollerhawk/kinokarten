package com.kinokarten.Factories;

import java.time.LocalDateTime;

import com.kinokarten.Objects.Film;
import com.kinokarten.Objects.Saal;
import com.kinokarten.Objects.Termin;
/**
 * Erzeugt dem Termin
 */
public class TerminFactory {
    public static Termin Create(Film film, Saal saal, LocalDateTime startZeit, LocalDateTime endZeit){
        Termin termin = new Termin(film, saal, startZeit, endZeit);
        return termin;
    }
}
