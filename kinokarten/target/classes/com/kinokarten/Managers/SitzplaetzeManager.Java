public class SitzplaetzeManager {
    private Sitzplatz _sitzplatz;
    private Reservierung _reservierung;
    private Termin _termin;
    private Film _film;


    public SitzplaetzeManager(Termin _termin, Reservierung _reservierung){
        this._termin = _termin;
        this._reservierung = _reservierung;
    }

}