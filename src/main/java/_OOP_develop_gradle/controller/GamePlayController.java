package _OOP_develop_gradle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import _OOP_develop_gradle.model.Bullet;
import _OOP_develop_gradle.model.Elements;
import _OOP_develop_gradle.model.GamePlayModel;
import _OOP_develop_gradle.model.NormalProfessor;
import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Rector;
import _OOP_develop_gradle.model.Score;
import _OOP_develop_gradle.model.Student;
import _OOP_develop_gradle.model.Tutor;
import _OOP_develop_gradle.view.BulletView;
import _OOP_develop_gradle.view.ElementView;
import _OOP_develop_gradle.view.GamePlayView;
import _OOP_develop_gradle.view.NormalProfView;
import _OOP_develop_gradle.view.RectorView;
import _OOP_develop_gradle.view.StudentView;
import _OOP_develop_gradle.view.TutorView;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GamePlayController {
	
	private static GamePlayController instance;
	public boolean gameStatus;
	
	public static int ENERGY_INIT = 20;
	public static int TEMPO_TRA_ONDATE = 2; // tempo tra ondate da definire meglio!!!!
	public static int TEMPO_TOT_INIT = 120; // sarebbe da mettere 120 che sono 2 minuti, per ora 10 sec per fare le prove
	public static int NUM_STUD_ONDATA;
	public static GamePlayModel gameModel;
	public GamePlayView gamePlayView;
	public Score scoreMatch;
	public boolean firstProfPicked;
	public List<Bullet> bulletNormalList = new ArrayList<>(); // lista dei bullet normali in gioco
	public List<Bullet> bulletDiagonalList = new ArrayList<>(); // lista dei bullet diagonali in gioco
	
	public List<Tutor> tutorInGame = new ArrayList<>(); 
	public List<NormalProfessor> normalPInGame = new ArrayList<>(); 
	public List<Rector> rectorInGame = new ArrayList<>(); 
	public List<Student> studInGame = new ArrayList<>(); // lista degli studenti in partita
	private List<List<? extends Professor>> allProfessors = new ArrayList<>();
	
	public void addAllLists(List<Tutor> tutorInGame, List<NormalProfessor> normalPInGame, List<Rector> rectorInGame) {
		allProfessors.clear();
	    allProfessors.add(tutorInGame);
    	allProfessors.add(tutorInGame);
        allProfessors.add(normalPInGame);
        allProfessors.add(rectorInGame);
    }
	
	public void initData(GamePlayView gamePlayView) {
    	NUM_STUD_ONDATA = 1;
    	scoreMatch = new Score();
    	scoreMatch.resetScore();
    	gameStatus = true;
    	
        gameModel = new GamePlayModel();
        gameModel.setTimeTot(TEMPO_TOT_INIT);
        gameModel.setEnergy(ENERGY_INIT);
        bulletNormalList = gameModel.getBulletListNormal();
        bulletDiagonalList = gameModel.getBulletListDiagonal();
        tutorInGame = gameModel.getTutorList();
        normalPInGame = gameModel.getNormalProfList();
        rectorInGame = gameModel.getRectorList();
        studInGame = gameModel.getStudentList();
        
        addAllLists(tutorInGame, normalPInGame, rectorInGame);
        
        this.gamePlayView = gamePlayView; // Assegna il riferimento dell'oggetto passato al metodo alla variabile gamePlayView
        gamePlayView.setFirstProfPicked(false);
        try {
			initGamePlay();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        if (!studInGame.isEmpty()) {
        	gamePlayView.initializeView();// avvio il tempo
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
		    tutorInGame = gameModel.getTutorList();
	        normalPInGame = gameModel.getNormalProfList();
	        rectorInGame = gameModel.getRectorList();
		    bulletNormalList = gameModel.getBulletListNormal();
	        bulletDiagonalList = gameModel.getBulletListDiagonal();
		    
	        
	        addAllLists(tutorInGame, normalPInGame, rectorInGame);
		    
		    // Sincronizza l'accesso alle liste condivise
            synchronizeLists(() -> {
                gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
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
				    	if(allProfessors.isEmpty()) {
				    		try {
								userLost();
							} catch (IOException e) {
								e.printStackTrace();
							}
				    	}else {
				    		try {
								userWin();
							} catch (IOException e) {
								e.printStackTrace();
							}
				    	}
		                
		                break;
				    }
					
					sleep(2000);
			        
					// Sincronizza l'accesso alle liste condivise
	                synchronizeLists(() -> {
	                	advanceBullets(); // così dovrebbero andare più veloci
	                    gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
	                });
					
				    Iterator<Student> studentIterator = gameModel.getStudentList().iterator();
				    while (studentIterator.hasNext()) {
				        Student student = studentIterator.next();
				        
				        // Check dello studente se è vivo 
				        if (student.getHealthStudent() > 0) { 
				        	
				        	if (collisionBulletAndStudent(student, bulletNormalList) || collisionBulletAndStudent(student, bulletDiagonalList)) {
				        		if (student.getHealthStudent() <= 0) {
				        			
				        			removeStudentView(student);
						        	studentIterator.remove(); // Rimuovi lo studente morto dalla lista
				        		}
				        		
				        	}
				        	
				        	if (collisionProfAndStudent(student, allProfessors)) {
				        		// TODO aggiungere sync ??
				        		synchronizeLists(() -> {
				        			gamePlayView.getStudentViewList().get(studInGame.indexOf(student)).attackStudents();
			                    });
				        		
				        	}else {
				        		// Avanzamento in riga (diminuzione colonna)
					            if (student.getPositionStudent().getX() > 0) {
					            	student.setPositionStudent(new Elements<Integer, Integer> (student.getPositionStudent().getX() - 1,student.getPositionStudent().getY()));
					            }
				        	}
				            
				            
				            // Controllo se è arrivato nella cella finale
				            if (student.getPositionStudent().getX() == 0) {
				            	 // se nessun prof è presente in quella posizione ha perso
				            	 // sennò si colpice il prof 
				            	if (collisionProfAndStudent(student, allProfessors)) {
				            		// TODO aggiungere sync ??
				            		synchronizeLists(() -> {
				            			gamePlayView.getStudentViewList().get(studInGame.indexOf(student)).attackStudents();
				                    });
					        		
				            		//break;
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
				        	removeStudentView(student);
				        	studentIterator.remove(); // Rimuovi lo studente morto dalla lista
				        }
				        
				    }
				    
				    advanceBullets();
				    
				    addAllLists(gameModel.getTutorList(), gameModel.getNormalProfList(), gameModel.getRectorList());
				   // Logica per professori
				   List<Professor> professorsToRemove = new ArrayList<>();
				   List<List<? extends Professor>> allProfessorsCopy = new ArrayList<>(allProfessors);
				   for (List<? extends Professor> professorList : allProfessorsCopy) {
		                Iterator<? extends Professor> profIterator = professorList.iterator();
						    while (profIterator.hasNext()) {
						        Professor prof = profIterator.next();
			
					        	// il prof che viene colpito lo faccio già nel ciclo degli studenti
			        	  		if(prof.getHealthPointsProf() <= 0){
					                gameModel.setEnergy(gameModel.getEnergy() - prof.getCostProfessor());
			        	  			//TODO controllare
					                prof.setAttacked(false);
					                System.out.println("Il prof dovrebbe muorire ora e scomparire!");
					                removeProfessorView(prof);
					                
					                professorsToRemove.add(prof);
			        	  			//profIterator.remove();
			        	  			
			        	  		}else {
			        	  			// se è in vita ed è tempo di sparare: creo nuovo bullet e sparo
			        	  			// TODO decidere ogni quanto far sparare --> per ora ogni 4 sec
			        	  			if(gameModel.getTimeTot() % 4 == 0 && !prof.isAttacked()) {
			        	  				if(prof instanceof Tutor ) {
			        	  					Tutor curr = (Tutor) prof;
			        	  					bulletNormalList.add(new Bullet(curr.getBulletSpeed(), curr.getDamageProf(), curr.getPositionProf(), Tutor.getTutorbulletname(), curr.getTutorBullet().getPathImgBullet()));
			        	  					gameModel.setBulletListNormal(bulletNormalList);
			        	  				}else if(prof instanceof NormalProfessor) {
			        	  					NormalProfessor normalProfessor = (NormalProfessor) prof;
			        	  		            bulletNormalList.add(new Bullet(normalProfessor.getBulletSpeed(), prof.getDamageProf(), prof.getPositionProf(), normalProfessor.getNormalprofbulletname(), normalProfessor.getNormalProfBullet().getPathImgBullet()));
			        	  		        
			        	  				}else{
			        	  					Rector curr = (Rector) prof;
			        	  					bulletDiagonalList.add(new Bullet(curr.getBulletSpeed(), curr.getDamageProf(), curr.getPositionProf(), curr.getRectorbulletname(), curr.getRectorBullet().getPathImgBullet()));
			        	  					gameModel.setBulletListDiagonal(bulletDiagonalList);
			        	  				}
			        	  			}
			        	  			
			        	  		}
			        	  		
						        // Controlla se sono in vita ancora tutti i professori
						        /*if (allProfessors.isEmpty() && gamePlayView.isFirstProfPicked()) {
						            // Utente ha perso, aggiorna lo stato del gioco
						            gameStatus = false;
						            try {
						                userLost();
						            } catch (IOException e) {
						                e.printStackTrace();
						            }
						            break;
						        }*/
						        
						    }
				   }
				   for (List<? extends Professor> professorList : allProfessors) {
       	  		    	professorList.removeAll(professorsToRemove);
       	  			}
				}
				    // Sincronizza l'accesso alle liste condivise
	                synchronizeLists(() -> {
	                    gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
	                });
				    
				    // Introdotto un ritardo per la visibilità del gioco
			        sleep(2000);
			        
				    try {
						initGamePlay();
					} catch (IOException e) {
						e.printStackTrace();
					}
				    
				    sleep(200000);
				
    	
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
            synchronized (allProfessors) {
                synchronized (bulletNormalList) {
                    synchronized (bulletDiagonalList) {
                        action.run();
                    }
                }
            }
        }
    }
    
    public void userLost() throws IOException{
    	Platform.runLater(() -> {
            try {
		    	//carico il file fxml con la scritta hai perso
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/LostGameView.fxml"));
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
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/WinGameView.fxml"));
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
    private void advanceBullets() {
    	// Faccio avanzare i bullet
    	 Iterator<Bullet> bulletNormalIterator = bulletNormalList.iterator();
    	    while (bulletNormalIterator.hasNext()) {
    	        Bullet bullet = bulletNormalIterator.next();
    	        bullet.move(); 
    	        
    	        if (bullet.getPosition().getX() > 8) {
    	            bulletNormalIterator.remove(); 
    	            removeBulletView(bullet);
    	        }
    	    }

    	    // Faccio avanzare i bullet diagonali
    	    Iterator<Bullet> bulletDiagonalIterator = bulletDiagonalList.iterator();
    	    while (bulletDiagonalIterator.hasNext()) {
    	        Bullet bullet = bulletDiagonalIterator.next();
    	        bullet.shootDiagonal(); 

    	        if (bullet.getPosition().getX() > 8 || bullet.getPosition().getY()>4 || bullet.getPosition().getY()<0) {
    	            bulletDiagonalIterator.remove(); 
    	            removeBulletView(bullet); 
    	        }
    	    }
    	
    }
    
 // Rimozione del metodo removeBulletView() all'interno di collisionBulletAndStudent()
    public boolean collisionBulletAndStudent(Student currentStud, List<Bullet> bulletList) {
    	List<Bullet> bulletsToRemove = new ArrayList<>();
        boolean collisionDetected = false;

        for (Bullet bullet : bulletList) {
            if (bullet.getPosition().equals(currentStud.getPositionStudent())) {
                currentStud.takeDamageStudents(bullet.getBulletDamage());
                System.out.println("destroy bullet");
                bulletsToRemove.add(bullet); // Aggiungiamo il bullet da rimuovere alla lista
                collisionDetected = true;
            }
        }

        for (Bullet bullet : bulletsToRemove) {
            removeBulletView(bullet);
            bulletList.remove(bullet);
        }

        return collisionDetected;
    }
	
	public void removeBulletView(Bullet bullet) {
		BulletView bulletViewToRemove = null;
		
		if (bulletNormalList.indexOf(bullet) != -1) {
			bulletViewToRemove = gamePlayView.getBulletViewList().get(bulletNormalList.indexOf(bullet));
			bulletNormalList.remove(bullet); 
			
		}else if(bulletDiagonalList.indexOf(bullet) != -1) {
			bulletViewToRemove = gamePlayView.getBulletViewList().get(bulletDiagonalList.indexOf(bullet));
			bulletDiagonalList.remove(bullet); 
		}
		
		if (bulletViewToRemove != null) {
			gamePlayView.getBulletViewList().remove(bulletViewToRemove);
	        List<ElementView> elementsToRemove = new ArrayList<>();
	        elementsToRemove.add(bulletViewToRemove); 
	        //TODO aggiungere sync prima della remove ?
	        synchronizeLists(() -> {
            	gamePlayView.removePosition(elementsToRemove);
            });
	        
	        System.out.println("destroied bullet");
        
		}
	}
	 
	public boolean collisionProfAndStudent(Student currentStud, List<List<? extends Professor>> profList) {
		for (List<? extends Professor> professors : profList) {
	        Optional<? extends Professor> result = professors.stream()
	                .filter(prof -> prof.getPositionProf().equals(currentStud.getPositionStudent()))
	                .findFirst();
	        if (result.isPresent()) {
	            Professor professor = result.get();
	            professor.setHealthPointsProf(professor.getHealthPointsProf()-currentStud.getDamageStudent());
	            if (professor.getHealthPointsProf() > 0) {
	                // Il professore è vivo, quindi lo studente attacca il professore anziché avanzare
	            	System.out.println("prof attacked");
	            	professor.setAttacked(true);
	                return true; // Lo studente è bloccato nella posizione del professore
	            } else {
	                // Il professore è morto, quindi lo studente può avanzare
	                return false;
	            }
	        }
	    }
	    return false; // Nessuna collisione tra professore e studente
	}
	
	public void removeStudentView(Student student) {
		System.out.println("Studente è morto e va tolto dalla View");
		studInGame.remove(student); // Rimuovi lo studente morto dalla lista
		StudentView studentViewToRemove = gamePlayView.getStudentViewList().get(studInGame.indexOf(student)); // Trova il corrispondente StudentView
		gamePlayView.getStudentViewList().remove(studentViewToRemove); // Rimuovi lo StudentView dalla lista
        List<ElementView> elementsToRemove = new ArrayList<>();
        elementsToRemove.add(studentViewToRemove); // Aggiungi lo StudentView alla lista degli elementi da rimuovere
        //TODO aggiungere sync prima della remove ?
        synchronizeLists(() -> {
        	gamePlayView.removePosition(elementsToRemove); // Rimuovi lo studente morto dalla visualizzazione
        });
        
		
        scoreMatch.addScore();
		gamePlayView.updateMatchScoreLabel(scoreMatch);
	}
	
	public void removeProfessorView(Professor prof) {
		
	    /*List<ElementView> elementsToRemove = new ArrayList<>();

	    if (prof instanceof Tutor && tutorInGame.indexOf(prof) != -1) {
	        TutorView tutorViewToRemove = gamePlayView.getTutorViewList().get(tutorInGame.indexOf(prof));
	        tutorInGame.remove(prof);
	        gamePlayView.getTutorViewList().remove(tutorViewToRemove);
	        
	        elementsToRemove.add(tutorViewToRemove);
			
	    } else if (prof instanceof NormalProfessor && normalPInGame.indexOf(prof) != -1) {
	        NormalProfView normalPViewToRemove = gamePlayView.getNormalProfessorViewList().get(normalPInGame.indexOf(prof));
	        normalPInGame.remove(prof);
	        gamePlayView.getNormalProfessorViewList().remove(normalPViewToRemove);
	        
	        elementsToRemove.add(normalPViewToRemove);
			
	    } else if (prof instanceof Rector && rectorInGame.indexOf(prof) != -1) {
	        RectorView rectorPViewToRemove = gamePlayView.getRectorViewList().get(rectorInGame.indexOf(prof));
	        rectorInGame.remove(prof);
	        gamePlayView.getRectorViewList().remove(rectorPViewToRemove);
	        
	        elementsToRemove.add(rectorPViewToRemove);
			
	    }

	    //TODO aggiungere sync prima della remove ?
	    synchronizeLists(() -> {
	    	gamePlayView.removePosition(elementsToRemove);
        });
	    */
		
		    List<ElementView> elementsToRemove = new ArrayList<>();

		    Iterator<? extends Professor> iterator;
		    if (prof instanceof Tutor) {
		        iterator = tutorInGame.iterator();
		    } else if (prof instanceof NormalProfessor) {
		        iterator = normalPInGame.iterator();
		    } else if (prof instanceof Rector) {
		        iterator = rectorInGame.iterator();
		    } else {
		        return; // Tipo di professore non gestito
		    }

		    while (iterator.hasNext()) {
		        Professor currentProf = iterator.next();
		        if (currentProf.equals(prof)) {
		            iterator.remove();
		            break; // Esci dal ciclo una volta trovato il professore da rimuovere
		        }
		    }

		    // Rimuovi la vista associata al professore
		    if (prof instanceof Tutor) {
		        TutorView tutorViewToRemove = gamePlayView.getTutorViewList().stream()
		                .filter(view -> view.equals(prof))
		                .findFirst()
		                .orElse(null);
		        if (tutorViewToRemove != null) {
		            gamePlayView.getTutorViewList().remove(tutorViewToRemove);
		            elementsToRemove.add(tutorViewToRemove);
		        }
		    } else if (prof instanceof NormalProfessor) {
		        NormalProfView normalPViewToRemove = gamePlayView.getNormalProfessorViewList().stream()
		                .filter(view -> view.equals(prof))
		                .findFirst()
		                .orElse(null);
		        if (normalPViewToRemove != null) {
		            gamePlayView.getNormalProfessorViewList().remove(normalPViewToRemove);
		            elementsToRemove.add(normalPViewToRemove);
		        }
		    } else if (prof instanceof Rector) {
		        RectorView rectorPViewToRemove = gamePlayView.getRectorViewList().stream()
		                .filter(view -> view.equals(prof))
		                .findFirst()
		                .orElse(null);
		        if (rectorPViewToRemove != null) {
		            gamePlayView.getRectorViewList().remove(rectorPViewToRemove);
		            elementsToRemove.add(rectorPViewToRemove);
		        }
		    }

		    synchronizeLists(() -> {
		        gamePlayView.removePosition(elementsToRemove);
		    });
	}
	
	// per restiruire l'istanta corrente del GamePlayController
	public static GamePlayController getInstance() {
        if (instance == null) {
            instance = new GamePlayController();
        }
        return instance;
    }
	
    public Score getScoreMatch() {
		return scoreMatch;
	}

	public void setScoreMatch(Score scoreMatch) {
		this.scoreMatch = scoreMatch;
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

	public List<Student> getStudInGame() {
		return studInGame;
	}

	public void setStudInGame(List<Student> studInGame) {
		this.studInGame = studInGame;
	}
	
}
