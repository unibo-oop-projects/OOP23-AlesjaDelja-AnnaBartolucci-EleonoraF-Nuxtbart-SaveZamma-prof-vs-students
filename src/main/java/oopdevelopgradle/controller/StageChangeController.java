package oopdevelopgradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
 * StageChangeController gestisce il passaggio da una schermata ad un altra
 * all'interno dell'applicazione. Implementa l'interfaccia StageChangeControllerInterface
 * e fornisce i metodi per cambiare la schermata corrente ed arrivare al main menù.
 */
public class StageChangeController implements StageChangeControllerInterface {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void changeScene(final ActionEvent e, final String nameScene) throws IOException {
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
