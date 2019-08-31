/*
Pelaa
        alusta()    -- Alustaa tarvittavat muuttuja ja tekee muut aloitustoimet. Pitää toimia jo
                       alustettuun objektiin, resetoiden sen alkutilaan.

        pelaaja     -- Palauttaa PelaajanKasi-objektin tekstiesityksen tulostamista varten.

        emanta      -- Palauttaa PelaajanKasi-objektin tekstiesityksen tulostamista varten.

        lisaa       -- Ottaa pelaajan käteen kortin, ja palauttaa PelaajanKasi-objektin.

        jata        -- Ottaa emännälle ehtojen mukaan kortteja, ja arvioi voittajan. Voittanut
                       PelaajanKasi-objekti palautetaan tulostamista varten.

*/

package blackjack;

public class Pelaa {

    private Korttipakka pakka;
    private PelaajanKasi pelaaja = new PelaajanKasi();
    private PelaajanKasi emanta = new PelaajanKasi();
    private boolean alustettu = false;
    private boolean jatetty = false;  // Voittajan arviointia varten.

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
                else if (15 > this.emanta.selvitaSumma()) {
                    this.emanta.otaKortti(this.pakka.jaaKortti());
                } else
                    break;
            }
        }
    }
}
