package com.kinokarten;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kinokarten.Factories.FSKFactory;
import com.kinokarten.Factories.KundeFactory;
import com.kinokarten.Factories.ReservierungFactory;
import com.kinokarten.Helpers.RunnableHelper;
import com.kinokarten.Interfaces.KinoRunnable;
import com.kinokarten.Managers.KinoManager;
import com.kinokarten.Managers.SitzplatzManager;
import com.kinokarten.Objects.Adresse;
import com.kinokarten.Objects.FSK;
import com.kinokarten.Objects.Film;
import com.kinokarten.Objects.Kino;
import com.kinokarten.Objects.Kunde;
import com.kinokarten.Objects.Reservierung;
import com.kinokarten.Objects.Saal;
import com.kinokarten.Objects.Sitzplatz;
import com.kinokarten.Objects.Termin;

/**
 *  
 */ 
public class App 
{
    
    /** 
     * @param args
     */
    public static void main( String[] args )
    {
        System.out.println( "Wilkommen in das Kino!" );
        System.out.println( "Geben Sie bitte dem Kino einen Namen!" ); 

        String name = System.console().readLine();
        System.out.println( "Das Kino soll " + name + " heissen!" );        
        Kino kino = new Kino(name, adresseErstellen());
        KinoManager kinoManager = new KinoManager(kino);

        System.out.println( "Wie viele Filme wollen sie erstellen?" ); 
        String anzahlFilmeText = System.console().readLine();
        int anzahlFilme = tryConvertStringToInt(anzahlFilmeText);

        if(anzahlFilme != -1){
            for (int i = 0; i < anzahlFilme; i++) {
                System.out.println("Erstelle Film " + (i+1));
                createFilm(kinoManager);
            }
        }

        System.out.println( "Wie viele Säle wollen sie erstellen?" ); 
        String anzahlSaeleText = System.console().readLine();
        int anzahlSaele = tryConvertStringToInt(anzahlSaeleText);

        if(anzahlSaele != -1){
            for (int i = 0; i < anzahlSaele; i++) {
                System.out.println("Erstelle Saal " + (i+1));
                createSaal(kinoManager);                
            }
        }        

        for (Film film : kinoManager.get_filmManager().get_filme()) {
            createTermin(kinoManager, film);
        }

        //Konfiguration abgeschlossen

        KinoRunnable mainRunnable = new KinoRunnable() {
            @Override
            public boolean run(Object[] objects) {
                boolean abbruch = false;
                KinoManager kinoManager = (KinoManager)objects[0];
                System.out.println( "Was wollen Sie im Kino tun?" );
                System.out.println( "1) Alle Filme anzeigen" );
                System.out.println( "2) Alle Termine anzeigen" );
                System.out.println( "3) Plätze für einen Film anzeigen" );
                System.out.println( "4) Plätze für einen Film reservieren" );
                
                String userInpuString = System.console().readLine();
                int userInput = tryConvertStringToInt(userInpuString);

                switch (userInput) {
                    //Case 1 - Alle Filme anzeigen
                    case 1:                        
                        zeigeFilme(kinoManager);
                        break;
                    //Case 2 - Alle Termine anzeigen
                    case 2:      
                        zeigeTermine(kinoManager);        
                        break;
                    //Case 3 - Plätze reservieren
                    case 3:
                        System.out.println("Für welchen Film wollen Sie die Plätze anzeigen?");
                        List<Termin> alleTermineCase3 = zeigeTermine(kinoManager);
                        String terminNrTextCase3 = System.console().readLine();
                        int terminNrCase3 = tryConvertStringToInt(terminNrTextCase3);

                        //Hier prüfen, dass die TerminNr überhaupt gültig ist bitte!
                        Termin terminCase3 = alleTermineCase3.get(terminNrCase3-1);     

                        if(terminCase3 == null){
                            abbruch = true;
                        } else {
                            System.out.println(terminCase3.get_sitzplatzManager().getAnzeigePlaetze());
                        }
                        break;      
                    //Case 4 - Plätze reservieren
                    case 4:
                        System.out.println("Für welchen Film wollen Sie die Plätze reservieren?");
                        List<Termin> alleTermineCase4 = zeigeTermine(kinoManager);
                        String terminNrTextCase4 = System.console().readLine();
                        int terminNrCase4 = tryConvertStringToInt(terminNrTextCase4);

                        //Hier prüfen, dass die TerminNr überhaupt gültig ist bitte!
                        Termin terminCase4 = alleTermineCase4.get(terminNrCase4-1);
                        boolean stopSuche = false;
                        while(!stopSuche){
                            System.out.println("Wie viele Sitzplätze wollen Sie reservieren?");
                            String anzahlPlaetzeText = System.console().readLine();
                            int anzahlPlaetze = tryConvertStringToInt(anzahlPlaetzeText);                       
                            SitzplatzManager sitzplatzManager = terminCase4.get_sitzplatzManager();
                            
                            System.out.println("Wollen Sie die Sitzplätze nebeneinander haben? Y/N");                        
                            List<Sitzplatz> moeglicheSitzplaetze = System.console().readLine().toUpperCase().equals("Y") ? sitzplatzManager.getFreieSitzplaetzeNebeneinander(anzahlPlaetze) : sitzplatzManager.getFreieSitzplaetzeBeliebig(anzahlPlaetze);
                            if(moeglicheSitzplaetze == null){
                                System.out.println("Plaetze konnten nicht reserviert werden! Abbruch? Y/N");
                                stopSuche = System.console().readLine().toUpperCase().equals("Y");
                            } else {
                                System.out.println("Sitzplaetze ferfügbar! Wollen Sie die Sitzplätze reservieren? Y/N");
                                stopSuche = System.console().readLine().toUpperCase().equals("Y");
                                
                                //Erzeugung eines neuen Kunden                        
                                Kunde neuerKunde = createKunde(kinoManager);

                                //Erzeugung eines neuen Reservierung mit dem erstellten Kunden 
                                Reservierung reservierung = kinoManager.get_reservierungFactory().Create(neuerKunde, terminCase4);

                                if(stopSuche && sitzplatzManager.reserviereSitzplaetze(moeglicheSitzplaetze, reservierung)){
                                    System.out.println("Erfolgreich! Reservierung: " + reservierung);
                                }
                            }
                        }
                        break;
                    default:
                    System.out.println("FEHLER! PROGRAMMSTOPP!");
                        abbruch = true;
                        break;
                }
                return abbruch;
            }


        };

        RunnableHelper.runUntilCancelledByRunnable(mainRunnable, new Object[]{kinoManager});
        
    }

