package _OOP_develop_gradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;

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
     * When the player clicks on it, it changes the sound from on to off and from off to on.
     * In default this is set to ON.
     * @param e Listens to when the player clicks on this button
     */
    void sounds(ActionEvent e);

    /**
     * Closes the game when clicked.
     * @param e Listens to when the player clicks on this button
     */
    void exitGame(ActionEvent e);
}
