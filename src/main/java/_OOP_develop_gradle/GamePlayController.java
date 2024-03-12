package _OOP_develop_gradle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import _OOP_develop_gradle.model.Professor;
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
	
	private static GamePlayController instance;
	public boolean gameStatus;
	public static int TEMPO_TRA_ONDATE = 2; // tempo tra ondate da definire meglio!!!!
	public static int TEMPO_TOT_INI = 120; // sarebbe da mettere 120 che sono 2 minuti, per ora 10 sec per fare le prove
	public static int NUM_STUD_ONDATA;
	public static GamePlayModel gameModel;
	public GamePlayView gamePlayView;
	public List<Professor> profInGame; // lista dei professori in partita
	public List<GamePlayModel.Student> studInGame =new ArrayList<>(); // lista degli studenti in partita
	private AnchorPane mainMenu;

    public void initData(GamePlayView gamePlayView, AnchorPane mainMenu) {
    	NUM_STUD_ONDATA = 1;
    	gameStatus = true;
        gameModel = new GamePlayModel();
        gameModel.setTimeTot(TEMPO_TOT_INI);
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
        	gamePlayView.initialize();// avvio il tempo
            startGame(gamePlayView);
            
        }
    }

    public boolean isGameStatus() {
		return gameStatus;
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
		    
		    System.out.println("settato nuvo gruppo di studenti");
		}
    }
   
   /**
    * 
    * @param gamePlayView
    */
    public void startGame(GamePlayView gamePlayView){
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
					
					// controllo se è scaduto il tempo tot
					if (gameModel.getTimeTot()==0) {
				    	gameStatus = false;
		                try {
							userLost();
						} catch (IOException e) {
							e.printStackTrace();
						}
		                break;
				    }
					
					sleep(2000);
			        
			        synchronized(studInGame){
			        	gamePlayView.removePosition(studInGame);
			        }
			        
				    Iterator<GamePlayModel.Student> studentIterator = gameModel.getStudentList().iterator();
				    while (studentIterator.hasNext()) {
				        GamePlayModel.Student student = studentIterator.next();
				        
				        // Check dello studente se è vivo 
				        if (studInGame.contains(student)) { //health
				        	// guardo se è stato colpito 
				        	// se colpito aumento il tempo tot, se non ha più vita muore
				        	/*
				        	 * if(studente.colpito()){
				        	 * 		Student.takedamage(Professor.getDamage());
				        	 * 		gameModel.increaseTimeTot(NUM_AUMENTO_TEMPO); 
				        	 * 		if(studente.morto()){
				        	 * 				gestire morte chi implementa lo studente DESTROY
				        	 * 				studentIterator.remove();
				        	 * 		}
				        	 * }
				        	 */
				        	
				            // Avanzamento in riga (diminuzione colonna)
				        	// prof può essere messo ovunque sulla griglia --> gestire se ci sono entrambi
				            if (student.getCol() > 0) {
				                student.setCol(student.getCol() - 1);
				            } else {
				                // Lo studente è arrivato alla colonna 0
				            	// se nessun prof è presente in quella posizione ha perso
				            	// sennò si colpice il prof 
				                gameStatus = false;
				                gamePlayView.setTimerStop(true);
				                try {
									userWin();
								} catch (IOException e) {
									e.printStackTrace();
								}
				                break;
				            }
				            
				            // Controllo se è arrivato nella cella del professore
				            if (student.getCol() == 0) {
				            	 // Lo studente è arrivato alla colonna 0, utente ha perso
				            	 // se nessun prof è presente in quella posizione ha perso
				            	 // sennò si colpice il prof 
				                // Utente ha perso, aggiorna lo stato del gioco
				                gameStatus = false;
				                gamePlayView.setTimerStop(true);
				                try {
									userWin();
								} catch (IOException e) {
									e.printStackTrace();
								}
				                break;
				            }
				        } else {
				            // Lo studente è morto, gestito da chi fa lo studente
				        	//gameModel.handleStudentKilled(student);
				            studentIterator.remove(); // Rimuovi lo studente morto dalla lista
				        }
				        
				    }
				    
				    // Logica per professore
				   Iterator<Professor> profIterator = gameModel.getProfList().iterator();
				    while (profIterator.hasNext()) {
				        Professor prof = profIterator.next();
	
				        // Check se professor è in vita
				        if (prof.getHealthPoints() > 0) { // oppure profInGame.contains(prof) Professor.isAlive()
				            // "Sparo" ogni tot
				            // ...
				        	
				        	// se prof viene colpito deve diminuire la sua vita e il punteggio, controllo poi se è morto
				        	/*if(prof.colpito()){ 
				        	 * 		gameModel.decreaseTimeTot(NUM_DIMINUZIONE_TEMPO); 
				        	 * 		prof.decreaseVita(); --> receiveDamage(getDamage())
				        	 * 		
				        	 * 		if(prof.senzaVite()){
				        	 * 			rimozione prof da view, gestione morte
				        	 * 		}
				        	 * }
				        	 * 
				        	 * */
	
				            // Controllo se sono in vita ancora tutti i prof
				            if (gameModel.getProfList().isEmpty()) {
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
				            // Il professore è morto, gestito da chi fa i prof
				        	//gameModel.handleProfKilled(prof);
				            profIterator.remove(); // Rimuovi il professore morto dalla lista
				        }
				    }
	
			        synchronized(studInGame){
			            gamePlayView.updatePosition(studInGame);
			        }
				    
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
		        controller.initData();
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
		        controller.initData();
		        stage.show();
		        
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
	// ritardo per la visibilità del gioco    
	private void sleep(int num) {
		if(gameModel.getTimeTot()>0) {//controllo che il timer non sia a zero sennò mi faceva aspettare lo stesso
			try {
		        Thread.sleep(num);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		
		
	}
	
	// per restiruire l'istanta corrente del GamePlayController
	public static GamePlayController getInstance() {
        if (instance == null) {
            instance = new GamePlayController();
        }
        return instance;
    }
	
	public void setGameStatus(boolean status) {
        gameStatus = status;
    }
	
	public GamePlayView getGamePlayView() {
        return gamePlayView;
    }

	public static GamePlayModel getGameModel() {
		return gameModel;
	}

	public List<Professor> getProfInGame() {
		return profInGame;
	}

	public void setProfInGame(List<Professor> profInGame) {
		this.profInGame = profInGame;
	}

	public List<GamePlayModel.Student> getStudInGame() {
		return studInGame;
	}

	public void setStudInGame(List<GamePlayModel.Student> studInGame) {
		this.studInGame = studInGame;
	}
}
