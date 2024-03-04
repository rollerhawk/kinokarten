package com.kinokarten;

import com.kinokarten.Interfaces.CounterInterface;

public class Counter implements CounterInterface {

    private long _counter;    

    /**
     * Constructor für den Counter
     */
    public Counter() {
        this._counter = 0;
    }

    /**
     * Ausgabe des Counters 
     */
    public long getNextNr() {
        _counter++;
        return _counter;
    }    
}
