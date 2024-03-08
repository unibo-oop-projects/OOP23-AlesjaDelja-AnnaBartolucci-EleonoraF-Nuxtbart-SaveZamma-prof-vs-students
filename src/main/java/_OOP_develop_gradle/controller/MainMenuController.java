package _OOP_develop_gradle.controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class MainMenuController {
	
	/**
	 * Starts a default game
	 * @param e Listens to when the player click on this buttons
	 */
	
	public void newGame(ActionEvent e) {
		//TO-DO Farlo andare all'inizio del gioco dell'Anna
		System.out.println("New Game");
	}
	
	/**
	 * Changes to the view when the player can decide how he/she wants to play and it's difficulty
	 * @param e Listens to when the player click on this buttons
	 */
	public void costumeGame(ActionEvent e) throws IOException {
		StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, "../view/CustomeGameView.fxml");
	}
	
	/**
	 * When The player click on it it changes the sound from on to off and from off to on.
	 * In default this is set to ON
	 * @param e Listens to when the player click on this buttons
	 */
	public void sounds(ActionEvent e) {
		//TO-DO Cambiare il coso dell'Anna per il suono e metterlo tutto da parte in modo che sia più comprensibile
		System.out.println("Sounds");
	}
	
	public void leaderboard(ActionEvent e) throws IOException {
		StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, "../view/LeaderBoard.fxml");
	}
	/**
	 * Closes the game when clicked
	 * @param e Listens to when the player click on this buttons
	 */
	public void exitGame(ActionEvent e) {
		//TO-DO Uscire dal gioco
		System.out.println("Exit Game");
	}
	
}


