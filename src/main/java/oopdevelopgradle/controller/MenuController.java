package oopdevelopgradle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * This class implements the GameControllerInterface. It handles the changing scene from
 * the game play to returning back to the main menu' or replay another match.
 */
public class MenuController implements GameControllerInterface {
	@FXML
    private AnchorPane gameMainMenuRoot;
    @FXML
    private Button replayGameButton;
    @FXML
    private Button returnToMainButton;
    /**
     * Handles the action event triggered by clicking the "Return to main menu" button.
     * Closes all windows except the main menu and brings back to the main menu.
     * 
     * @param event The action event triggered by clicking the "Return to main menu" button.
     * @throws IOException If an I/O exception occurs while going back to the main menu.
     */
    @Override
	public void back(final ActionEvent event) throws IOException {
        closeAllWindows();
        final StageChangeController stageChanger = new StageChangeController();
        stageChanger.mainMenu(event);
    }
    /**
     * Handles the action event triggered by clicking the "Replay" button.
     * Closes the current window, closes all other windows, and opens a new game window.
     * 
     * @param event The action event triggered by clicking the "Replay" button.
     * @throws IOException If an I/O exception occurs while loading the game window.
     */
    @FXML
    void replay(final ActionEvent event) throws IOException {
        final Stage menuScene = (Stage) replayGameButton.getScene().getWindow();
        menuScene.close();
        closeAllWindows();
        final FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/GameView.fxml"));
        final AnchorPane game = gameLoader.load();
        final Scene gameScene = new Scene(game);
        final Stage newGameStage = new Stage();
        newGameStage.setScene(gameScene);
        newGameStage.show();

    }
    /**
     * Closes all windows except the main menu window.
     */
    private void closeAllWindows() {
        final ObservableList<Window> windows = Window.getWindows();
        final List<Window> windowsCopy = new ArrayList<>(windows);
        for (final Window window : windowsCopy) {
            if (window instanceof Stage) {
                final Stage stage = (Stage) window;
                if (!"MainMenu".equals(stage.getTitle())) {
                    stage.close();
                }
            }
        }
    }
}
