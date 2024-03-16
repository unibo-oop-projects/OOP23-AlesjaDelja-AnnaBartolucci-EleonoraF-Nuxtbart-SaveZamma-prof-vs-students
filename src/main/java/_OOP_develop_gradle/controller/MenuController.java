package _OOP_develop_gradle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import _OOP_develop_gradle.view.GamePlayView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MenuController {
	//@FXML
	//private Button resumeButton;

	@FXML
    private AnchorPane GameMainMenuRoot;
    @FXML
    private Button replayGameButton;
    @FXML
    public void initData() {
    	GamePlayController.getInstance().setGameStatus(false); // Per mettere in pausa quando apro il menu
    }
    
    @FXML
    void back(ActionEvent event) throws IOException {
        //GamePlayController.gameStatus = false;
        //tage currentStage = (Stage) gameMenuButton.getScene().getWindow();
        //currentStage.close();
        // Chiudi tutte le finestre aperte
        closeAllWindows();
        StageChangeController stageChanger = new StageChangeController();
        stageChanger.mainMenu(event);
        
    }

    // TODO impazzisce, da rincontrollare
    @FXML
    void replay(ActionEvent event) throws IOException {
    	
    	// chiudo tutte le finestre e la finestra del menù piccolina
        Stage menuScene = (Stage) replayGameButton.getScene().getWindow();
        menuScene.close();
        closeAllWindows();
        
        // per il riferimento al MainMenu e il MainMenuController
       /* FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource("/MainMenuView.fxml"));
        mainMenuLoader.load();
        MainMenuController mainMenuController = mainMenuLoader.getController();*/
        
        //AnchorPane mainMenu = mainMenuController.getMainMenu();

        // carico la scena del campo da gioco 
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/GameView.fxml"));
        AnchorPane game = gameLoader.load();
        GamePlayView gamePlayView = gameLoader.getController();
        GamePlayController gamePlayController = new GamePlayController();
        gamePlayController.initData(gamePlayView);

       
        // setto la scena da gioco
        Scene gameScene = new Scene(game);
        Stage newGameStage = new Stage();
        newGameStage.setScene(gameScene);
        newGameStage.show();

    }

    private void closeAllWindows() {
        // Chiudi tutte le finestre aperte, tranne quella del menu principale
        ObservableList<Window> windows = Window.getWindows();
        // Crea una nuova lista basata sulla lista originale
        List<Window> windowsCopy = new ArrayList<>(windows);

        // Rimuovi le finestre dalla nuova lista
        for (Window window : windowsCopy) {
            if (window instanceof Stage) {
                Stage stage = (Stage) window;

                if (!"MainMenu".equals(stage.getTitle())) {  //"MainMenu" è l'ID dentro l'AnchorPane el MainMenuView.fxml
                    stage.close();
                }
            }
        }
    }
    
    
}
