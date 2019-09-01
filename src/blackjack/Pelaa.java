package blackjack;

public class Pelaa {

    private Korttipakka pakka;
    private PelaajanKasi pelaaja = new PelaajanKasi();
    private PelaajanKasi emanta = new PelaajanKasi();
    private boolean alustettu = false;

    public PelaajanKasi getPelaaja() {
        return pelaaja;
    }

    public PelaajanKasi getEmanta() {
        return emanta;
    }

    /**
     * Kutsu tätä ihan aluksi objektin luomisen jälkeen. Voidaan kutsua uudelleen uuden pelin
     * aloittamiseksi.
     */
    public void alusta() {
        this.pakka = new Korttipakka(4);
        this.pakka.sekoita();

        this.pelaaja = new PelaajanKasi();
        this.emanta = new PelaajanKasi();
        for(int i=0; i<2; i++) {
            emanta.otaKortti(pakka.jaaKortti());
            this.pelaaja.otaKortti(pakka.jaaKortti());
        }
    }

    /**
     * Ottaa lisäkortin pelaajalle.
     * @return Pelaajan PelaajanKasi-objekti kortin lisäyksen jälkeen.
     */
    public PelaajanKasi lisaa() {
        this.pelaaja.otaKortti(this.pakka.jaaKortti());
        return pelaaja;
    }

    /**
     * Pelaaja päättää jättää ottamatta enempää lisäkortteja.
     * @return Emannan PelaajanKasi-objekti kortin lisäyksen jälkeen.
     */
    public PelaajanKasi jata() {
        this.nostaEmannalle();
        return this.emanta;
    }

    private void nostaEmannalle(){
        if (!this.pelaaja.onkoBlackjack()) {
            while (true) {
                if (this.pelaaja.selvitaSumma() > 21)
                    break;
                else if(pelaaja.selvitaSumma() < emanta.selvitaSumma())
                    break;
                else if (15 > this.emanta.selvitaSumma()) {
                    this.emanta.otaKortti(this.pakka.jaaKortti());
                } else
                    break;
            }
        }
    }

    /**
     * Määrittää onko voittajaa, ja kumpi on voittaja.
     * @return null kun peli on kesken. PelaajanKäsi muussa tapauksessa.
     */
    public PelaajanKasi getVoittaja() {
        if(this.pelaaja.selvitaSumma() > 21)
            return this.emanta;
        else if(emanta.selvitaSumma() > 21)
            return this.pelaaja;
        else if(emanta.selvitaSumma() >= pelaaja.selvitaSumma())
            return this.emanta;
        else
            return this.pelaaja;
    }

}
