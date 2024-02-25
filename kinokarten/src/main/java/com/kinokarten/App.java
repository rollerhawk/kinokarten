package com.kinokarten;

import java.sql.Date;
import java.time.LocalDateTime;

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

        _meinSaal2 = new Saal();

        _meinSaal = new Saal(1);
    }
}
