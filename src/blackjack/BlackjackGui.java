package blackjack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: häkkyrä ei tunnista uutta korttia otettaessa meneekö summa yli 21, ja lopeta peliä.


public class BlackjackGui extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Ladonta
        VBox juuri = new VBox();
        HBox emanta = new HBox();
        HBox pelaaja = new HBox();
        HBox nappulat = new HBox();
        juuri.getChildren().add(emanta);
        juuri.getChildren().add(pelaaja);
        juuri.getChildren().add(nappulat);

        // Nappulat ja tekstikentät.
        Label emantaLabel = new Label("Emännän käsi: ");
        Label emantaKasi = new Label("-");
        emanta.getChildren().add(emantaLabel);
        emanta.getChildren().add(emantaKasi);
        Label pelaajaLabel = new Label("Pelaajan käsi: ");
        Label pelaajaKasi = new Label("-");
        pelaaja.getChildren().add(pelaajaLabel);
        pelaaja.getChildren().add(pelaajaKasi);
        Button jata = new Button("Jätä");
        Button lisaa = new Button("Lisää");
        Button uusiPeli = new Button("Uusi peli");
        nappulat.getChildren().add(jata);
        nappulat.getChildren().add(lisaa);
        nappulat.getChildren().add(uusiPeli);

        // Pelaa-objekti, sekä nappuloiden toiminta.
        Pelaa peli = new Pelaa();
        primaryStage.setTitle("Blackjack!");
        jata.setOnAction(event -> {
            emantaKasi.setText(peli.jata().toString());
            primaryStage.setTitle("Voittaja on " + (peli.getVoittaja().equals(peli.getEmanta()) ?
                    " Emäntä!" :
                    " Pelaaja!"));
        });
        lisaa.setOnAction(event -> {
            pelaajaKasi.setText(peli.lisaa().toString());
        });
        uusiPeli.setOnAction(event -> {
            peli.alusta();
            primaryStage.setTitle("Blackjack!");
            emantaKasi.setText(peli.getEmanta().toString());
            pelaajaKasi.setText(peli.getPelaaja().toString());
        });
        primaryStage.setScene(new Scene(juuri, 400, 80));
        primaryStage.show();
    }

    public static void main(String[] args) {
        BlackjackGui.launch(args);
    }
}


