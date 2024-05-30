package oopdevelopgradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

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
        if (e.getSource() instanceof Node) {
            final Scene sourceScene = ((Node) e.getSource()).getScene();
            if (sourceScene != null) {
                final Window window = sourceScene.getWindow();
                if (window instanceof Stage) {
                    stage = (Stage) window;
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    return;
                } 
               } 
        }
    }

    @Override
    public void mainMenu(final ActionEvent e) throws IOException {
        changeScene(e, "/MainMenuView.fxml");
    }
}
