package com.kinokarten.Managers;

import com.kinokarten.Counter;
import com.kinokarten.Factories.KundeFactory;
import com.kinokarten.Factories.ReservierungFactory;
import com.kinokarten.Objects.FSK;
import com.kinokarten.Objects.Kino;
/**
 * Erstellung des Kinos, hier wird die Logik des aufbaus des Kinos verwaltet 
 */
public class KinoManager {
    private Kino _kino;
    private SaalManager _saalManager;
    private FilmManager _filmManager;
    private ReservierungFactory _reservierungFactory;
    private KundeFactory _kundeFactory;

    /**
     * Rückgabe des Filmmanagers
     * @return Ausgabe des Filmmanagers
     */
    public FilmManager get_filmManager() {
        return _filmManager;
    }

    /**
     * Erhält den Saalmanager 
     * @return Gibt den Saalmanager zurück
     */
    public SaalManager get_saalManager() {
        return _saalManager;
    }

    /**
     * Construktor für den Kinomanager
     * @param _kino Angabe des Kinos 
     */
    public KinoManager(Kino _kino) {
        this._kino = _kino;
        this._saalManager = new SaalManager(_kino);
        this._filmManager = new FilmManager();
        this._kundeFactory = new KundeFactory(new Counter());
        this._reservierungFactory = new ReservierungFactory(new Counter());
    }

    /**
     * Hinzufügung eines neuen Saals 
     * @param _anzahlReihen Angabe der Reihen
     * @param _anzahlSitzeProReihe Angabe der Sitze pro Reihe
     * @return Rückgabe eines Saals mit den angegebenen Reihen uns Sitzen 
     */
    public boolean addNewSaal(int _anzahlReihen, int _anzahlSitzeProReihe){
        return _saalManager.addNewSaal(_anzahlReihen, _anzahlSitzeProReihe);
    }

    /**
     * Hinzufügung eines neuen Films zum Filmmanager
     * @param titel Angabe der Filmtitels
     * @param dauer Angabe der Filmdauer
     * @param fsk Angabe der Altersbeschraenkung
     */
    public void addNewFilm(String titel, int dauer, FSK fsk){
         _filmManager.addFilm(titel, dauer, fsk);
    }
    
    /**
     * Liefert die Instanz der ReservierungFactory
     * @return
     */
    public ReservierungFactory get_reservierungFactory() {
        return _reservierungFactory;
    }
    /**
     * Liefert die Instanz der KundeFactory
     * @return
     */
    public KundeFactory get_kundeFactory() {
        return _kundeFactory;
    }
    
}
