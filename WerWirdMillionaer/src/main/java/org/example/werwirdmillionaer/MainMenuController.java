package org.example.werwirdmillionaer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private Button playButton;

    @FXML
    private Button highscoreButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button exitButton;

    @FXML
    public VBox vbox;

    public void startGame() {
        System.out.println("Game started!");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/werwirdmillionaer/Game.fxml"));
            Parent gameRoot = loader.load();

            Scene currentScene = playButton.getScene();
            currentScene.setRoot(gameRoot);

            GameController gameController = loader.getController();
            System.out.println("Switched to game screen successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading Game.fxml: " + e.getMessage());
        }
    }

    public void showHighscore() {
        System.out.println("Highscore shown!");
        // Füge die Logik zum Anzeigen der Highscores hinzu
    }

    public void showSettings() {
        System.out.println("Settings shown!");
        // Füge die Logik für Einstellungen hinzu
    }

    public void exitGame() {
        System.out.println("Game exited!");
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Hintergrundbild setzen
        Image hintergrundMainMenue = new Image(getClass().getResourceAsStream("/org/example/werwirdmillionaer/HintergrundMainMenue.jpg"));
        BackgroundImage backgroundImage = new BackgroundImage(hintergrundMainMenue,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        vbox.setBackground(new Background(backgroundImage));

        // Bilder für die Buttons setzen und Größe anpassen
        ImageView playImageView = new ImageView(new Image(getClass().getResourceAsStream("/org/example/werwirdmillionaer/play.png")));
        playImageView.setFitWidth(64);  // Setze die Breite auf 64 Pixel
        playImageView.setFitHeight(64); // Setze die Höhe auf 64 Pixel
        playButton.setGraphic(playImageView);

        ImageView settingsImageView = new ImageView(new Image(getClass().getResourceAsStream("/org/example/werwirdmillionaer/settings.png")));
        settingsImageView.setFitWidth(64);
        settingsImageView.setFitHeight(64);
        settingsButton.setGraphic(settingsImageView);

        ImageView exitImageView = new ImageView(new Image(getClass().getResourceAsStream("/org/example/werwirdmillionaer/logout.png")));
        exitImageView.setFitWidth(64);
        exitImageView.setFitHeight(64);
        exitButton.setGraphic(exitImageView);
    }

}
