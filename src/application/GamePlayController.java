package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class GamePlayController {
	
	public static boolean gameStatus;
	public static int TEMPO_TRA_ONDATE = 2; // tempo tra ondate da definire meglio!!!!
	public static int NUM_STUD_ONDATA;
	public GamePlayModel gameModel;
	public GamePlayView gamePlayView;
	public List<Professor> profInGame; // lista dei professori in partita
	public List<GamePlayModel.Student> studInGame =new ArrayList<>(); // lista degli studenti in partita
	private AnchorPane mainMenu;

    public void initData(GamePlayView gamePlayView, AnchorPane mainMenu) {
    	NUM_STUD_ONDATA = 1;
    	gameStatus = true;
        gameModel = new GamePlayModel();
        profInGame = new ArrayList<>();
        studInGame = gameModel.getStudentList();
        this.gamePlayView = gamePlayView; // Assegna il riferimento dell'oggetto passato al metodo alla variabile gamePlayView
        this.mainMenu = mainMenu; // Salva il riferimento a MainMenu
        
        try {
			initGamePlay();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        if (!studInGame.isEmpty()) {
            startGame();
        }
    }

    public void initGamePlay() throws IOException {
    	
    	if(gameStatus) {
    		sleep(100);
			// genero la prima ondata di studenti
			NUM_STUD_ONDATA+=1;
		    gameModel.generateWave(NUM_STUD_ONDATA);
		    studInGame = gameModel.getStudentList();
			
		    //update view
		    synchronized(studInGame){
		        gamePlayView.updatePosition(studInGame);
		    }
		    
		    System.out.println("settato il campo da gioco");
		}
    }
   
   
    public void startGame(){
    	if(gameStatus) {
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
			// Avvio del thread per l'aggiornamento dell'interfaccia utente
		    new Thread(() -> {
				while (gameStatus) {
				    // Logica per studenti
			        
					sleep(2000);
			        
			        synchronized(studInGame){
			        	gamePlayView.removePosition(studInGame);
			        }
			        
				    Iterator<GamePlayModel.Student> studentIterator = gameModel.getStudentList().iterator();
				    while (studentIterator.hasNext()) {
				        GamePlayModel.Student student = studentIterator.next();
				        
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
				                try {
									userWin();
								} catch (IOException e) {
									e.printStackTrace();
								}
				                break;
				            }
				            
				            // Controllo se è arrivato nella cella del professore
				            if (student.getCol() == 0) {
				                // Utente ha vinto, aggiorna lo stato del gioco
				                gameStatus = false;
				                try {
									userWin();
								} catch (IOException e) {
									e.printStackTrace();
								}
				                break;
				            }
				        } else {
				            // Lo studente è morto
				        	//gameModel.handleStudentKilled(student);
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
				                try {
									userLost();
								} catch (IOException e) {
									e.printStackTrace();
								}
				                break;
				            }
				        } else {
				            // Il professore è morto
				        	//gameModel.handleProfKilled(prof);
				            profIterator.remove(); // Rimuovi il professore morto dalla lista
				        }
				    }
	
			        synchronized(studInGame){
			            gamePlayView.updatePosition(studInGame);
			        }
				    // Aggiornamento del tempo totale ??
				    // ...
	
				    
				    // Introdotto un ritardo per la visibilità del gioco
			        sleep(2000);
			        
				    try {
						initGamePlay();
					} catch (IOException e) {
						e.printStackTrace();
					}
				    
				    sleep(2000);
				}
			}).start();
		    
			
		}
    }
    public void userLost() throws IOException{
    	Platform.runLater(() -> {
            try {
		    	//carico il file fxml con la scritta hai perso
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LostGameView.fxml"));
		        Parent lostGame = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(lostGame));
		        MenuController controller = fxmlLoader.<MenuController>getController(); //controller uguale a quello del menu perchè ho gli stessi pulsanti
		        stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
    public void userWin() throws IOException{
    	Platform.runLater(() -> {
            try {
		    	//carico il file fxml con la scritta hai vinto
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WinGameView.fxml"));
		        Parent lostGame = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(lostGame));
		        MenuController controller = fxmlLoader.<MenuController>getController(); //controller uguale a quello del menu perchè ho gli stessi pulsanti
		        stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
	// ritardo per la visibilità del gioco    
	private void sleep(int num) {
		try {
	        Thread.sleep(num);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
}
