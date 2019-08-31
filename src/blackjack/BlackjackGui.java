package blackjack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        Label emantaLabel = new Label("Emännän käsi");
        emanta.getChildren().add(emantaLabel);
        Label pelaajaLabel = new Label("Pelaajan käsi");
        pelaaja.getChildren().add(pelaajaLabel);
        Button jata = new Button("Jätä");
        Button lisaa = new Button("Lisää");
        nappulat.getChildren().add(jata);
        nappulat.getChildren().add(lisaa);

        primaryStage.setTitle("Blackjack!");
        jata.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        primaryStage.setScene(new Scene(juuri, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        BlackjackGui.launch(args);
    }
}


