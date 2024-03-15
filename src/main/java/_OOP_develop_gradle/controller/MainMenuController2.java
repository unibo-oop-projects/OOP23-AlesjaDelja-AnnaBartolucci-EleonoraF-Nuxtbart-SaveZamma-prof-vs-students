package _OOP_develop_gradle.controller;

import _OOP_develop_gradle.view.GamePlayView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainMenuController2 {
	@FXML
    private AnchorPane MainMenu;
	
	@FXML
    private ImageView start;
	
	public AnchorPane getMainMenu() {
        return MainMenu;
    }
	
	@FXML
    void start(MouseEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GameView.fxml"));
        AnchorPane pane=fxmlLoader.load();
        System.out.println("start Game succedded");
        GamePlayView gamePlayView = fxmlLoader.<GamePlayView>getController();
        
        GamePlayController gamePlayController = new GamePlayController();
        gamePlayController.initData(gamePlayView); // Inizializza il GamePlayController con il GamePlayView
        MainMenu.getChildren().setAll(pane);
    }
	
}