    /**
     * Erstellt einen neuen Kunden
     * @return Instanz vom Kunde
     */
    private static Kunde createKunde(KinoManager kinoManager) {
        System.out.println( "Wie heißen Sie?" ); 
        System.out.println( "Name?" ); 
        String nameKunde = System.console().readLine();
        System.out.println( "Vorname?" ); 
        String vornameKunde = System.console().readLine();

        System.out.println( "Wie alt sind Sie?" ); 
        String alterKundeString = System.console().readLine();

        int alterKunde = tryConvertStringToInt(alterKundeString);                

        return kinoManager.get_kundeFactory().Create(new Adresse("DE", "Köln", "52062", "UNI", "1"), alterKunde, vornameKunde, nameKunde);
    }

    /**
     * Zeigt alle Filme mit toString Methode in der Console an
     * @param kinoManager
     */
    private static void zeigeFilme(KinoManager kinoManager){
        List<Film> filme = kinoManager.get_filmManager().get_filme();
        for (int i = 0; i < filme.size(); i++) {
            System.out.println((i+1)+") "+filme.get(i).toString());
        }                     
    }

    /**
     * Liefert alle Termine als Liste zurück und Zeigt sie mit toString Methode in der Console an
     * @param kinoManager
     * @return
     */
    private static List<Termin> zeigeTermine(KinoManager kinoManager){
        int f = 0;
        List<Termin> alleTermine = new ArrayList<Termin>();
        for (int i = 0; i < kinoManager.get_saalManager().get_anzahlSaele(); i++) {
            List<Termin> termine = kinoManager.get_saalManager().get_saal(i+1).get_termine();

            for (int j = 0; j < termine.size(); j++) {                
                f++;
                System.out.println(f+") "+termine.get(j).toString());                
                alleTermine.add(termine.get(j));
            }
        }  
        return alleTermine;
    }

    /**
     * Erstellung eines neuen Saales durch ConsolenInput
     * @param kinoManager
     */
    private static void createSaal(KinoManager kinoManager){
        System.out.println( "Wie viele Reihen soll der Saal haben?" ); 
        String anzahlReihenText = System.console().readLine();

        int anzahlReihen = tryConvertStringToInt(anzahlReihenText);

        System.out.println( "Wie viele Sitze pro Reihe soll der Saal haben?" ); 
        String anzahlSitzeProReiheText = System.console().readLine();

        int anzahlSitzeProReihe = tryConvertStringToInt(anzahlSitzeProReiheText);

        kinoManager.addNewSaal(anzahlReihen, anzahlSitzeProReihe);
    }

