package _OOP_develop_gradle.controller;

import java.io.IOException;
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
    private static boolean soundOn = true;
    public static Button soundButton;
    public static MediaPlayer mediaPlayer;
    private static final String GAME_PATH = "/GameView.fxml";
    private static final String GAME_HELP_PATH = "/HelpGameView.fxml";
    private static final String SOUND_PATH = "/music/background.wav";
    private static final String SOUND_ON = "Sound On";
    private static final String SOUND_OFF = "Sound Off";
	private static final String EXIT_TITLE = "Exit";
	private static final String EXIT_HEADER = "You are going to exit the game!";
	private static final String EXIT_CONTENT = "Are you sure?";
    Stage stage;

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
    	System.out.println(getClass().getResource(SOUND_PATH).toString());
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
			resetSoundState();
		}
        /*
			 * else { soundOn = true; soundButton.setText(SOUND_ON); if (mediaPlayer !=
			 * null) { mediaPlayer.stop(); } }
			 */
    }
    
    public static void resetSoundState() {
        try {
			soundOn = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			soundButton.setText(SOUND_ON);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
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
            resetSoundState();
            System.exit(0);
            
        }    
        
    }
}