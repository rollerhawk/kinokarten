package com.kinokarten.Objects;

/**
 * Bildet einen Kunden ab
 */
    public class Kunde {
        private long _kundenNummer;        
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
        public Kunde(long _kundenNummer, Adresse _adresse, int _alter, String _vorname, String _nachname) {
            this._kundenNummer = _kundenNummer;
            this._adresse = _adresse;
            this._alter = _alter;
            this._vorname = _vorname;
            this._nachname = _nachname;
        }
        /**
         * Setzt die Reservierung 
         * @param _reservierung 
         * @return Zeigt an ob die Reservierung erfolgreich war.
         */
        public boolean set_reservierung(Reservierung _reservierung){
            boolean result = false;
            if(_reservierung != null) {
                result = true;
                this._reservierung = _reservierung;
            }            
            return result;
        }        
        /**
         * Erhält die Kundennummer
         * @return Gibt die Kundennummer zurück
         */
        public long get_kundenNummer() {
            return _kundenNummer;
        }
        /**
         * Erhält die Adresse des Kunden
         * @return Rückgabe der Adresse des Kunden 
         */
        public Adresse get_adresse() {
            return _adresse;
        }
        /**
         * Gibt das alter zurück
         * @return Rückgabe des Alters vom Kunden
         */
        public int get_alter() {
            return _alter;
        }
        /**
         * Gibt den Vornamen des Kunden 
         * @return Rückgabe des Vornamens
         */
        public String get_vorname() {
            return _vorname;
        }
        /**
         * Gibt den Nachnamen zurück
         * @return Rückgabe des Nachnamens 
         */
        public String get_nachname() {
            return _nachname;
        }

        /**
         * Erhält die Reservierung 
         * @return Gibt die Reservierung aus
         */
        public Reservierung get_reservierung() {
            return _reservierung;
        }
        
    }