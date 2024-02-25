package com.kinokarten;

public class Kunde {
    private int _kundenNummer;
    private Adresse _adresse;
    private int _alter;
    private String _vorname;
    private String _nachname;
    private Reservierung _reservierung;

    public Reservierung get_Reservierung(){
        return _reservierung;
    }
}