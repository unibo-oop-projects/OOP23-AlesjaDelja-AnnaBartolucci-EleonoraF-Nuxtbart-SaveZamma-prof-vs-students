package application;
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
    private ImageView gameMenuButton;

    @FXML
    private ImageView exitGameButton;
    
    @FXML
    private ImageView replayGameButton;
    
    @FXML
    public void initData() {
    	
    }
    
    @FXML
    void exitGame(MouseEvent event) throws IOException {
    	System.exit(0);
    }
    
    @FXML
    void returnMainManu(MouseEvent event) throws IOException {
        GamePlayController.gameStatus = false;
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
        /*System.out.println("replayGame succedded");
        Stage stage = (Stage) replayGameButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        AnchorPane game=fxmlLoader.load();
        GamePlayView gamePlayView = fxmlLoader.<GamePlayView>getController();
        GamePlayController gamePlayController = new GamePlayController();
        gamePlayController.initData(gamePlayView);
        MainMenuController.MainMenu.getChildren().setAll(game);*/
    	
        // DA SISTEMARE!!
        GamePlayController.gameStatus = false;
        Stage stage = (Stage) replayGameButton.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        AnchorPane game = fxmlLoader.load();

        GamePlayView gamePlayView = fxmlLoader.<GamePlayView>getController();
        GamePlayController gamePlayController = new GamePlayController();

        // prendo il riferimento al MainMenu dalla scena corrente
        Scene scene = replayGameButton.getScene();
        AnchorPane MainMenu = (AnchorPane) scene.lookup("#MainMenu");

        gamePlayController.initData(gamePlayView, MainMenu);
        
        MainMenu.getChildren().setAll(game);
    }

    @FXML
    void resumeGame(ActionEvent event) {
        // Riprendi il gioco
        GamePlayController.gameStatus = true; // Imposta lo stato del gioco su attivo
        // Aggiungi qui altre operazioni necessarie per riprendere il gioco
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
