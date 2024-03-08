package _OOP_develop_gradle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MenuController {
	@FXML
	private Button resumeButton;

	@FXML
    private AnchorPane GameMainMenuRoot;
	
	@FXML
    private AnchorPane LostGame;
	@FXML
    private AnchorPane WonGame;
	
	@FXML
    private ImageView gameMenuButton;

    @FXML
    private ImageView exitGameButton;
    
    @FXML
    private ImageView replayGameButton;
    
    @FXML
    public void initData() {
    	GamePlayController.getInstance().setGameStatus(false); // Per mettere in pausa quando apro il menu
    }
    
    @FXML
    void exitGame(MouseEvent event) throws IOException {
    	System.exit(0);
    }
    
    @FXML
    void returnMainManu(MouseEvent event) throws IOException {
        //GamePlayController.gameStatus = false;
        Stage currentStage = (Stage) gameMenuButton.getScene().getWindow();
        currentStage.close();

        // Chiudi tutte le finestre aperte
        closeAllWindows();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
        Parent mainMenu = (Parent) fxmlLoader.load();
        Stage mainMenuStage = new Stage();
        mainMenuStage.setScene(new Scene(mainMenu));

        mainMenuStage.show();
        
    }

    @FXML
    void replayGame(MouseEvent event) throws IOException {
    	
    	// chiudo tutte le finestre e la finestra del menù piccolina
        Stage menuScene = (Stage) replayGameButton.getScene().getWindow();
        menuScene.close();
        closeAllWindows();
        
        // per il riferimento al MainMenu e il MainMenuController
        FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
        mainMenuLoader.load();
        MainMenuController mainMenuController = mainMenuLoader.getController();
        
        AnchorPane mainMenu = mainMenuController.getMainMenu();

        // carico la scena del campo da gioco 
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        AnchorPane game = gameLoader.load();
        GamePlayView gamePlayView = gameLoader.getController();
        GamePlayController gamePlayController = new GamePlayController();
        gamePlayController.initData(gamePlayView, mainMenu);

       
        // setto la scena da gioco
        Scene gameScene = new Scene(game);
        Stage newGameStage = new Stage();
        newGameStage.setScene(gameScene);
        newGameStage.show();

    }

    @FXML
    void resumeGame(ActionEvent event) {
        // Riprendi il gioco
    	GamePlayController gameController = GamePlayController.getInstance();
        gameController.setGameStatus(true);
        //GamePlayController.gameStatus = true; // Imposta lo stato del gioco su attivo

        //chiudo la finestra del menù
        Stage currentStage = (Stage) gameMenuButton.getScene().getWindow();
        currentStage.close();
        
        gameController.startGame(gameController.getGamePlayView());
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
