package oopdevelopgradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
/**
 * THe interface MainMenuControllerInterface defines the methods to handle
 * the interaction with the main menu' of the application.
 */
public interface MainMenuControllerInterface {

    /**
     * Starts a default game.
     * @param e Listens to when the player clicks on this button
     * @throws IOException
     */
    void newGame(ActionEvent e) throws IOException;

    /**
     * Changes to the view to help the players on how to play the game.
     * @param e Listens to when the player clicks on this button
     * @throws IOException
     */
    void helpGame(ActionEvent e) throws IOException;

    /**
     * Closes the game when clicked.
     * @param e Listens to when the player clicks on this button
     */
    void exitGame(ActionEvent e);
}
