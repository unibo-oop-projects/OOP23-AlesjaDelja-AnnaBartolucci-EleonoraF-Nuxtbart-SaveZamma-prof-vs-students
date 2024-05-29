package oopdevelopgradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * StageChangeController handle the changing from a scene to another in the
 * application. Implements StageChangeControllerInterface and provides the
 * methods to change scene and to reach the main menù.
 */
public final class StageChangeController implements StageChangeControllerInterface {
    @Override
    public void changeScene(final ActionEvent e, final String nameScene) throws IOException {
        final Stage stage;
        final Scene scene;
        final Parent root;
        root = FXMLLoader.load(getClass().getResource(nameScene));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void mainMenu(final ActionEvent e) throws IOException {
        changeScene(e, "/MainMenuView.fxml");
    }
}
