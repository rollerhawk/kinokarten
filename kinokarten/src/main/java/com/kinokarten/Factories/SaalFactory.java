package com.kinokarten.Factories;

import com.kinokarten.Interfaces.CounterInterface;
import com.kinokarten.Objects.Kino;
import com.kinokarten.Objects.Saal;

public class SaalFactory {

private CounterInterface _counter;

    public SaalFactory(CounterInterface counter) {
        this._counter = counter;
    }

    public Saal Create(Kino kino){
        //Neue eindeutige Saalnummer abholen

        long saalnummer = _counter.GetNextNr();
        Saal saal = new Saal(kino,saalnummer);

        return saal;
    }
}
