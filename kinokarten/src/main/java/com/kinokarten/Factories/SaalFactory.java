package com.kinokarten.Factories;

import com.kinokarten.Interfaces.CounterInterface;
import com.kinokarten.Objects.Kino;
import com.kinokarten.Objects.Saal;
/**
 * Erzeugt den Saal
 */
public class SaalFactory {

private CounterInterface _counter;

    public SaalFactory(CounterInterface counter) {
        this._counter = counter;
    }

    public Saal Create(Kino kino, int _anzahlReihen, int _anzahlSitzeProReihe){
        //Neue eindeutige Saalnummer abholen

        long saalnummer = _counter.GetNextNr();
        Saal saal = new Saal(kino,saalnummer,_anzahlReihen,_anzahlSitzeProReihe);

        return saal;
    }
}
