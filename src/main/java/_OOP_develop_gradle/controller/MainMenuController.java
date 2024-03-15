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

public class MainMenuController {
	private boolean soundOn = true;
    public Button soundButton;
    public static MediaPlayer mediaPlayer;
	Stage stage;
	
	/**
	 * Starts a default game
	 * @param e Listens to when the player click on this buttons
	 * @throws IOException 
	 */
	
	public void newGame(ActionEvent e) throws IOException {
		StageChangeController stageChanger = new StageChangeController();
		stageChanger.changeScene(e, "/GameView.fxml");
		//CONTROLLARE SE SERVE ANCORA MAIN MENUVIEW.FXML E MAIN MENU CONTROLLER DELL'ANNA
	}
	
	/**
	 * Changes to the view help the playes on how it's played the game
	 * @param e Listens to when the player click on this buttons
	 */
	public void helpGame(ActionEvent e) throws IOException {
		StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, "/HelpGameView.fxml");
	}
	
	/**
	 * When The player click on it it changes the sound from on to off and from off to on.
	 * In default this is set to ON
	 * @param e Listens to when the player click on this buttons
	 */
	public void sounds(ActionEvent e) {
		if (soundOn) {
            soundOn = false;
            soundButton.setText("Sound Off");
            Media sound = new Media(getClass().getResource("/music/background.wav").toString()); // DA CAMBIARE LA PATH
	        mediaPlayer = new MediaPlayer(sound);
	        mediaPlayer.setAutoPlay(true);
	        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	        mediaPlayer.setStartTime(Duration.seconds(0));
	        mediaPlayer.play();
        } else {
            soundOn = true;
            soundButton.setText("Sound On");
            mediaPlayer.stop();
        }
	}
	/**
	 * Changes from the main menu to the leaderboard menu.
	 * @param e
	 * @throws IOException
	 */
	public void leaderboard(ActionEvent e) throws IOException {
		StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, "/LeaderBoard.fxml");
	}
	/**
	 * Closes the game when clicked
	 * @param e Listens to when the player click on this buttons
	 */
	public void exitGame(ActionEvent e) {
		//Insert an alert that makes sure that the user is sure about exiting the game
		Alert exitAlert = new Alert(AlertType.CONFIRMATION);
		exitAlert.setTitle("Exit");
		exitAlert.setHeaderText("You are going to exit the game!");
		exitAlert.setContentText("Are you sure?");
				
		if(exitAlert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			stage.close();
		}		
				
	}
	
}


