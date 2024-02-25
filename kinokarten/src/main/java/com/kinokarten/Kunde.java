package com.kinokarten;
/**
 * Bildet einen Kunden ab
 */
    public class Kunde {
        private int _kundenNummer;
        private Adresse _adresse;
        private int _alter;
        private String _vorname;
        private String _nachname;
        private Reservierung _reservierung;   
        
        /**
         * Erstellt eine neue Instanz von Kunde
         * @param _kundenNummer Die Kundennummer
         * @param _adresse  Die Adresse
         * @param _alter Das Altrer
         * @param _vorname Der Vorname 
         * @param _nachname Der Nachname
         */
        public Kunde(int _kundenNummer, Adresse _adresse, int _alter, String _vorname, String _nachname) {
            this._kundenNummer = _kundenNummer;
            this._adresse = _adresse;
            this._alter = _alter;
            this._vorname = _vorname;
            this._nachname = _nachname;
        }

        public boolean set_Reservierung(Reservierung _reservierung){
            boolean result = false;
            if(_reservierung != null) {
                result = true;
                this._reservierung = _reservierung;
            }            
            return result;
        }

        public Reservierung get_Reservierung(){
            return _reservierung;
        }
    }