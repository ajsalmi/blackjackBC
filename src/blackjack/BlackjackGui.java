/* TODO: Siirtää voittajan määrittävä toiminnallisuus Pelaa-luokkaan.
 */

package blackjack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BlackjackGui extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Ladonta
        VBox juuri = new VBox();
        HBox emannanHBox = new HBox();
        HBox pelaajanHBox = new HBox();
        HBox nappuloidenHBox = new HBox();
        juuri.getChildren().add(emannanHBox);
        juuri.getChildren().add(pelaajanHBox);
        juuri.getChildren().add(nappuloidenHBox);

        // Nappulat ja tekstikentät.
        Label emannanSeliteLabel = new Label("Emännän käsi: ");
        Label emannanKasiLabel = new Label("-");
        emannanHBox.getChildren().add(emannanSeliteLabel);
        emannanHBox.getChildren().add(emannanKasiLabel);
        Label pelaajanSeliteLabel = new Label("Pelaajan käsi: ");
        Label pelaajanKasiLabel = new Label("-");
        pelaajanHBox.getChildren().add(pelaajanSeliteLabel);
        pelaajanHBox.getChildren().add(pelaajanKasiLabel);
        Button jata = new Button("Jätä");
        Button lisaa = new Button("Lisää");
        Button uusiPeli = new Button("Uusi peli");
        nappuloidenHBox.getChildren().add(jata);
        nappuloidenHBox.getChildren().add(lisaa);
        nappuloidenHBox.getChildren().add(uusiPeli);

        // Pelaa-objekti, sekä nappuloiden toiminta.
        Pelaa peli = new Pelaa();
        primaryStage.setTitle("");
        jata.setOnAction(event -> {
            emannanKasiLabel.setText(peli.jata().toString());
            primaryStage.setTitle("Voittaja on " + (peli.getVoittaja().equals(peli.getEmanta()) ?
                    " emäntä!" :
                    " pelaaja!"));
        });
        lisaa.setOnAction(event -> {
            PelaajanKasi pelaaja = peli.getPelaaja();
            if (pelaaja.selvitaSumma() <= 20){
                pelaajanKasiLabel.setText(peli.lisaa().toString());
            }
            else if (peli.getPelaaja().selvitaSumma() == 21)
                primaryStage.setTitle("Haluatko hävitä?");
            if (peli.getPelaaja().selvitaSumma() > 21) {
                pelaajanKasiLabel.setText(pelaajanKasiLabel.getText() + (pelaajanKasiLabel.getText().contains("YLI")
                        ? "" : " -- YLI MENI!"));
                primaryStage.setTitle("Voittaja on emäntä!");
            }
        });
        uusiPeli.setOnAction(event -> {
            peli.alusta();
            primaryStage.setTitle("");
            emannanKasiLabel.setText(peli.getEmanta().toString());
            pelaajanKasiLabel.setText(peli.getPelaaja().toString());
            if(peli.getPelaaja().onkoBlackjack())
                primaryStage.setTitle("BLACKJACK! Voittaja on pelaaja!");
        });
        primaryStage.setScene(new Scene(juuri, 400, 80));

        primaryStage.show();
    }

    public static void main(String[] args) {
        BlackjackGui.launch(args);
    }
}


