package _OOP_develop_gradle.controller;

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

public class MenuController implements GameControllerInterface {
	
	@FXML
    private AnchorPane GameMainMenuRoot;
    @FXML
    private Button replayGameButton;
    
    @FXML
    private Button returnToMainButton;
    
    /**
     * This method is called when the FXML file is loaded and ready for use.
     * It sets the game status to false, indicating that the game is over now.
     */
    @FXML
    public void initData() {
    	GamePlayController.getInstance().setGameStatus(false);
    }
    
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
    