package com.kinokarten;

import java.sql.Date;
import java.time.LocalDateTime;

import com.kinokarten.Factories.ReservierungFactory;
import com.kinokarten.Objects.Saal;
import com.kinokarten.Objects.Termin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Termin _meinTermin;
        _meinTermin = new Termin();
        _meinTermin.set_startUhrzeit(LocalDateTime.now());
        

        Saal _meinSaal;
        Saal _meinSaal2;

        Counter normalesCounter = new Counter();


        ReservierungFactory factory = new ReservierungFactory(normalesCounter);

        _meinSaal2 = new Saal();

        _meinSaal = new Saal(1);
    }
}
