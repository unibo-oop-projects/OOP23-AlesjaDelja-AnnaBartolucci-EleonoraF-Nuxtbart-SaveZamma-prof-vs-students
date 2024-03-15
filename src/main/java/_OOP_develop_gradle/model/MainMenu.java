package _OOP_develop_gradle.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainMenu extends Application {
		@Override
		public void start(Stage primaryStage) {
			try {
				System.out.println(getClass().getResource("/MainMenuView.fxml"));
			    //Parent root = FXMLLoader.load(ClassLoader.getSystemResource("MainMenuView.fxml"));
				Parent root = FXMLLoader.load(getClass().getResource("/MainMenuView.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setOnCloseRequest(event -> {
					//so when we click on cancel it return to the main menu
					event.consume();
					exitGame(primaryStage);
					});
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void exitGame(Stage stage) {
			
			//Insert an alert that makes sure that the user is sure about exiting the game
			Alert exitAlert = new Alert(AlertType.CONFIRMATION);
			exitAlert.setTitle("Exit");
			exitAlert.setHeaderText("You are going to exit the game!");
			exitAlert.setContentText("Are you sure?");
			if(exitAlert.showAndWait().get() == ButtonType.OK) {
				stage.close();
			}
		}
	}
