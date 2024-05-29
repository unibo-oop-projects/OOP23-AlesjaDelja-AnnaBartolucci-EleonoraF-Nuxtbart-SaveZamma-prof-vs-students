package oopdevelopgradle.model;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import oopdevelopgradle.controller.GamePlayController;
/**
 * This class implements the methods of the main menu'.
 */
public final class MainMenuImp extends Application implements MainMenu {
private static final String MAIN_MENU_PATH = "/MainMenuView.fxml";
	private static final String EXIT_TITLE = "Exit";
	private static final String EXIT_HEADER = "You are going to exit the game!";
	private static final String EXIT_CONTENT = "Are you sure?";
	private final Logger log = Logger.getLogger(GamePlayController.class.getName());
	@Override
		public void start(final Stage primaryStage) {
			try {
				final Parent root = FXMLLoader.load(getClass().getResource(MAIN_MENU_PATH));
				final Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setOnCloseRequest(event -> {
					//so when we click on cancel it return to the main menu
					event.consume();
					exitGame(primaryStage);
					});
			} catch (IOException e) {
				log.fine(e.toString());
			}
		}
		@Override
		public void exitGame(final Stage stage) {
			//Insert an alert that makes sure that the user is sure about exiting the game
			final Alert exitAlert = new Alert(AlertType.CONFIRMATION);
			exitAlert.setTitle(EXIT_TITLE);
			exitAlert.setHeaderText(EXIT_HEADER);
			exitAlert.setContentText(EXIT_CONTENT);
			if (exitAlert.showAndWait().get().equals(ButtonType.OK)) {
				stage.close();
				System.exit(0);
			}
		}
	}
