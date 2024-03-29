//    Toteuta luokka Kortti, jolla on atribuutit arvo (int) ja maa (String).
//    Toteuta luokkaan parametrillinen konstruktori, get- ja set- metodit
//    ja toString-metodi.

package blackjack;

/**
 *
 * @author Mikko Kujala
 */
public class Kortti {

    private int arvo = -1;
    private String maa = "NONE";

    public Kortti(int arvo, String maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public String getMaa() {
        return maa;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    @Override
    public String toString() {
        return maa + " " + this.arvo;
    }
}
