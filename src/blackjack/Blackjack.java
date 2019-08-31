
package blackjack;

import javafx.stage.Stage;

import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("blackjack");
        System.out.println();

        Korttipakka pakka = new Korttipakka(4);
        pakka.sekoita();

        PelaajanKasi pelaaja = new PelaajanKasi();
        PelaajanKasi emanta = new PelaajanKasi();
        pelaaja.otaKortti(pakka.jaaKortti());
        emanta.otaKortti(pakka.jaaKortti());
        pelaaja.otaKortti(pakka.jaaKortti());
        emanta.otaKortti(pakka.jaaKortti());

        String lisaako;
        // Pelaajan korttien veto.
        while (true) {
            System.out.println("Emäntä: " + emanta);
            System.out.println("Pelaaja: " + pelaaja);
            if(pelaaja.onkoBlackjack()) {
                System.out.println("Onneksi olkoon! Sait blackjackin!");
                break;
            }
            System.out.print("Otetaanko lisäkortti? (k/e) ");
            lisaako = lukija.nextLine();
            if(lisaako.startsWith("k")){
                pelaaja.otaKortti(pakka.jaaKortti());
            }
            else
                break;
            if(pelaaja.selvitaSumma() > 21) {
                System.out.println("Pelaaja: " + pelaaja);
                break;
            }
        }

        // Emännän korttien veto.
        if (!pelaaja.onkoBlackjack()) {
            while (true) {
                System.out.println("Emäntä: " + emanta);
                if (pelaaja.selvitaSumma() > 21)
                    break;
                    //else if(pelaaja.selvitaSumma() > emanta.selvitaSumma()){
                else if (15 > emanta.selvitaSumma()) {
                    emanta.otaKortti(pakka.jaaKortti());
                    System.out.println("Emäntä: " + emanta);
                } else
                    break;
            }
        }

        // Loppuyhteenweto.
        System.out.println("Emäntä: " + emanta);
        System.out.println("Pelaaja: " + pelaaja);
        String voittaja;
        if(pelaaja.selvitaSumma() > 21)
            voittaja = "Emäntä";
        else if(emanta.selvitaSumma() > 21)
            voittaja = "Pelaaja";
        else if(emanta.selvitaSumma() >= pelaaja.selvitaSumma())
            voittaja = "Emäntä";
        else
            voittaja = "Pelaaja";

        System.out.println("Voittaja on " + voittaja);
    }
    
}
