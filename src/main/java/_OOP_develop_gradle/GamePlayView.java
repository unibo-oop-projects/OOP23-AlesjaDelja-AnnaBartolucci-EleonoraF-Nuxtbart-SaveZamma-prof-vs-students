package _OOP_develop_gradle;

import java.util.List;

import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Student;
import _OOP_develop_gradle.view.StudentView;

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
    private Label matchScoreLabel;
    
    @FXML
    private Label energyLabel;
    
    @FXML
    private ImageView gameMenuButton;
    
    @FXML
    private GridPane lawn_grid;
    
    @FXML
    private Label timeLabel;

    public GamePlayController gameController;
    public GamePlayModel gamePlayModel;
    public List<Professor> profInGrid = new ArrayList<>();
    private List<Student> studentInGrid = new ArrayList<>(); // Lista di studenti presenti
    private List<StudentView> studentViewList = new ArrayList<>();
    private List<Bullet>  bulletInGrid = new ArrayList<>(); 
    public AnimationTimer  timer;
    public int timeTot ;// Partiamo da 2 minuti, quindi 120 secondi
    public int matchScore ;
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
                    		updateMatchScoreLabel(); // TODO update del match con anche il tempo ?
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
	
	public void updateMatchScoreLabel() {
		matchScoreLabel.setText(String.format("%d", gamePlayModel.getMatchScore()));
	}
    
	public void updatePositions(List<Student> studentList, List<Professor> profList, List<Bullet> bulletListNormal, List<Bullet> bulletList){
		Platform.runLater(() -> {
			
			removePosition(studentViewList, profList, bulletList, bulletListNormal);
	        updateStudentPositions(studentList);
	        updateProfessorPositions(profList);
	        updateBulletPositions(bulletList);
	        updateBulletPositions(bulletListNormal);
	    });
    }
	
	private void removeImageViews() {
	    lawn_grid.getChildren().removeIf(node -> node instanceof ImageView);
	}
	
	private void updateStudentPositions(List<Student> studentList) {
		// per ogni studente in studentInGrid
    	//	prendo le coordinate e metto sulla griglia la foto corrispondente
		studentInGrid =studentList;
    	for(Student stud : studentInGrid) {
    		StudentView studView = new StudentView(lawn_grid);
    		studentViewList.add(studView);
    		studView.displayStudent(stud.getPositionStudent());
    		/*ImageView studentImg = stud.getImageStud(stud);
    		GridPane.setConstraints(studentImg, stud.getPositionStudent().getX(), stud.getPositionStudent().getY());
    		lawn_grid.getChildren().add(studentImg);*/
    	}
	}
	
	public void updateProfessorPositions(List<Professor> profList){
	    	// per ogni prof
	    	// prendo le coordinate e metto sulla griglia la foto corrispondente
	    	profInGrid = profList;
	    	for(Professor prof : profInGrid) {
	    		ImageView profImg = prof.getImageProf(prof);
	    		GridPane.setConstraints(profImg, prof.getPositionProf().getX(), prof.getPositionProf().getY());
	    		lawn_grid.getChildren().add(profImg);
	    	}
	}
	
	public void updateBulletPositions(List<Bullet> bulletList){
	    	// per ogni bullet
	    	// prendo le coordinate e metto sulla griglia la foto corrispondente
	    	bulletInGrid = bulletList;
	    	for(Bullet bullet : bulletInGrid) {
	    		ImageView bulletImg = bullet.getImageBullet(bullet);
	    		GridPane.setConstraints(bulletImg, bullet.getPosition().getX(), bullet.getPosition().getY());
	    		lawn_grid.getChildren().add(bulletImg);
	    	}
    }

	
	public void removePosition(List<StudentView> students, List<Professor> profList, List<Bullet> bulletList, List<Bullet> bulletList2) {
	    Platform.runLater(() -> {
	        removeImageViews();
	        removeStudents(students);
	        removeProfessors(profList);
	        removeBullets(bulletList);
	        removeBullets(bulletList2);
	    });
	}

	private void removeStudents(List<StudentView> students) {
		//studentInGrid = studentList;
	    for (StudentView stud : students) {
	    	stud.removeStudent();
	    	//lawn_grid.getChildren().remove(stud.getImageStud(stud));
	    }
	}

	private void removeProfessors(List<Professor> profList) {
		profInGrid = profList;
	    for (Professor prof : profList) {
	        lawn_grid.getChildren().remove(prof.getImageProf(prof));
	    }
	}

	private void removeBullets(List<Bullet> bulletList) {
		bulletInGrid = bulletList;
	    for (Bullet bullet : bulletList) {
	        lawn_grid.getChildren().remove(bullet.getImageBullet());
	    }
	}
    
    /**
     * Function that handle the choice of a professor type and put it on the lawn grid
     * @param event
     */
    @FXML
    private void handleMouseClick(MouseEvent event) {
        // Gestisci l'evento di clic sulla griglia
    	// cioè se clicco su una tipologia di professore poi clicco sulla cella in cui lo voglio mettere e compare lì
    	
        Integer columnIndex = GridPane.getRowIndex((Region) event.getSource());
        Integer rowIndex = GridPane.getRowIndex((Region) event.getSource());

        System.out.println("Clicked at column " + columnIndex + " and row " + rowIndex);
        int costProfessor = 0;
        // se ho selezionato un elemento nella barra laterale 
        // 		se la cella cliccata dopo è nella griglia ed è vuota la cella selezionata (cioè NON c'è già un altro professore)
        //			controllo di avere abbastanza tempo/moneta per quel prof selezionato
        //				se SI: pianto il prof nella cella selezionata e lo aggiungo alla lista dei profInGrid
        //				se NO: nulla, esco dagli if annidati
        
        
        
        
	    if(Professor.getIDProf()!=-1) {
	    	if(columnIndex!=null && rowIndex!=null && !isProfInCell(columnIndex, rowIndex)) {
	    		switch(Professor.getIDProf()) {
	    			case 0:
	    				costProfessor = new Tutor(columnIndex, rowIndex).getcostProfessor();
	    				Tutor tutornew = new Tutor(columnIndex, rowIndex);
	    				Bullet tutorBullet = tutornew.tutorBullet;
	    				if(costProfessor <= gamePlayModel.getMatchScore()) {
	    	    		    // creo nuovo prof con columnIndex e rowIndex
	    	    		    Professor p = gamePlayModel.generateNewProf(columnIndex, rowIndex, null, null, costProfessor);
	    	    		    // aggiungo il prof in lista --> profInGrid.add(p); --> NO lo fa già la generateNewProf()
	    	    			// piazzo il professore nella griglia --> con la call 
	    	    			updatePosition(studList, profList);
	    	    			// diminuisco la moneta tot 
	    	    			gamePlayModel.decreaseMatchScore(p.getcostProfessor());
	    	    		}
	    				break;
	    			case 1:
	    				costProfessor = new NormalProfessor(columnIndex, rowIndex).getcostProfessor();
	    				break;
	    			case 2:
	    				costProfessor = new Rector(columnIndex, rowIndex).getcostProfessor();
	    				break;
	    			default:
	    		        System.out.println("Il numero non è né 1, né 2, né 3");
	    		        break;
	    		 }
	    		/*if(costProfessor <= gamePlayModel.getMatchScore()) {
	    		    // creo nuovo prof con columnIndex e rowIndex
	    		    Professor p = gamePlayModel.generateNewProf(columnIndex, rowIndex, null, null, costProfessor);
	    		    // aggiungo il prof in lista --> profInGrid.add(p); --> NO lo fa già la generateNewProf()
	    			// piazzo il professore nella griglia --> con la call 
	    			updatePosition(studList, profList);
	    			// diminuisco la moneta tot 
	    			gamePlayModel.decreaseMatchScore(p.getcostProfessor());
	    		}*/
	    		
	    	}
	    }
    }
    
    /**
     * Function that opens the Game Menu 
     * @param event
     * @throws IOException
     */
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
        
        stage.show();
    }

    @FXML
    public int handleTutorCardClick(){
    	return 1;
    }
    
    @FXML
    public int handleNormalCardClick(){
    	return 1;
    }
    
    @FXML
    public int handleRectorCardClick(){
    	return 1;
    }
    /**
     * Check if the professor is in the cell with columnIndex and rowIndex
     * @param columnIndex
     * @param rowIndex
     * @return TRUE if prof is in the cell otherwise FALSE
     */
	private boolean isProfInCell(int columnIndex, int rowIndex) {
		return profInGrid.stream().anyMatch(p -> p.getPositionProf().getX() == columnIndex && p.getPositionProf().getY() == rowIndex);
	}

    
}
