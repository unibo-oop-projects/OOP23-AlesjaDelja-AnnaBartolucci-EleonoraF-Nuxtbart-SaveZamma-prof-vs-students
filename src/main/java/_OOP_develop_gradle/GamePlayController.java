package _OOP_develop_gradle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Student;
import _OOP_develop_gradle.Bullet;
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
	public static int TUTOR_ID = 1;
	public static int NORMALPROF_ID = 2;
	public static int SCORE_INIT = 20;
	public static int TEMPO_TRA_ONDATE = 2; // tempo tra ondate da definire meglio!!!!
	public static int TEMPO_TOT_INIT = 120; // sarebbe da mettere 120 che sono 2 minuti, per ora 10 sec per fare le prove
	public static int NUM_STUD_ONDATA;
	public static GamePlayModel gameModel;
	public GamePlayView gamePlayView;
	public List<Bullet> bulletNormalList = new ArrayList<>(); // lista dei bullet normali in gioco
	public List<Bullet> bulletDiagonalList = new ArrayList<>(); // lista dei bullet diagonali in gioco
	public List<Professor> profInGame = new ArrayList<>(); // lista dei professori in partita
	public List<Student> studInGame = new ArrayList<>(); // lista degli studenti in partita
	private AnchorPane mainMenu;

    public void initData(GamePlayView gamePlayView, AnchorPane mainMenu) {
    	NUM_STUD_ONDATA = 1;
    	gameStatus = true;
        gameModel = new GamePlayModel();
        gameModel.setTimeTot(TEMPO_TOT_INIT);
        gameModel.setMatchScore(SCORE_INIT);
        bulletNormalList = gameModel.getBulletListNormal();
        bulletDiagonalList = gameModel.getBulletListDiagonal();
        profInGame = gameModel.getProfList();
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

	public void initGamePlay() throws IOException {
    	
    	if(gameStatus) {
    		sleep(100);
			// genero la prima ondata di studenti
			NUM_STUD_ONDATA+=1;
		    gameModel.generateWave(NUM_STUD_ONDATA);
		    studInGame = gameModel.getStudentList();
		    profInGame = gameModel.getProfList();
		    bulletNormalList = gameModel.getBulletListNormal();
	        bulletDiagonalList = gameModel.getBulletListDiagonal();
		    
		    //update view
		    /*synchronized(studInGame){
		    	// TODO sync con tutti gli altri ??
		        gamePlayView.updatePositions(studInGame, profInGame, bulletNormalList, bulletDiagonalList);
		    }*/
		    // Sincronizza l'accesso alle liste condivise
            synchronizeLists(() -> {
                gamePlayView.updatePositions(studInGame, profInGame, bulletNormalList, bulletDiagonalList);
            });
            
		    System.out.println("settato nuvo gruppo di studenti");
		}
    }
   
   /**
    * 
    * @param gamePlayView
    */
    public void startGame(GamePlayView gamePlayView){
    	if(gameStatus) {
			
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
			        
					// Sincronizza l'accesso alle liste condivise
	                synchronizeLists(() -> {
	                	advanceBullets(); // così dovrebbero andare più veloci
	                    gamePlayView.updatePositions(studInGame, profInGame, bulletNormalList, bulletDiagonalList);
	                });
					
				    Iterator<Student> studentIterator = gameModel.getStudentList().iterator();
				    while (studentIterator.hasNext()) {
				        Student student = studentIterator.next();
				        
				        // Check dello studente se è vivo 
				        if (student.getHealthStudent() > 0) { // studInGame.contains(student)
				        	// guardo se è stato colpito dal bullet
				        	// se colpito aumento il punteggio tot, se non ha più vita muore
				        	
				        	if (collisionBulletAndStudent(student, bulletNormalList) || collisionBulletAndStudent(student, bulletDiagonalList)) {
				        		if (student.getHealthStudent() <= 0) {
				        			gameModel.setMatchScore(student.destroyStudents(gameModel.getMatchScore()));
				        			studentIterator.remove();
				        		}
				        	}
				        	
				        	// prof può essere messo ovunque sulla griglia --> gestire se ci sono entrambi
				        	//controllo se prof è presente nella cella dove sono
				        	//se sì faccio collision e colpisco il prof
				        	//sennò avanzo 
				        	if (collisionProfAndStudent(student, profInGame)) {
				        		//chiamo la view per infliggere attacco dello studente
				        		// TODO metodo dell'ale
				        	}else {
				        		// Avanzamento in riga (diminuzione colonna)
					            if (student.getPositionStudent().getY() > 0) {
					            	student.setPositionStudent(new Elements<Integer, Integer> (student.getPositionStudent().getX(),student.getPositionStudent().getY() - 1));
					            }
				        	}
				            
				            
				            // Controllo se è arrivato nella cella finale
				            if (student.getPositionStudent().getY() == 0) {
				            	 // se nessun prof è presente in quella posizione ha perso
				            	 // sennò si colpice il prof 
				            	if (collisionProfAndStudent(student, profInGame)) {
				            		// TODO metodo dell'ale
				            		break;
				            	}
				                // Utente ha perso, aggiorna lo stato del gioco
				                gameStatus = false;
				                gamePlayView.setTimerStop(true);
				                try {
									userLost();
								} catch (IOException e) {
									e.printStackTrace();
								}
				                break;
				            }
				        } else {
				            
				        	gameModel.setMatchScore(student.destroyStudents(gameModel.getMatchScore())); // Lo studente è morto
				            studentIterator.remove(); // Rimuovi lo studente morto dalla lista
				        }
				        
				    }
				    
				    advanceBullets();
				    
				    // Logica per professore
				   Iterator<Professor> profIterator = gameModel.getProfList().iterator();
				    while (profIterator.hasNext()) {
				        Professor prof = profIterator.next();
	
				        // Check se professor è in vita
				        if (profInGame.contains(prof)) {
				        	
				        	// il prof che viene colpito lo faccio già nel ciclo degli studenti
		        	  		if(prof.getHealthPointsProf() <= 0){
				                gameModel.setMatchScore(gameModel.getMatchScore() - prof.getcostProfessor());
		        	  			prof.destroyProf();
		        	  			profIterator.remove();
		        	  		}else {
		        	  			// se è in vita ed è tempo di sparare: creo nuovo bullet e sparo
		        	  			// TODO decidere ogni quanto far sparare --> per ora ogni 7 sec
		        	  			if(gameModel.getTimeTot() % 7 == 0) {
		        	  				if(prof.getIDProf() == TUTOR_ID || prof.getIDProf() == NORMALPROF_ID) {
		        	  					//generi un bullet normale e lo aggiungi alla lista
		        	  					// TODO ELE deve aggiungere getter e setter nei prof tipo tutor della speed e del bulletName 
		        	  					bulletNormalList.add(new Bullet(1, prof.getDamageProf(), prof.getPositionProf(), "bulletName"));
		        	  					gameModel.setBulletListNormal(bulletNormalList);
		        	  				}else {
		        	  					// generi un bullet diagonal e lo aggiungi alla sua lista
		        	  					bulletDiagonalList.add(new Bullet(1, prof.getDamageProf(), prof.getPositionProf(), "bulletName"));
		        	  					gameModel.setBulletListDiagonal(bulletDiagonalList);
		        	  				}
		        	  			}
		        	  		}
	
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
				            
				        	prof.destroyProf();    // Il professore è morto
				            profIterator.remove(); // Rimuovi il professore morto dalla lista
				        }
				    }
	
				    // Sincronizza l'accesso alle liste condivise
	                synchronizeLists(() -> {
	                    gamePlayView.updatePositions(studInGame, profInGame, bulletNormalList, bulletDiagonalList);
	                });
				    
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
    
    /**
     * Executes an action within a synchronized section, ensuring safe access to the 
     * shared lists {@code studInGame}, {@code profInGame}, {@code bulletNormalList}, 
     * and {@code bulletDiagonalList}.
     *
     * @param action the action to be performed within the synchronized section
     */
    private void synchronizeLists(Runnable action) {
        synchronized (studInGame) {
            synchronized (profInGame) {
                synchronized (bulletNormalList) {
                    synchronized (bulletDiagonalList) {
                        action.run();
                    }
                }
            }
        }
    }
    
    private void advanceBullets() {
    	// Faccio avanzare i bullet
	    Iterator<Bullet> bulletNormalIterator = gameModel.getBulletListNormal().iterator();
	    while (bulletNormalIterator.hasNext()){
	    	bulletNormalIterator.next().move();
	    }
	    Iterator<Bullet> bulletDiagonalIterator = gameModel.getBulletListDiagonal().iterator();
	    while (bulletDiagonalIterator.hasNext()){
	    	bulletDiagonalIterator.next().move();
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
	
	public boolean isGameStatus() {
		return gameStatus;
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

	public List<Student> getStudInGame() {
		return studInGame;
	}

	public void setStudInGame(List<Student> studInGame) {
		this.studInGame = studInGame;
	}
	
	public boolean collisionBulletAndStudent(Student currentStud, List<Bullet> bulletList) {
		//passo uno studente e controllo che in quella cella non ci sia un bullet se c'è setto a true e sparisce il bullet(destroy)
		/* Questo modo qui sotto prende solo il primo proiettile che trova nella posizione dello studente, quella dop invece prende TUTTI i proiettili nella posizione dello studente
		 * return bulletList.stream()
				.filter(bullet -> bullet.getPosition().equals(currentStud.getPosition()))
				.peek(bullet -> {
	                currentStud.takeDamageStudents(bullet.getBulletDamage());
	            })
				.peek(Bullet::destroyBullet)
				.findFirst()
				.isPresent();*/
		return bulletList.stream()
	            .filter(bullet -> bullet.getPosition().equals(currentStud.getPositionStudent()))
	            .peek(bullet -> {
	                currentStud.takeDamageStudents(bullet.getBulletDamage());
	                bullet.destroyBullet();
	            })
	            .count() > 0;
	}
	
	 
	public boolean collisionProfAndStudent(Student currentStud, List<Professor> profList) {
		 return profList.stream()
		            .filter(prof -> prof.getPositionProf().equals(currentStud.getPositionStudent()))
		            .map(prof -> {
		                prof.receiveDamageProf(currentStud.getDamageStudent());
		                return prof;})
		            .findFirst()
		            .isPresent();
	}
	
}
