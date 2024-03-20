package _OOP_develop_gradle.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainMenuController implements MainMenuControllerInterface {
    private static final String GAME_PATH = "/GameView.fxml";
    private static final String GAME_HELP_PATH = "/HelpGameView.fxml";
	private static final String EXIT_TITLE = "Exit";
	private static final String EXIT_HEADER = "You are going to exit the game!";
	private static final String EXIT_CONTENT = "Are you sure?";
    Stage stage;

    @Override
    public void newGame(ActionEvent e) throws IOException {
        StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, GAME_PATH);
    }

    @Override
    public void helpGame(ActionEvent e) throws IOException {
        StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, GAME_HELP_PATH);
    }

    
    @Override
    public void exitGame(ActionEvent e) {
        Alert exitAlert = new Alert(AlertType.CONFIRMATION);
        exitAlert.setTitle(EXIT_TITLE);
        exitAlert.setHeaderText(EXIT_HEADER);
        exitAlert.setContentText(EXIT_CONTENT);
                
        if(exitAlert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.close();
            System.exit(0);
        }
        
    }
}