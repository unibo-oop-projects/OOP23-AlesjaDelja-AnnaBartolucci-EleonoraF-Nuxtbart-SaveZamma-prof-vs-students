package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class GamePlayController {
	
	public static boolean gameStatus;
	public static int TEMPO_TRA_ONDATE = 5; // tempo tra ondate da definire meglio!!!!
	public GamePlayModel gameModel;
	public GamePlayView gamePlayView;
	public List<Professor> profInGame; // lista dei professori in partita
	public List<GamePlayModel.Student> studInGame; // lista degli studenti in partita
	@FXML
    public AnchorPane GamePlayRoot;
	

	public void initialize() throws Exception {
		gamePlayView.setController(this);
		gameModel = new GamePlayModel();
		gameStatus =true;
		profInGame = new ArrayList();
	}
	
    @FXML
    public void initData() {
    	startGame();
    }

    public void startGame(){
    	try {
    		if(gameStatus) {
    			gameModel.getProfList().forEach(prof->{profInGame.add(prof);}); // in teoria da mettere nella Model ??
    			gameModel.getStudentList().forEach(student->{studInGame.add(student);}); // in teoria da mettere nella Model ??
    			
    			// genero la prima ondata di studenti
                gameModel.generateWave();
    			
    			//update view()?
    			
				// finchè stiamo giocando 
    			
    			// per ogni studente:
    			// controllo che sia in vita
    			// se è stato colpito aumento il punteggio del giocatore (se ha ancora punti vita continua sennò muore e si toglie dalla lista studenti)
    			// faccio avanzare man mano in riga
    			// controllo per vedere se è arrivato nella cella del prof ->se sì HA Perso-> status : false
    			
    			// per ogni professore:
    			// controllo che sia in vita
    			// se è stato attaccato dagli studenti diminuisco il punteggio (se ha ancora punti vita continua sennò muore e si toglie dalla lista professore)
    			// faccio "sparare" ogni tot
    			// controllo se sono in vita ancora tutti gli studenti, se no ->Utente ha perso-> status: false
    			
    			// devo sempre fare l'update della view()
    			
    			while (gameStatus) {
    			    // Logica per studenti
    			    Iterator<GamePlayModel.Student> studentIterator = gameModel.getStudentList().iterator();
    			    while (studentIterator.hasNext()) {
    			        GamePlayModel.Student student = studentIterator.next();
    			        
    			        // genero una nuova ondata
    	                if (gameModel.getTimeTot() % TEMPO_TRA_ONDATE == 0) {
    	                    gameModel.generateWave();
    	                }

    			        // Check dello studente se è vivo 
    			        if (studInGame.contains(student)) {
    			        	// guardo se è stato colpito
    			        	// ... ??
    			        	
    			            // Avanzamento in riga (diminuzione colonna)
    			            if (student.getCol() > 0) {
    			                student.setCol(student.getCol() - 1);
    			            } else {
    			                // Lo studente è arrivato alla colonna 0, utente ha vinto
    			                gameStatus = false;
    			                userWin();
    			                break;
    			            }

    			            // Controllo se è arrivato nella cella del professore
    			            if (student.getCol() == 0) {
    			                // Utente ha vinto, aggiorna lo stato del gioco
    			                gameStatus = false;
    			                userWin();
    			                break;
    			            }
    			        } else {
    			            // Lo studente è morto
    			        	gameModel.handleStudentKilled(student);
    			            studentIterator.remove(); // Rimuovi lo studente morto dalla lista
    			        }
    			    }

    			    // Logica per professore
    			    Iterator<Professor> profIterator = gameModel.getProfList().iterator();
    			    while (profIterator.hasNext()) {
    			        Professor prof = profIterator.next();

    			        // Check se professor è in vita
    			        if (prof.getHealthPoints() > 0) { // oppure profInGame.contains(prof)
    			            // "Sparo" ogni tot
    			            // ...

    			            // Controllo se sono in vita ancora tutti gli studenti
    			            if (gameModel.getStudentList().isEmpty()) {
    			                // Utente ha perso, aggiorna lo stato del gioco
    			                gameStatus = false;
    			                userLost();
    			                break;
    			            }
    			        } else {
    			            // Il professore è morto
    			        	gameModel.handleProfKilled(prof);
    			            profIterator.remove(); // Rimuovi il professore morto dalla lista
    			        }
    			    }

    			    // Aggiornamento della view
    			    // ...

    			    // Aggiornamento del tempo totale ??
    			    // ...

    			    // Introdotto un ritardo per la visibilità del gioco
    			    try {
    			        Thread.sleep(0,001);
    			    } catch (InterruptedException e) {
    			        e.printStackTrace();
    			    }
    			}
    			
    			//handleStudentKilled(student); // chiamato quando uno studente viene ucciso
                //handleProfKilled(prof); // chiamato quando un professore viene ucciso
    			
    		}else {
    			
    		}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	 @FXML
	    private void handleMouseClick(MouseEvent event) {
		 	//con questa funzione dovremmo piantare i professori?
	        int columnIndex = GridPane.getColumnIndex((Region) event.getSource());
	        int rowIndex = GridPane.getRowIndex((Region) event.getSource());

	        System.out.println("Clicked at column " + columnIndex + " and row " + rowIndex);
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

	    public void userLost() throws IOException{
	    	//carico il file fxml con la scritta hai perso
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LostGameView.fxml"));
	        Parent lostGame = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(lostGame));
	        MenuController controller = fxmlLoader.<MenuController>getController(); //controller uguale a quello del menu perchè ho gli stessi pulsanti
	        //controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
	        stage.show();
	    }
	    
	    public void userWin() throws IOException{
	    	//carico il file fxml con la scritta hai vinto
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WinGameView.fxml"));
	        Parent lostGame = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(lostGame));
	        MenuController controller = fxmlLoader.<MenuController>getController(); //controller uguale a quello del menu perchè ho gli stessi pulsanti
	        //controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
	        stage.show();
	    }
	    
	    
}
