package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GamePlayView {
	// per gestire la griglia di gioco, popolarla con le immagini degli studenti, professori, ecc.,
	// e di rispondere agli eventi di clic sulla griglia --> per rispettare meglio il pattern MVC
	
	@FXML
    private AnchorPane gamePlayRoot;
    
    @FXML
    private ImageView lawnImage;
    
    @FXML
    private ImageView sunCountImage;
    
    @FXML
    private Label sunCountLabel;
    
    @FXML
    private ImageView gameMenuButton;
    
    @FXML
    private GridPane lawnGrid;

    public GamePlayController gameController;
    

    public void setController(GamePlayController gameController) {
        this.gameController = gameController;
    }

    public void initialize() {
        // Inizializza la griglia di gioco, impostando le immagini iniziali, ecc.
    }
    
    public void update(GamePlayModel model) {
        // aggiornamento della vista in base allo stato del modello
        // ...
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        // Gestisci l'evento di clic sulla griglia
        // Ottenere le coordinate della griglia dalla sorgente dell'evento e agire di conseguenza
        // ...
    }

    // ... 
}
