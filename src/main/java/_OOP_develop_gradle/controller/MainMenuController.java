package _OOP_develop_gradle.controller;

import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuController implements MainMenuControllerInterface {
    private boolean soundOn;
    public Button soundButton;
    public static MediaPlayer mediaPlayer;
    private static final String GAME_PATH = "/GameView.fxml";
    private static final String GAME_HELP_PATH = "/HelpGameView.fxml";
    private static final String SOUND_PATH = "/music/background.wav";
    private static final String SOUND_ON = "Sound On";
    private static final String SOUND_OFF = "Sound Off";
    private static final String EXIT_TITLE = "Exit";
    private static final String EXIT_HEADER = "You are going to exit the game!";
    private static final String EXIT_CONTENT = "Are you sure?";
    private Stage stage;

    public MainMenuController() {
        // Carica lo stato del suono dalle preferenze dell'applicazione
        Preferences prefs = Preferences.userNodeForPackage(MainMenuController.class);
        soundOn = prefs.getBoolean("soundOn", true);
    }

    @Override
    public void newGame(ActionEvent e) throws IOException {
        StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, GAME_PATH);
    }
@Override
    public void helpGame(ActionEvent e) throws IOException {
        StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, GAME_HELP_PATH);
    }

    @Override
    public void sounds(ActionEvent e) {
        if (soundOn) {
            soundOn = false;
            soundButton.setText(SOUND_OFF);
            Media sound = new Media(getClass().getResource(SOUND_PATH).toString()); 
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setStartTime(Duration.seconds(0));
            mediaPlayer.setStopTime(Duration.seconds(50));
            mediaPlayer.play();
        } else {
            soundOn = true;
            soundButton.setText(SOUND_ON);
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        }
        // Salva lo stato del suono nelle preferenze dell'applicazione
        Preferences prefs = Preferences.userNodeForPackage(MainMenuController.class);
        prefs.putBoolean("soundOn", soundOn);
    }
@Override
    public void exitGame(ActionEvent e) {
        Alert exitAlert = new Alert(AlertType.CONFIRMATION);
        exitAlert.setTitle(EXIT_TITLE);
        exitAlert.setHeaderText(EXIT_HEADER);
        exitAlert.setContentText(EXIT_CONTENT);

        if(exitAlert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.close();
            System.exit(0);
        }
        resetSoundState();
    }

    public void resetSoundState() {
        soundOn = true;
        soundButton.setText(SOUND_OFF);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        // Salva lo stato del suono nelle preferenze dell'applicazione
        Preferences prefs = Preferences.userNodeForPackage(MainMenuController.class);
        prefs.putBoolean("soundOn", soundOn);
    }
}