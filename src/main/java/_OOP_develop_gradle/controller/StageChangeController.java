package _OOP_develop_gradle.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageChangeController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	/**
	 * It helps changing from a scene to another one without having to do in every single time
	 * @param e Listens to when the player click on this buttons
	 * @param nameScene The location of the new FXML file. It has always to start from application.view.NameOfTheFile
	 * @throws IOException
	 */
	public void changeScene(ActionEvent e, String nameScene) throws IOException {
		root = FXMLLoader.load(getClass().getResource(nameScene));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Goes Back to Main Menu
	 * @param e Listens to when the player click on this buttons
	 * @throws IOException
	 */
	
	public void mainMenu(ActionEvent e ) throws IOException {
		changeScene(e , "../view/MainMenuView.fxml");
	}
}
