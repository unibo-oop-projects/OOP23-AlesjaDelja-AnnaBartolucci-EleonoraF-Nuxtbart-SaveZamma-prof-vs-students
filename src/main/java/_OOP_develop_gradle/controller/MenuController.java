package _OOP_develop_gradle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MenuController implements GameControllerInterface {
	
	@FXML
    private AnchorPane GameMainMenuRoot;
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
	public void back(ActionEvent event) throws IOException {
        closeAllWindows();
     // Chiudi la finestra corrente
		/*
		 * Stage menuScene = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 * menuScene.close();
		 * 
		 * // Interrompi la riproduzione della musica
		 * MainMenuController.resetSoundState();
		 */
        StageChangeController stageChanger = new StageChangeController();
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
    void replay(ActionEvent event) throws IOException {
    	
        Stage menuScene = (Stage) replayGameButton.getScene().getWindow();
        menuScene.close();
        closeAllWindows();
       
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/GameView.fxml"));
        AnchorPane game = gameLoader.load();
        
        Scene gameScene = new Scene(game);
        Stage newGameStage = new Stage();
        newGameStage.setScene(gameScene);
        newGameStage.show();

    }

    /**
     * Closes all windows except the main menu window.
     */
    private void closeAllWindows() {
        ObservableList<Window> windows = Window.getWindows();
        
        List<Window> windowsCopy = new ArrayList<>(windows);

        for (Window window : windowsCopy) {
            if (window instanceof Stage) {
                Stage stage = (Stage) window;

                if (!"MainMenu".equals(stage.getTitle())) {
                    stage.close();
                }
            }
        }
    }
    
}
