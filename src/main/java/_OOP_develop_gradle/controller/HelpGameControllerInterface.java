package _OOP_develop_gradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;

public interface HelpGameControllerInterface {

    /**
     * Goes back to the main menu.
     * @param e Listens to when the player clicks on this button
     * @throws IOException
     */
    void back(ActionEvent e) throws IOException;
}
