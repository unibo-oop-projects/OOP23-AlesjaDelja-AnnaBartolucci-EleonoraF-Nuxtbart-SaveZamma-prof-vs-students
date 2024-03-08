package _OOP_develop_gradle;

import java.util.List;

import _OOP_develop_gradle.GamePlayModel.Student;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;

import javafx.application.Platform;
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
    private AnchorPane GamePlayRoot;
    
    @FXML
    private ImageView lawnImage;
    
    @FXML
    private ImageView sunCountImage;
    
    @FXML
    private Label sunCountLabel;
    
    @FXML
    private ImageView gameMenuButton;
    
    @FXML
    private GridPane lawn_grid;
    
    @FXML
    private Label timeLabel;

    public GamePlayController gameController;
    public GamePlayModel gamePlayModel;
    public List<Professor> profInGrid;
    private List<GamePlayModel.Student> studentInGrid=new ArrayList<>(); // Lista di studenti presenti
    public AnimationTimer  timer;
    public int timeTot ;// Partiamo da 2 minuti, quindi 120 secondi
    public long lastTimeUpdate = 0;
    public long ONE_SECOND = 1_000_000_000;
    public boolean timerStop = false;
    
    public void setController(GamePlayController gameController) {
        this.gameController = gameController;
    }
    @FXML
    public void initialize() {
        // Inizializza la griglia di gioco, impostando le immagini iniziali, ecc.
    	//lawn_grid.setVisible(true);
    	//ProfChoose.getProfTypes(gamePlayRoot);
    	/*gamePlayModel = new GamePlayModel();
    	profInGrid = gamePlayModel.getProfList();
    	studentInGrid = gamePlayModel.getStudentList();
    	
    	gameController = new GamePlayController();
    	gameController.initData(this);*/
    	gamePlayModel = GamePlayController.getGameModel();
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (!timerStop) {
                    if (now - lastTimeUpdate >= ONE_SECOND) { // check se è passato un secondo
                    	timeTot = gamePlayModel.getTimeTot();
                    	if (timeTot > 0) {
                    		updateTempoLabel();
                            lastTimeUpdate = now;
                    	}else {
                        	timer.stop();
                    	}
                    }
            	}else{
            		timer.stop();
            	}
           }
        };
        timer.start();
    }
    
    public boolean isTimerStop() {
		return timerStop;
	}
	public void setTimerStop(boolean timerStop) {
		this.timerStop = timerStop;
	}
	private void updateTempoLabel() {
    	// funzione che mi aggiorna il tempo che scorre
    	timeTot--;
        int min = timeTot / 60;
        int sec = timeTot % 60;
        
        timeLabel.setText(String.format("%02d:%02d", min, sec));
        gamePlayModel.setTimeTot(timeTot);
        
	}
    
	public void updatePosition(List<GamePlayModel.Student> studentList){//GamePlayModel model) {
    	Platform.runLater(() -> {
    	// aggiornamento della vista in base allo stato del modello
    	// ...
    	lawn_grid.getChildren().removeIf(node -> node instanceof ImageView);
    	// per ogni studente in studentInGrid
    	//	prendo le coordinate e metto sulla griglia la foto corrispondente
    	studentInGrid =studentList;// model.getStudentList();
    	for(Student stud : studentInGrid) {
    		ImageView studentImg = stud.getImageStud(stud);
    		GridPane.setConstraints(studentImg, stud.getCol(), stud.getRow());
    		lawn_grid.getChildren().add(studentImg);
    	}
    	
    	// per ogni prof 
    	// ...
    	});
    }

    public void removePosition(List<GamePlayModel.Student> studentList) {
    	Platform.runLater(() -> {
        // aggiornamento della vista in base allo stato del modello
        // ...
    	lawn_grid.getChildren().removeIf(node -> node instanceof ImageView);
    	// per ogni studente in studentInGrid
    	//	prendo le coordinate e tolgo dalla griglia la foto corrispondente
    	studentInGrid = studentList;//model.getStudentList();
    	for(Student stud : studentInGrid) {
    		lawn_grid.getChildren().remove(stud.getImageStud(stud));
    	}
    	
    	// per ogni prof 
    	// ...
    	});
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
	    		    aggiungo il prof in lista --> profInGrid.add(p); --> NO lo fa già la generateNewProf()
	    			piazzo il professore nella griglia --> con la call ad updatePosition(gamePlayModel) che mi mette a video le immagini
	    			diminuisco il tempo totale o la moneta --> gamePlayModel.decreaseTimeTot(p.TimeCost);
	    		}*/
	    	}
	    }
    }
    
    @FXML
    void GameMenu(MouseEvent event) throws IOException {
    	timerStop = true;// stoppo il timer quando apro il menù
    	GamePlayController.getInstance().setGameStatus(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
        Parent gameMenu = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(gameMenu));
        MenuController controller = fxmlLoader.<MenuController>getController();
        controller.initData();
        //controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
        stage.show();
    }

	private boolean isProfInGrid(int columnIndex, int rowIndex) {
		// controllo se c'è un professore in quella cella della griglia
		// se c'è restituisco TRUE se non c'è restituisco FALSE
		return profInGrid.stream().anyMatch(p -> p.getxPos() == columnIndex && p.getyPos() == rowIndex);
	}

    
}
