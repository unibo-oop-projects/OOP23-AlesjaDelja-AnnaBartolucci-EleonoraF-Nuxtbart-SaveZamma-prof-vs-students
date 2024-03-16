package _OOP_develop_gradle.model;

import javafx.stage.Stage;

public interface MainMenu {
		/**
		 * Starts the App
		 * @param primaryStage 
		 */
	    void start(Stage primaryStage);
	    /**
	     * Controlls that even when the player clicks the 'X', the game makes sure that the player is closing the game
	     * @param stage
	     */
	    void exitGame(Stage stage);

}
