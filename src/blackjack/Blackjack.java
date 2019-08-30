
package blackjack;

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
        while (true) {
            System.out.println(emanta);
            System.out.println(pelaaja);
            System.out.print("Otetaanko lisäkortti? (k/e) ");
            lisaako = lukija.nextLine();
            if(lisaako.startsWith("k")){
                pelaaja.otaKortti(pakka.jaaKortti());
            }
            else
                break;
            if()
        }

        System.out.println("Jenni was here!");
        //
        
    }
    
}
