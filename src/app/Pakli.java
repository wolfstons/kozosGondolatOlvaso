package app;

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

    public void kever(int oszlop) {
        Lap[] ujPakli = new Lap[21];

        switch (oszlop) {
            case 1:
                for (int i = 0; i < 7; i++) {
                    ujPakli[i] = lapok[20 - i * 3];
                    ujPakli[i + 7] = lapok[19 - i * 3];
                    ujPakli[i + 14] = lapok[18 - i * 3];
                }
                break;

            case 2:
                for (int i = 0; i < 7; i++) {
                    ujPakli[i] = lapok[19 - i * 3];
                    ujPakli[i + 7] = lapok[20 - i * 3];
                    ujPakli[i + 14] = lapok[18 - i * 3];
                }
                break;

            case 3:
                for (int i = 0; i < 7; i++) {
                    ujPakli[i] = lapok[19 - i * 3];
                    ujPakli[i + 7] = lapok[18 - i * 3];
                    ujPakli[i + 14] = lapok[20 - i * 3];
                }
                break;
        }

        lapok = ujPakli;
    }

    public Lap ezVolt() {
        if (db > 0) {
            return lapok[--db];
        }
        return null;
    }
}