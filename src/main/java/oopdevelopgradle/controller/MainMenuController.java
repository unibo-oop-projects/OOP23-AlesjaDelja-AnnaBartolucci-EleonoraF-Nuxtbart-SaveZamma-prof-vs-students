package oopdevelopgradle.controller;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * 1this class implements the MainMenuControllerInterface. It handles the interaction
 * with the main menu' of the application. This class implements the methods to start a new game,
 * to exit the application and to read the rules of the game.
 */
public final class MainMenuController implements MainMenuControllerInterface {
    private static final String GAME_PATH = "/GameView.fxml";
    private static final String GAME_HELP_PATH = "/HelpGameView.fxml";
    private static final String EXIT_TITLE = "Exit";
    private static final String EXIT_HEADER = "You are going to exit the game!";
    private static final String EXIT_CONTENT = "Are you sure?";
    private Stage stage;
    @Override
    public void newGame(final ActionEvent e) throws IOException {
        final StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, GAME_PATH);
    }
    @Override
    public void helpGame(final ActionEvent e) throws IOException {
        final StageChangeController stageChanger = new StageChangeController();
        stageChanger.changeScene(e, GAME_HELP_PATH);
    }
    @Override
    public void exitGame(final ActionEvent e) {
        final Alert exitAlert = new Alert(AlertType.CONFIRMATION);
        exitAlert.setTitle(EXIT_TITLE);
        exitAlert.setHeaderText(EXIT_HEADER);
        exitAlert.setContentText(EXIT_CONTENT);
        final Optional<ButtonType> result = exitAlert.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)
            && e.getSource() instanceof Node) {
            final Scene scene = ((Node) e.getSource()).getScene();
            if (scene != null) {
                final Window window = scene.getWindow();
                if (window instanceof Stage) {
                    stage = (Stage) window;
                    stage.close();
                    System.exit(0);
                }
            }
        }
    }
}
