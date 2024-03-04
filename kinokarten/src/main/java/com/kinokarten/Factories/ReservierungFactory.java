package com.kinokarten.Factories;

import com.kinokarten.Interfaces.CounterInterface;
import com.kinokarten.Objects.Kunde;
import com.kinokarten.Objects.Reservierung;
import com.kinokarten.Objects.Termin;
/**
 * Erzeugung der Reservierung 
 */
public class ReservierungFactory {

    private CounterInterface _counter;

    public ReservierungFactory(CounterInterface counter) {
        this._counter = counter;
    }

    
    /** 
     * @param kunde
     * @param termin
     * @return Reservierung
     */
    public Reservierung Create(Kunde kunde, Termin termin){
        //Neue eindeutige Reservierungsnummer abholen
        long nexteFreieNummer = _counter.getNextNr();
        
        Reservierung reservierung = new Reservierung(nexteFreieNummer, kunde, termin);
        return reservierung;
    }
}
