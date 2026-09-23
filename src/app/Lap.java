
package app;


public class Lap{
    
    private String ertek;
    private String szin;

    public Lap(String szin, String ertek) {
        this.szin = szin;
        this.ertek = ertek;
    }

    public String getErtek() {
        return ertek;
    }

    public String getSzin() {
        return szin;
    }

    public String megjelenit() {
        return szin + " " + ertek;
    }

    
}
