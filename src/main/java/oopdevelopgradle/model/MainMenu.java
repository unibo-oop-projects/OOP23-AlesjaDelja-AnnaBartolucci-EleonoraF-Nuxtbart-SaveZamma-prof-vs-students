package oopdevelopgradle.model;

import javafx.stage.Stage;

/**
 * The interface MainMenu provides the methods to start and exit from the game.
 */
public interface MainMenu {
    /**
     * Starts the game.
     * 
     * @param primaryStage
     */
    void start(Stage primaryStage);

    /**
     * Makes sure that the player is closing the game.
     * 
     * @param stage
     */
    void exitGame(Stage stage);

}
