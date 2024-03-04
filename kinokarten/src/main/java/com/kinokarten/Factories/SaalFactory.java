package com.kinokarten.Factories;

import com.kinokarten.Interfaces.CounterInterface;
import com.kinokarten.Objects.Kino;
import com.kinokarten.Objects.Saal;
/**
 * Erzeugung des Saals
 */
public class SaalFactory {

private CounterInterface _counter;

    public SaalFactory(CounterInterface counter) {
        this._counter = counter;
    }

    
    /** 
     * @param kino
     * @param _anzahlReihen
     * @param _anzahlSitzeProReihe
     * @return Saal
     */
    public Saal Create(Kino kino, int _anzahlReihen, int _anzahlSitzeProReihe){
        

        long saalnummer = _counter.getNextNr();
        Saal saal = new Saal(kino,saalnummer,_anzahlReihen,_anzahlSitzeProReihe);

        return saal;
    }
}
