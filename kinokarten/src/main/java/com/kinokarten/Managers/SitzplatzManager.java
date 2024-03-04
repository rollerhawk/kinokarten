package com.kinokarten.Managers;

import java.util.ArrayList;
import java.util.List;

import com.kinokarten.Objects.Reservierung;
import com.kinokarten.Objects.Saal;
import com.kinokarten.Objects.Sitzplatz;
/**
 * Hier befindet sich die komplette Logik der Sitzplätze
 */
public class SitzplatzManager {
    private Saal _saal;
    private int _anzahlReihen;
    private int _anzahlSitzeProReihe;
    private Sitzplatz[][] _sitzplaetze;
    
    /**
     * Constructor für den Sitzplatzmanager
     * @param _saal Eingabe des Saals
     */
    public SitzplatzManager(Saal _saal) {
        this._saal = _saal;
        this._anzahlReihen = this._saal.get_anzahlReihen();
        this._anzahlSitzeProReihe = this._saal.get_anzahlSitzeProReihe();
        this._sitzplaetze = new Sitzplatz[_anzahlReihen][_anzahlSitzeProReihe];
        initSitzplaetze();
    }

    /**
     * Erstellung der Sitzplätze
     */
    private void initSitzplaetze(){
        for (int i = 0; i < _sitzplaetze.length; i++) {
            for (int j = 0; j < _sitzplaetze[i].length; j++) {
                _sitzplaetze[i][j] = new Sitzplatz(_saal, i+1, j+1);
            }
        }
    }

    /**
     * Abfrage ob der Sitzplatz schon reserviert ist, ja oder nein
     * @param reihenNummer Die Reihe
     * @param sitzplatzNummer Der Sitzplatz
     * @return True or false Rückgabe 
     * @throws Exception 
     */
    public boolean isReserviert(int reihenNummer, int sitzplatzNummer) throws Exception{
        //Defensive Programming
        if(reihenNummer >= _anzahlReihen){
            throw new Exception("Gegebene Reihennummer ist größer als MAX Anzahl Riehen im Saal!");
        }        
        if(sitzplatzNummer >= _anzahlSitzeProReihe){
            throw new Exception("Gegebene Sitzplatznummer ist größer als MAX Anzahl Sitze pro Riehe!");
        }
        //Normaler Ablauf: Prüfen ob der selektierte Sitzplatz reserviert ist
        return _sitzplaetze[reihenNummer][sitzplatzNummer].get_isReserviert();
    }

    /**
     * Rückgabe der Plätze in Form von einer Anzeige
     * @return Der Sitzplatzplan für den Saal
     */

    public String getAnzeigePlaetze(){
        String ergebnis = "Sitzplaetze im Saal:" + _saal.get_saalnummer() + "\n";
        for (Sitzplatz[] reihen : _sitzplaetze) {
            //Reihen
            ergebnis+="|";
            for (Sitzplatz sitzplatz : reihen) {
                //Sitzplaetze
                ergebnis+= sitzplatz.get_isReserviert() ? "X" : "_";
                ergebnis+="|";
            }
            ergebnis += "\n";
        }
        return ergebnis;
    }

    /**
     * Rückgabe der Sitzplätze die nebeneinander frei sind in Form von einer Liste
     * @param anzahlSitzplaetze Die Sitzplätze
     * @return Ausgabe der möglichen Sitzplätze 
     */
    public List<Sitzplatz> getFreieSitzplaetzeNebeneinander(int anzahlSitzplaetze){
        //Bestimmte anzahl Plaetze finden die nebeneinander sein müssen, hintere Plaetze zuerst
        Sitzplatz[] reihe;
        //Reihen von hinten
        ArrayList<Sitzplatz> moeglicheSitzplaetze = new ArrayList<Sitzplatz>();
        boolean plaetzeGefunden = false;
        for (int i = _anzahlReihen - 1; i > 0 && !plaetzeGefunden; i--) {
            reihe = _sitzplaetze[i];            
            //Sitzplaetze
            for (int j = 0; j < reihe.length; j++) {
                Sitzplatz sitzplatz = reihe[j];
                if(!sitzplatz.get_isReserviert() && moeglicheSitzplaetze.size() < anzahlSitzplaetze){
                    moeglicheSitzplaetze.add(reihe[j]);    
                }
                else if (moeglicheSitzplaetze.size() == anzahlSitzplaetze){
                    plaetzeGefunden = true;
                    break;
                }
            }
            if ((moeglicheSitzplaetze.size() != anzahlSitzplaetze ) && moeglicheSitzplaetze.size() != 0){
                plaetzeGefunden = false;
                break;
            }
        }

        if(plaetzeGefunden){
            System.out.println("Alle Plaetze gefunden!");
        } else {
            moeglicheSitzplaetze = null;
            System.out.println("Plaetze nicht gefunden!");
        }

        return moeglicheSitzplaetze;
    }

    /**
     * Rückgabe einer Liste der freien Plätze 
     * @param anzahlSitzplaetze Die Sitzplätze
     * @return Rückgabe einer Liste von allen freien Plätzen
     */
    public List<Sitzplatz> getFreieSitzplaetzeBeliebig(int anzahlSitzplaetze){
        //Bestimmte anzahl Plaetze finden hintere Plaetze zuerst
        Sitzplatz[] reihe;
        //Reihen von hinten
        ArrayList<Sitzplatz> moeglicheSitzplaetze = new ArrayList<Sitzplatz>();
        boolean plaetzeGefunden = false;
        for (int i = _anzahlReihen - 1; i > 0 && !plaetzeGefunden; i--) {
            reihe = _sitzplaetze[i];            
            //Sitzplaetze
            for (int j = 0; j < reihe.length; j++) {
                Sitzplatz sitzplatz = reihe[j];
                int istAnzahlMoeglicheSitze = moeglicheSitzplaetze.size();
                if(!sitzplatz.get_isReserviert() && istAnzahlMoeglicheSitze < anzahlSitzplaetze){
                    moeglicheSitzplaetze.add(reihe[j]);    
                }
                else if (istAnzahlMoeglicheSitze == anzahlSitzplaetze){
                    plaetzeGefunden = true;
                }
            }
        }

        if(plaetzeGefunden){
            System.out.println("Alle Plaetze gefunden!");
        } else {
            moeglicheSitzplaetze = null;
            System.out.println("Plaetze nicht gefunden!");
        }

        return moeglicheSitzplaetze;
    }

    /**
     * Abfrage ob ein Sitzplatz reserviert ist oder nicht
     * @param sitzplaetze Die Sitzplätze
     * @param reservierung Die Reservierungen
     * @return True or false wert ob der Sitz frei ist
     */
    public boolean reserviereSitzplaetze(List<Sitzplatz> sitzplaetze, Reservierung reservierung){
        boolean ergebnis = false;
        for (Sitzplatz sitzplatz : sitzplaetze) {
            ergebnis = sitzplatz.set_reservierung(reservierung);
        }

        if(!ergebnis){
            for (Sitzplatz sitzplatz : sitzplaetze) {
                sitzplatz.remove_reservierung();
            }
        }

        return ergebnis;
    }

}
