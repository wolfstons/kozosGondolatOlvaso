
package app;

import java.util.Random;

public class Pakli {
    private Lap[] lapok = new Lap[21];
    private int db = 0;

    public Pakli() {
        feltolt();
    }

    public Lap[] getLapok() {
        return lapok;
    }

    public void feltolt() {
        String[] szinek = {"Piros", "Zold", "Tok"};
        String[] ertekek = {"VII", "VIII", "IX", "X", "Also", "Felso", "Kiraly"};

        db = 0;

        for (String szin : szinek) {
            for (String ertek : ertekek) {
                lapok[db++] = new Lap(szin, ertek);
            }
        }
    }

    public void kever(int hanyszor) {
        Random rnd = new Random();

        for (int i = 0; i < hanyszor; i++) {
            int a = rnd.nextInt(lapok.length);
            int b = rnd.nextInt(lapok.length);

            Lap seged = lapok[a];
            lapok[a] = lapok[b];
            lapok[b] = seged;
        }
    }

    public Lap ezVolt() {
        if (db > 0) {
            return lapok[--db];
        }
        return null;
    }
}