package application;

import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

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
    public GamePlayModel gamePlayModel;
    public List<Professor> profInGrid;

    public void setController(GamePlayController gameController) {
        this.gameController = gameController;
    }

    public void initialize() {
        // Inizializza la griglia di gioco, impostando le immagini iniziali, ecc.
    	ProfChoose.getProfTypes(gamePlayRoot);
    	profInGrid = new ArrayList();
    }
    
    public void update(GamePlayModel model) {
        // aggiornamento della vista in base allo stato del modello
        // ...
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        // Gestisci l'evento di clic sulla griglia
        // Ottenere le coordinate della griglia dalla sorgente dell'evento e agire di conseguenza
    	// cioè se clicco su una tipologia di professore poi clicco sulla cella in cui lo voglio mettere e compare lì
    	
	 	//con questa funzione dovremmo piantare i professori?
        Integer columnIndex = GridPane.getRowIndex((Region) event.getSource());
        Integer rowIndex = GridPane.getRowIndex((Region) event.getSource());

        System.out.println("Clicked at column " + columnIndex + " and row " + rowIndex);
        
        // se ho selezionato un elemento nella barra laterale 
        // 		se la cella cliccata dopo è nella griglia ed è vuota (cioè NON c'è già un altro professore)
        //			controllo di avere abbastanza tempo/moneta per quel prof selezionato
        //				se SI: pianto il prof nella cella selezionata e lo aggiungo alla lista dei profInGrid
        //				se NO: nulla, esco dagli if annidati
	    if(ProfChoose.getIDProfChoosen()!=-1) {
	    	if(columnIndex!=null && rowIndex!=null && !isProfInGrid(columnIndex, rowIndex)) {
	    		/*if(ProfChoose.getProf(ProfChoose.getIDProfChoosen())).getTimeCost<=TimeTot) {
	    		    creo nuovo prof con columnIndex e rowIndex --> Professor p = gamePlayModel.generateNewProf(columnIndex, rowIndex);
	    			piazzo il professore nella griglia --> ?
	    			aggiungo il prof in lista --> profInGrid.add(p);
	    			diminuisco il tempo totale o la moneta --> gamePlayModel.decreaseTimeTot(p.TimeCost);
	    		}*/
	    	}
	    }
    }
    
    @FXML
    void GameMenu(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
        Parent gameMenu = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(gameMenu));
        MenuController controller = fxmlLoader.<MenuController>getController();
        //controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
        stage.show();
    }

	private boolean isProfInGrid(int columnIndex, int rowIndex) {
		// controllo se c'è un professore in quella cella della griglia
		// se c'è restituisco TRUE se non c'è restituisco FALSE
		return profInGrid.stream().anyMatch(p -> p.getxPos() == columnIndex && p.getyPos() == rowIndex);
	}

    
}
