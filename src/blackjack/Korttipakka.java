// Tehtävänanto tälle luokalle.
//    Toteuta luokka Korttipakka, jolla on ArrayList<Kortti>-tyyppinen
//    atribuutti pakka. Luokan oletuskonstruktori sijoittaa pakka-atribuuttiin
//    halutun määrän 52 korttisia korttipakkoja numero- ja maajärjestyksessä.
//    Toteuta luokkaan metodi sekoita, joka sekoittaa atribuutin pakka korttien
//    järjestyksen. Toteuta lisäksi metodi jaaKortti, joka palauttaa pakan
//    ensimmäisen kortin ja poistaa sen pakasta.
package blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Mikko Kujala
 */
public class Korttipakka {

    private ArrayList<Kortti> pakka = new ArrayList<>();

    /**
     * @param pakkoja on 52-kortin pakkojen määrä.
     */
    public Korttipakka(int pakkoja) {
        String[] maat = new String[]{"Hertta", "Ruutu", "Pata", "Risti"};
        for (int i = 0; i < pakkoja; i++) {
            for (String maa : maat) {
                for (int j = 1; j <= 13; j++) {
                    Kortti kortti = new Kortti(j, maa);
                    this.pakka.add(kortti);
                }
            }
        }
    }

    /**
     * Sekoittaa korttipakat.
     */
    public void sekoita() {
        Collections.shuffle(this.pakka); // todo: pois kommentoi
    }

    /**
     * Jaa pakasta
     * @return kortti.
     */
    public Kortti jaaKortti() {
        Kortti ret = pakka.get(0);
        pakka.remove(0);
        return ret;
    }
}
