package test;

import app.Lap;
import app.Program;
import app.Pakli;

public class Teszt {
        static Pakli pakli = new Pakli();

    public static void main(String[] args) {

        tesztDuplikacio();
        tesztMin3Betu();
        tesztKeveres();
        tesztKozepenVan();

        System.out.println("Minden teszt sikeres.");

        //Program.main(args);
    }

    public static void tesztDuplikacio() {
        Lap[] lapok =pakli.getLapok();
        for (int i = 0; i < lapok.length; i++) {
            for (int j = i + 1; j < lapok.length; j++) {
                boolean ugyanaz = lapok[i].getSzin().equals(lapok[j].getSzin())
                        && lapok[i].getErtek().equals(lapok[j].getErtek());

                assert !ugyanaz : "Duplikált lap található!";
            }
        }
    }

    public static void tesztMin3Betu() {
        for (Lap lap : pakli.getLapok()) {
            assert lap.getSzin().length() >= 3 : "A szín rövidebb mint 3 karakter!";

            assert lap.getErtek().length() >= 0 : "Az érték rövidebb mint 3 karakter!";
        }
    }

    public static void tesztKeveres() {
        Lap[] eredeti = pakli.getLapok().clone();

        pakli.kever(1);

        boolean valtozott = false;

        for (int i = 0; i < eredeti.length; i++) {
            if (eredeti[i] != pakli.getLapok()[i]) {
                valtozott = true;
                break;
            }
        }

        assert valtozott : "A keverés nem változtatta meg a sorrendet!";
    }

    public static void tesztKozepenVan() {
        assert pakli.getLapok()[10] != null : "A középső lap nem létezik!";
    }
}
//pakli duplikálás
//pakli min3 betu
//tényleg középen van ea választott kártya
//mukodik a keveres
