package com.kinokarten.Managers;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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

public class SaalManager {
    private Kino _kino;
    private int _anzahlSaele;
    private Map<Long, Saal> _saele;
    private SaalFactory _saalFactory;

    public SaalManager(Kino _kino, int _anzahlSaele) {
        this._kino = _kino;
        this._anzahlSaele = _anzahlSaele;
        _saele = new HashMap<Long,Saal>();
        _saalFactory = new SaalFactory(new Counter());
        
        for (int i = 0; i < _anzahlSaele; i++) {
            Saal neuerSaal = _saalFactory.Create(_kino);
            _saele.put(neuerSaal.get_saalnummer(), neuerSaal);
        }
    }

    public Kino get_kino() {
        return _kino;
    }

    public int get_anzahlSaele() {
        return _anzahlSaele;
    }

    public Map<Long, Saal> get_saele() {
        return _saele;
    }   

    public Saal get_saal(long saalnummer){
        return _saele.get(saalnummer);
    }


    public Termin addFilmToSaal(Film film, LocalDateTime startZeit, Saal saal){   

        List<Termin> termineVomSaal = saal.get_termine();
        Termin neuerTermin = null;
        boolean terminDarfErstelltWerden = true;
        
        for (Termin terminVomSaal : termineVomSaal) {
            if(terminVomSaal.get_startUhrzeit() == startZeit)
            {
                //17:30
                //21:00
                //23:30
                //Termin darf nicht erstellt werden, weil bereits ein anderen gibt mit der gleichen StartUhrzeit
                terminDarfErstelltWerden = false;
            }            
        }

        if(terminDarfErstelltWerden){
            LocalDateTime endZeit = startZeit.plusMinutes(film.get_daurer());
            neuerTermin = TerminFactory.Create(film, saal, startZeit, endZeit);
            termineVomSaal.add(neuerTermin);
        }

        return neuerTermin;       
    }

}
