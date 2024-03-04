package com.kinokarten.Factories;

import com.kinokarten.Interfaces.CounterInterface;
import com.kinokarten.Objects.Adresse;
import com.kinokarten.Objects.Kunde;
/**
 * Diese Factory erzeugt den Kunden 
 */
public class KundeFactory {
    private CounterInterface _counter;

    public KundeFactory(CounterInterface counter) {
        this._counter = counter;
    }

    
    /** 
     * @param adresse
     * @param alter
     * @param vorname
     * @param nachname
     * @return Kunde
     */
    public Kunde Create(Adresse adresse, int alter, String vorname, String nachname){
        long kundenNummer = _counter.getNextNr();
        Kunde kunde = new Kunde(kundenNummer, adresse, alter, vorname, nachname);

        return kunde;
    }
}
