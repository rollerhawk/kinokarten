package com.kinokarten.Managers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kinokarten.Counter;
import com.kinokarten.Factories.SaalFactory;
import com.kinokarten.Factories.TerminFactory;
import com.kinokarten.Objects.Film;
import com.kinokarten.Objects.Kino;
import com.kinokarten.Objects.Saal;
import com.kinokarten.Objects.Termin;
/**
 * Hier bildet sich die komplette Logik des Saals ab 
 */
public class SaalManager {
    private Kino _kino;
    private Map<Long, Saal> _saele;
    private SaalFactory _saalFactory;
    /**
     * Constructor vom Saalmanager
     * @param _kino Das Kino 
     * @param _anzahlSaele Die Anzahl der Säle
     */
    public SaalManager(Kino _kino) {
        this._kino = _kino;
        _saele = new HashMap<Long,Saal>();
        _saalFactory = new SaalFactory(new Counter());
    }
    /**
     * Erhält das Kino 
     * @return Gibt den Wert des Kinos wieder 
     */
    public Kino get_kino() {
        return _kino;
    }
    /**
     * Erhält die anzahl der Säle 
     * @return Gibt die Anzahl der Säle wieder 
     */
    public int get_anzahlSaele() {
        return _saele.size();
    }
    /**
     * Auflistung der Säle 
     * @return Gibt den den Angefragten Saal zurück 
     */
    public Map<Long, Saal> get_saele() {
        return _saele;
    }   
    /**
     * Rückgabe des Saals 
     * @param saalnummer Die Nummer des Saals
     * @return Rückgabe der Saalnummer
     */
    public Saal get_saal(long saalnummer){
        Saal saal = _saele.get(saalnummer);
        if(saal == null){
            System.out.println("Saal mit Nr: " +saalnummer + " konnte nicht gefunden werden!");
        }
        return saal;
    }


    public boolean addNewSaal(int _anzahlReihen, int _anzahlSitzeProReihe){
        boolean ergebnis = false;
        Saal neuerSaal = _saalFactory.Create(_kino, _anzahlReihen, _anzahlSitzeProReihe);
        _saele.put(neuerSaal.get_saalnummer(), neuerSaal);
        return ergebnis;
    }

    /**
     * Fügt ein Film zum Saal hinzu
     * @param film Der Filmname
     * @param startZeit Die Startzeit des Films
     * @param saal Der Saal in dem der Film spielt
     * @return Gibt den Termin zurück
     */
    public Termin addFilmToSaal(Film film, LocalDateTime startZeit, Saal saal){   

        List<Termin> termineVomSaal = saal.get_termine();
        Termin neuerTermin = null;
        boolean terminDarfErstelltWerden = true;
        
        for (Termin terminVomSaal : termineVomSaal) {
            if(terminVomSaal.get_startUhrzeit().compareTo(startZeit) == 0)
            {
                //17:30
                //21:00
                //23:30
                //Termin darf nicht erstellt werden, weil bereits ein anderen gibt mit der gleichen StartUhrzeit
                terminDarfErstelltWerden = false;
            }            
        }

        if(terminDarfErstelltWerden){
            LocalDateTime endZeit = startZeit.plusMinutes(film.get_dauer());
            neuerTermin = TerminFactory.Create(film, saal, startZeit, endZeit);
            termineVomSaal.add(neuerTermin);
        }

        return neuerTermin;       
    }

}
