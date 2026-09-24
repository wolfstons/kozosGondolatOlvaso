package app;

import java.util.Scanner;

public class Program {

    static Scanner sc = new Scanner(System.in);
    static int oszlop;
    static Pakli pakli = new Pakli();

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            kirajzol();
            melyik();
            pakli.kever(oszlop);
        }

        pakli.ezVolt();
        kirajzol();               
    }

    private static void kirajzol() {
        System.out.printf("%-15s %-15s %-15s%n", "1.", "2.", "3.");

        Lap[] lapok = pakli.getLapok();

        for (int i = 0; i < 21; i += 3) {
            System.out.printf("%-15s %-15s %-15s%n",
                    lapok[i].megjelenit(),
                    lapok[i + 1].megjelenit(),
                    lapok[i + 2].megjelenit());
        }
    }

    private static void melyik() {

        System.out.println("Válassz egy kártyát");
        System.out.print("Melyik oszlopban van a választott kártya? (1-3): ");

        oszlop = sc.nextInt();

        while (oszlop < 1 || oszlop > 3) {
            System.out.print("Hibás választás! (1-3): ");
            oszlop = sc.nextInt();
        }
    }
}