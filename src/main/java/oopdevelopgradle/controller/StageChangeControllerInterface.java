package oopdevelopgradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;

public interface StageChangeControllerInterface {

    /**
     * Helps changing from one scene to another without having to do it every single time.
     * @param e Listens to when the player clicks on this button
     * @param nameScene The location of the new FXML file. It has always to start from application.view.NameOfTheFile
     * @throws IOException
     */
    void changeScene(ActionEvent e, String nameScene) throws IOException;

    /**
     * Goes back to the main menu.
     * @param e Listens to when the player clicks on this button
     * @throws IOException
     */
    void mainMenu(ActionEvent e) throws IOException;
}
