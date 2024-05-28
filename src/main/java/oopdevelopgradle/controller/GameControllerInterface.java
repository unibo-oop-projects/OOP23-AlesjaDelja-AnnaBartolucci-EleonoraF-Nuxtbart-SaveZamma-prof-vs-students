package oopdevelopgradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
/**
 * Interface representing the Controller for exit the gameplay and go back to the menu.
 */
public interface GameControllerInterface {

    /**
     * Goes back to the main menu.
     * @param e Listens to when the player clicks on this button
     * @throws IOException
     */
    void back(ActionEvent e) throws IOException;

}
