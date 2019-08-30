//    Toteuta luokka PelaajanKasi, jolla on ArrayList<Kortti>-tyyppinen atribuutti
//    kortit. Toteuta luokkaan metodi otaKortti, joka lisää kortit-listaan
//    parametrina saamansa kortin. Toteuta luokkaan lisäksi metodi selvitäSumma,
//    joka selvittää pelaajan käden summan seuraavin säännöin:
//
//    kortin arvo 2-10:         käden summaan lisätään kortin numeroa vastaava arvo
//    kortin arvo 11-13:        käden summaan lisätään 10
//    kortin arvo 1 (ässä):	käden summaan lisätään 11
//
//    Mikäli korttein yhteissummaksi tuli yli 21, niin vähennetään summasta 10.
//    Tässä tilanteessa on saatu kaksi ässää, jolloin toisen ässän tulkitaan
//    olevan arvoltaan 1.
//
//
//    Blackjackiksi kutsutaan tilannetta , jolla pelaajalla on kaksi korttia,
//    joista toinen on arvoltaan 10-13 ja toinen ässä. Toteuta luokkaan PelaajanKasi
//    metodi joka tutkii onko kätenä blackjack.

package blackjack;

import java.util.ArrayList;

/*
 *
 * @author Mikko Kujala
 */
public class PelaajanKasi {

    private ArrayList<Kortti> kortit = new ArrayList<>();
    private int montakoAssaaMuutettuYkkoseksi = 0;

    public void otaKortti(Kortti kortti) {
        kortit.add(kortti);
    }

    public boolean onkoBlackjack() {
        return onkoJompikumpiAssa(this.kortit.get(0), this.kortit.get(1))
                && onkoJompikumpiKympistaKurkoon(this.kortit.get(0), this.kortit.get(1));
    }

    private boolean onkoJompikumpiAssa(Kortti kortti, Kortti kortti2) {
        return (kortti.getArvo() == 1) ^ (kortti2.getArvo() == 1);
    }

    private boolean onkoJompikumpiKympistaKurkoon(Kortti kortti, Kortti kortti2) {
        return (kortti.getArvo() >= 10 && kortti.getArvo() <= 13) ^ (kortti2.getArvo() >= 10 && kortti2.getArvo() <= 13);
    }


    public int selvitaSumma() {
        int summa = 0;
        for(Kortti kortti: this.kortit) {
            if (kortti.getArvo() >= 2 && kortti.getArvo() <= 10)
                summa += kortti.getArvo();
            else if (kortti.getArvo() >= 11 && kortti.getArvo() <= 13)
                summa += 10;
            else {
                summa += 11;
                if(summa > 21)
                    summa -= 10;
            }
        }
        return summa;
    }

    @Override
    public String toString() {
        String ret = "";
        for(Kortti kortti : this.kortit)
            ret += kortti + ", ";
        ret += "Summa: " + this.selvitaSumma();
        return ret;
    }
}
