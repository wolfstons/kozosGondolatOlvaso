package test;

import app.Lap;
import app.Pakli;

public class Teszt {

    static Pakli pakli = new Pakli();

    public static void main(String[] args) {
        System.out.println("1. Lap érték és szín teszt");
        ertekSzin();

        System.out.println("2. Pakli lapjainak száma teszt");
        lapokSzama();

        System.out.println("3. Hibás oszlop teszt");
        nemLetezoOszlop();

        System.out.println("4. Kiválasztott lap áthelyezés teszt");
        hovaKerul();

        tesztDuplikacio();
        tesztMin3Betu();
        tesztKeveres();
        tesztKozepenVan();

        System.out.println("Lefutott az összes teszt");
    }

    //megfelelően tárolja e és adja e vissza a megadott éréket és színt
    public static void ertekSzin() {
        Lap lap = new Lap("Piros", "VII");

        assert lap.getErtek().equals("VII");
        assert lap.getSzin().equals("Piros");
    }

    //21 lap van e a pakliban
    public static void lapokSzama() {
        assert pakli.getLapok().length == 21;
    }

    //ha nem létező oszlopot ad meg, akkor hibás e
    public static void nemLetezoOszlop() {
        int oszlop = 4;

        assert oszlop < 1 || oszlop > 3;
    }

    //melyik oszlopból hová kerül a kiválasztott lap
    public static void hovaKerul() {
        pakli.kever(2);

        Lap[] lapok = pakli.getLapok();

        for (int i = 7; i < 14; i++) {
            assert lapok[i] != null;
        }
    }

    public static void tesztDuplikacio() {
        Lap[] lapok = pakli.getLapok();
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