    /**
     * Erstellung eines neuen Filmes durch ConsolenInput
     * @param kinoManager
     */
    private static void createFilm(KinoManager kinoManager){
        System.out.println( "Wie soll das Film heissen?" ); 
        String titel = System.console().readLine();
        
        System.out.println( "Wie lange soll das Film laufen?" ); 
        String dauerText = System.console().readLine();
        
        System.out.println( "FSK des Filmes?" ); 
        String fskText = System.console().readLine();

        int dauer = tryConvertStringToInt(dauerText);
        FSK fsk = FSKFactory.Create(tryConvertStringToInt(fskText));   
        
        kinoManager.addNewFilm(titel, dauer, fsk);
    }

    /**
     * Erstellung eines neuen Termines durch ConsolenInput
     * @param kinoManager
     * @param film
     */
    private static void createTermin(KinoManager kinoManager, Film film){            

        KinoRunnable createTerminRunnable  = new KinoRunnable(){
            @Override
            public boolean run(Object[] objects){                   
                KinoManager kinoManager = (KinoManager)objects[0];
                Film film = (Film)objects[1];

                System.out.println( "Wann soll der Film: "+ film +" laufen?" );
                System.out.println( "1) 17:30" );
                System.out.println( "2) 21:00" );
                System.out.println( "3) 23:30" );
                String zahlUhrzeit = System.console().readLine();
        
                LocalDateTime localDateTime;
                LocalDateTime nowDateTime = LocalDateTime.now();
                switch (zahlUhrzeit) {
                    case "1":
                        localDateTime = LocalDateTime.of(nowDateTime.getYear(), nowDateTime.getMonth(), nowDateTime.getDayOfMonth(), 17, 30, 0);
                        break;
                    case "2":
                        localDateTime = LocalDateTime.of(nowDateTime.getYear(), nowDateTime.getMonth(), nowDateTime.getDayOfMonth(), 21, 00, 0);
                        break;
                    case "3":
                        localDateTime = LocalDateTime.of(nowDateTime.getYear(), nowDateTime.getMonth(), nowDateTime.getDayOfMonth(), 23, 30, 0);
                        break;
                    default:
                        localDateTime = LocalDateTime.of(nowDateTime.getYear(), nowDateTime.getMonth(), nowDateTime.getDayOfMonth(), 17, 30, 0);
                        break;
                }  

                System.out.println( "In welchem Saal soll der Film: "+ film +" laufen?" );
    
                for (int i = 1; i <= kinoManager.get_saalManager().get_anzahlSaele(); i++) {
                    System.out.println( "Saal:" + i );
                }

                String saalNrText = System.console().readLine();
                int saalNr = tryConvertStringToInt(saalNrText);

                Saal saal = kinoManager.get_saalManager().get_saal(saalNr);
                boolean abbruch = true;
                if(saal == null)
                {
                    abbruch = false;
                } else {                    
                    Termin neuTermin = kinoManager.get_saalManager().addFilmToSaal(film, localDateTime, saal);
                    if(neuTermin == null){
                        System.out.println( "Termin konnte nicht angelegt werden!");
                        abbruch = false;
                    }
                }
                return abbruch;
            }
        };

        RunnableHelper.runUntilCancelledByRunnable(createTerminRunnable, new Object[]{kinoManager, film});
    }

    /**
     * Konvertiert String zum int
     * @param text
     * @return
     */
    private static int tryConvertStringToInt(String text){
        int ergebnis = -1;
        try {
            ergebnis = Integer.parseInt(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ergebnis;
    }

    /**
     * Erstellung einer neuen Adresse durch ConsolenInput
     * @return
     */
    private static Adresse adresseErstellen(){
        System.out.println( "Geben Sie bitte die Adresse des Kinos vor!" );

        System.out.println( "Straße:" );
        String strasse = System.console().readLine();

        System.out.println( "Hausnummer:" );
        String hausnummer = System.console().readLine();

        System.out.println( "Ort:" );
        String ort = System.console().readLine();

        System.out.println( "PLZ:" );
        String plz = System.console().readLine();

        System.out.println( "Land:" );
        String land = System.console().readLine();        

        Adresse adresse = new Adresse(land, ort, plz, strasse, hausnummer);

        return adresse;
    }
}
