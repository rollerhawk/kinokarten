package com.kinokarten;

import com.kinokarten.Interfaces.CounterInterface;

public class Counter implements CounterInterface {

    private long _counter;    

    public Counter() {
        this._counter = 0;
    }

    public long GetNextNr() {
        _counter++;
        return _counter;
    }    
}
