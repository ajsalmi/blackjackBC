package test;

import blackjack.Kortti;
import blackjack.PelaajanKasi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PelaajanKasiTest {

    @org.junit.jupiter.api.Test
    void onkoBlackjack() {
        PelaajanKasi kasi = new PelaajanKasi();
        kasi.otaKortti(new Kortti(1, "Risti"));
        kasi.otaKortti(new Kortti(13, "Ruutu"));
        assertTrue(kasi.onkoBlackjack(), "Käsi on blackjack, mutta sitä ei pidetä sellaisena.");

        kasi = new PelaajanKasi();
        kasi.otaKortti(new Kortti(1, "Risti"));
        kasi.otaKortti(new Kortti(1, "Ruutu"));
        assertFalse(kasi.onkoBlackjack(), "Käsi ei ole blackjack, mutta sitä pidetään sellaisena.");

        kasi = new PelaajanKasi();
        kasi.otaKortti(new Kortti(10, "Risti"));
        kasi.otaKortti(new Kortti(10, "Ruutu"));
        kasi.otaKortti(new Kortti(1, "Ruutu"));
        assertFalse(kasi.onkoBlackjack(), "Käsi ei ole blackjack, mutta sitä pidetään sellaisena.");

    }

    @Test
    void selvitaSumma() {
        PelaajanKasi kasi = new PelaajanKasi();
        kasi.otaKortti(new Kortti(1, "Risti"));
        kasi.otaKortti(new Kortti(13, "Ruutu"));
        assertTrue(kasi.selvitaSumma() == 21);

        kasi = new PelaajanKasi();
        kasi.otaKortti(new Kortti(1, "Risti"));
        kasi.otaKortti(new Kortti(1, "Ruutu"));
        assertTrue(kasi.selvitaSumma() == 12);

        kasi = new PelaajanKasi();
        kasi.otaKortti(new Kortti(10, "Risti"));
        kasi.otaKortti(new Kortti(10, "Ruutu"));
        kasi.otaKortti(new Kortti(1, "Ruutu"));
        assertTrue(kasi.selvitaSumma() == 21);
    }
}