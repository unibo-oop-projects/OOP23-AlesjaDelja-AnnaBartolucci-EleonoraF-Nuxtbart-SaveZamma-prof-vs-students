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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GamePlayController {
	
	private static GamePlayController instance;
	public boolean gameStatus;
	
	public static int TIME_TO_SHOOT = 4;
	public static int ENERGY_INIT = 40;
	public static int TEMPO_TRA_ONDATE = 2; // tempo tra ondate da definire meglio!!!! TODO
	public static int TEMPO_TOT_INIT = 60;
	public static int NUM_STUD_ONDATA;
	public static GamePlayModel gameModel;
	public GamePlayView gamePlayView;
	public Score scoreMatch;
	public boolean firstProfPicked;
	public List<Bullet> bulletNormalList = new ArrayList<>();
	public List<Bullet> bulletDiagonalList = new ArrayList<>();
	
	public List<Tutor> tutorInGame = new ArrayList<>(); 
	public List<NormalProfessor> normalPInGame = new ArrayList<>(); 
	public List<Rector> rectorInGame = new ArrayList<>(); 
	public List<Student> studInGame = new ArrayList<>();
	private List<List<? extends Professor>> allProfessors = new ArrayList<>();
	
	public void addAllLists(List<Tutor> tutorInGame, List<NormalProfessor> normalPInGame, List<Rector> rectorInGame) {
		allProfessors.clear();
	    allProfessors.add(tutorInGame);
        allProfessors.add(normalPInGame);
        allProfessors.add(rectorInGame);
    }
	
	/**
	 * Initializes the game data with the specified {@code GamePlayView}.
	 * Initializes various game elements such as score, game status, and lists of bullets and professors.
	 * Also sets up the game view and starts the game if there are students present.
	 *
	 * @param gamePlayView The GamePlayView instance to initialize the game with.
	 */
	public void initData(GamePlayView gamePlayView) {
    	NUM_STUD_ONDATA = 1;
    	scoreMatch = new Score();
    	scoreMatch.resetScore();
    	gameStatus = true;
    	
        gameModel = new GamePlayModel();
        gameModel.setScoreMacth(scoreMatch.getScore());
        gameModel.setTimeTot(TEMPO_TOT_INIT);
        gameModel.setEnergy(ENERGY_INIT);
        bulletNormalList = gameModel.getBulletListNormal();
        bulletDiagonalList = gameModel.getBulletListDiagonal();
        tutorInGame = gameModel.getTutorList();
        normalPInGame = gameModel.getNormalProfList();
        rectorInGame = gameModel.getRectorList();
        studInGame = gameModel.getStudentList();
        
        addAllLists(tutorInGame, normalPInGame, rectorInGame);
        
        this.gamePlayView = gamePlayView;
        gamePlayView.setFirstProfPicked(false);
        try {
			initGamePlay();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        if (!studInGame.isEmpty()) {
        	gamePlayView.initializeView();
            startGame(gamePlayView);
            
        }
    }
	/**
	 * Initializes the gameplay by generating a new wave of students.
	 * Updates the game view with the new positions of the students and professors.
	 *
	 * @throws IOException If an I/O error occurs while initializing the game.
	 */
	public void initGamePlay() throws IOException {
    	
    	if(gameStatus) {
            synchronizeLists(() -> {
            	gameModel.generateWave(NUM_STUD_ONDATA);
                gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
            });
            
		    System.out.println("settato nuvo gruppo di studenti");
		}
    }
	/**
	 * Moves the students in the game by advancing their positions and handling collisions with professors.
	 * Updates the game status if necessary and removes defeated students from the game.
	 */
   public void moveStudents() {
	   
	   List<Student> studentToRemove = new ArrayList<>();
       List<Student> studentCopy = new ArrayList<>(studInGame);
	    Iterator<Student> studentIterator = studentCopy.iterator();
	    while (studentIterator.hasNext()) {
	        Student student = studentIterator.next();
	        
	        if (student.getHealthStudent() > 0) { 
	        	
	        	if (collisionProfAndStudent(student, allProfessors)) {
	        		// TODO aggiungere sync ??
	        		/*synchronizeLists(() -> {
	        			gamePlayView.getStudentViewList().get(studInGame.indexOf(student)).attackStudents();
                   });*/
	        		
	        	}else {
	        		// Avanzamento in riga (diminuzione colonna)
		            if (student.getPosition().getX() > 0) {
		            	student.setPosition(new Elements<Integer, Integer> (student.getPosition().getX() - 1,student.getPosition().getY()));
		            }
	        	}
	            
	            if (student.getPosition().getX() == 0) {
	            	if (collisionProfAndStudent(student, allProfessors)) {
	            		synchronizeLists(() -> {
	            			//gamePlayView.getStudentViewList().get(studInGame.indexOf(student)).attackStudents();
	            			gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
	                    });
		        		
	            	}else {
	            		// Utente ha perso, aggiorna lo stato del gioco
		                gameStatus = false;
		                gamePlayView.setTimerStop(true);
		                try {
							userGame("Sconfitta");
						} catch (IOException e) {
							e.printStackTrace();
						}
		                break;
	            	}
	                
	            }
	        } else {
	        	studentToRemove.add(student);
	        }
	        
	   }
	   studInGame.removeAll(studentToRemove);
   }
   /**
    * Handles the behavior of professors in the game, such as shooting bullets and removing defeated professors.
    * Also updates the game energy based on the status of professors.
    */
   public void handleProfessors() {
	   
	   List<Professor> professorsToRemove = new ArrayList<>();
	   List<List<? extends Professor>> allProfessorsCopy = new ArrayList<>(allProfessors);
	   if(!allProfessorsCopy.isEmpty()) {
		    for (List<? extends Professor> professorList : allProfessorsCopy) {
			   Iterator<? extends Professor> profIterator = professorList.iterator();
			   while (profIterator.hasNext() && !professorList.isEmpty()) {
			        Professor prof = profIterator.next();
	
	    	  		if(prof.getHealthPointsProf() <= 0){
	    	  			gameModel.setEnergy(Math.max(0, gameModel.getEnergy() - prof.getEnergyProfessor()));
		                prof.setAttacked(false);
		                System.out.println("Il prof scompare, non ha più vite");
		                professorsToRemove.add(prof);
		                profIterator.remove();
		                
	    	  		}else if(!collisionProfAndStudents(studInGame, prof)){
	    	  			if(gameModel.getTimeTot() % TIME_TO_SHOOT == 0 && !prof.isAttacked()) {
	    	  				if(prof instanceof Tutor ) {
	    	  					Tutor curr = (Tutor) prof;
	    	  					bulletNormalList.add(new Bullet(curr.getBulletSpeed(), curr.getDamageProf(), curr.getPositionProf()));
	    	  					gameModel.setBulletListNormal(bulletNormalList);
	    	  				}else if(prof instanceof NormalProfessor) {
	    	  					NormalProfessor normalProfessor = (NormalProfessor) prof;
	    	  		            bulletNormalList.add(new Bullet(normalProfessor.getBulletSpeed(), normalProfessor.getDamageProf(), normalProfessor.getPositionProf()));
	    	  		            gameModel.setBulletListNormal(bulletNormalList);
	    	  				}else{
	    	  					Rector curr = (Rector) prof;
	    	  					bulletDiagonalList.add(new Bullet(curr.getBulletSpeed(), curr.getDamageProf(), curr.getPositionProf()));
	    	  					gameModel.setBulletListDiagonal(bulletDiagonalList);
	    	  				}
	    	  			}
	    	  			
		  			}
			   }
		   }
	   }
	   for (List<? extends Professor> professorList : allProfessors) {
		  
		   professorsToRemove.forEach(bullet -> { removeProfessorView(bullet);});
		   professorList.removeIf(professorsToRemove::contains);
 		}
   }
   /**
    * Advances the bullets in the game by moving them and handling collisions with students.
    * Removes bullets that have reached their maximum range or have hit a student.
    */
   private void advanceBullets() {
	 List<Bullet> bulletToRemoveN = new ArrayList<>();
     List<Bullet> bulletNormalCopy = new ArrayList<>(bulletNormalList);
   	 Iterator<Bullet> bulletNormalIterator = bulletNormalCopy.iterator();
   	    while (bulletNormalIterator.hasNext() && !bulletNormalCopy.isEmpty()) {
   	        Bullet bullet = bulletNormalIterator.next();
   	        
   	        if(collisionBulletAndStudents(studInGame, bullet)) {
   	        	bulletToRemoveN.add(bullet);
   	        	//bulletNormalIterator.remove();
   	        }else {
   	        	bullet.move();
   	        }
   	        
   	        if (bullet.getPosition().getX() > 8) {
   	        	bulletToRemoveN.add(bullet);
   	        	//bulletNormalIterator.remove();
   	        }
   	    }

		bulletToRemoveN.forEach(bullet -> { removeBulletView(bullet);});
		bulletNormalList.removeIf(bulletToRemoveN::contains);
   	
   	List<Bullet> bulletToRemoveD = new ArrayList<>();
   	List<Bullet> bulletDiagonalCopy = new ArrayList<>(bulletDiagonalList);
    Iterator<Bullet> bulletDiagonalIterator = bulletDiagonalCopy.iterator();
	    while (bulletDiagonalIterator.hasNext() && !bulletDiagonalCopy.isEmpty()) {
	        Bullet bullet = bulletDiagonalIterator.next();
	        
	        if(collisionBulletAndStudents(studInGame, bullet)) {
	    		bulletToRemoveD.add(bullet);
	    		//bulletDiagonalIterator.remove();
		    }else {
	    		bullet.shootDiagonal();
		    }
	        
	        if (bullet.getPosition().getX() > 8 || bullet.getPosition().getY()>4 || bullet.getPosition().getY()<0) {
	        	bulletToRemoveD.add(bullet);
	            //bulletDiagonalIterator.remove();
	        }
	    }
	    bulletToRemoveD.forEach(bullet -> { removeBulletView(bullet);});
	    bulletDiagonalList.removeIf(bulletToRemoveD::contains);
}
   
   /**
    * Starts the game by initializing various game threads and loops to manage gameplay mechanics such as
    * advancing time, updating positions, handling collisions, and checking game status for victory or defeat.
    *
    * @param gamePlayView The GamePlayView instance used to interact with the game view.
    */
    public void startGame(GamePlayView gamePlayView){
    	if(gameStatus) {
    		new Thread(() -> {
    			while (gameStatus) {
    				
					synchronizeLists(() -> {
						if (gameModel.getTimeTot()==0 || (gameModel.getEnergy() == 0 && allProfessors.stream().allMatch(list -> list.isEmpty())) ) {
					    	gameStatus = false;
					    	
					    	if(allProfessors.stream().allMatch(list -> list.isEmpty())) {
					    		try {
					    			userGame("Sconfitta");
								} catch (IOException e) {
									e.printStackTrace();
								}
					    	}else {
					    		try {
									userGame("Vittoria");
								} catch (IOException e) {
									e.printStackTrace();
								}
					    	}
						}
			    	 });
			    	
					}
				    
				}).start();
    		
		    new Thread(() -> {
				while (gameStatus) {
					sleep(6000);
			        
	                synchronizeLists(() -> {
	                    gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
	                    moveStudents();
	                    gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
	                });
				}
    	
			}).start();
		    
		    new Thread(() -> {
		    	while (gameStatus) {
			    	try {
				    	sleep(10000);
						initGamePlay();
					} catch (IOException e) {
						e.printStackTrace();
					}
		    	}
		    }).start();
		    
		    
	        new Thread(() -> {
	            while (gameStatus) {
	            	synchronizeLists(() -> {
	                    gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
		            	advanceBullets();
		            	handleProfessors();
		            	gamePlayView.updatePositions(studInGame, allProfessors, bulletNormalList, bulletDiagonalList);
	                });
	            	
	                sleep(1000);
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
            synchronized (allProfessors) {
                synchronized (bulletNormalList) {
                    synchronized (bulletDiagonalList) {
                        action.run();
                    }
                }
            }
        }
    }
    /**
     * Displays the game status (victory or defeat) to the user in a separate window using JavaFX.
     *
     * @param status The status of the game, either "Vittoria" for victory or "Sconfitta" for defeat.
     * @throws IOException If an I/O error occurs while loading the game status view.
     */
    public void userGame(String Status) throws IOException{
    	Platform.runLater(() -> {
            try {
		    	
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/StatusGameView.fxml"));
		        Parent lostGame = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(lostGame));
		     
	            Label label = (Label) lostGame.lookup("#gameLabel");

	            if (Status.equals("Vittoria")) {
	                label.setText("Hai vinto!");
	            } else if (Status.equals("Sconfitta")) {
	                label.setText("Hai perso!");
	            }
		        stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * Delays the execution of the current thread for the specified number of milliseconds,
     * allowing for the visibility of the game to be adjusted.
     *
     * @param num The number of milliseconds to sleep.
     */
	private void sleep(int num) {
		if(gameModel.getTimeTot()>0) {
			try {
		        Thread.sleep(num);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
	}
	/**
	 * Checks for collisions between bullets and students, updating game state accordingly.
	 *
	 * @param studentList The list of students in the game.
	 * @param bullet The bullet to check for collisions with students.
	 * @return True if a collision between the bullet and a student is detected, false otherwise.
	 */
	public boolean collisionBulletAndStudents(List<Student> studentList, Bullet bullet) {
		List<Student> studentToRemove = new ArrayList<>();
		boolean collisionDetected = false;

	    for (Student currentStud : studentList) {
	        if (bullet.getPosition().equals(currentStud.getPosition())) {
	            currentStud.takeDamageStudents(bullet.getBulletDamage());
	            System.out.println("destroy bullet");
	            collisionDetected = true;
	            
	            if (currentStud.getHealthStudent() <= 0) {
	            	scoreMatch.addScore();
	    	        gameModel.setScoreMacth(scoreMatch.getScore());
	    	        gameModel.setEnergy(gameModel.getEnergy() + currentStud.getEnergy());
	    			studentToRemove.add(currentStud);
	            }
	        }
	    }
	    
	    for (Student student : studentToRemove) {
	    	removeStudentView(student);
            studentList.remove(student);
        }
	    return collisionDetected;
	}
	/**
	 * Removes the graphical representation of a bullet from the game view.
	 *
	 * @param bullet The bullet to remove from the game view.
	 */
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
	        
	        synchronizeLists(() -> {
            	gamePlayView.removePosition(elementsToRemove);
            });
	        
	        System.out.println("destroied bullet");
        
		}
	}
	/**
	 * Checks for collisions between professors and students, updating game state accordingly.
	 *
	 * @param students The list of students in the game.
	 * @param prof The professor to check for collisions with students.
	 * @return True if a collision between the professor and a student is detected, false otherwise.
	 */ 
	public boolean collisionProfAndStudents(List<Student> students, Professor prof) {
		
	    for (Student currentStud : students) {
	        if (currentStud.getPosition().equals(prof.getPosition())) {
	        	prof.receiveDamageProf(currentStud.getDamage());
	            System.out.println("prof attacked PROFESSOR");
	            
	            if (prof.getHealthPointsProf() > 0) {
	            	System.out.println("prof has other lives");
	            	prof.setAttacked(true);
	                return true; 
	            } else {
	                return false;
	            }
	        }
	    }
	    
	    return false;
	}
	/**
	 * Checks for collisions between a professor and a specific student.
	 *
	 * @param currentStud The student to check for collisions with professors.
	 * @param profList The list of professor lists to check for collisions with the student.
	 * @return True if a collision between the professor and the student is detected, false otherwise.
	 */
	public boolean collisionProfAndStudent(Student currentStud, List<List<? extends Professor>> profList) {
		for (List<? extends Professor> professors : profList) {
	        Optional<? extends Professor> result = professors.stream()
	                .filter(prof -> prof.getPositionProf().equals(currentStud.getPosition()))
	                .findFirst();
	        if (result.isPresent()) {
	            Professor professor = result.get();
	            if (professor.getHealthPointsProf() > 0) {
	            	System.out.println("prof attacked STUDENT");
	            	professor.setAttacked(true);
	                return true; 
	            } else {
	                return false;
	            }
	        }
	    }
	    return false;
	}
	/**
	 * Removes the graphical representation of a student from the game view.
	 *
	 * @param student The student to remove from the game view.
	 */
	public void removeStudentView(Student student) {
	    synchronized (studInGame) {
	        Iterator<Student> iterator = studInGame.iterator();
	        while (iterator.hasNext()) {
	            Student currentStudent = iterator.next();
	            if (currentStudent.equals(student)) {
	                iterator.remove();
	                int studentIndex = gamePlayView.getStudentViewList().indexOf(student);
	                if (studentIndex != -1) {
	                    StudentView studentViewToRemove = gamePlayView.getStudentViewList().get(studentIndex);
	                    gamePlayView.getStudentViewList().remove(studentViewToRemove);
	                    List<ElementView> elementsToRemove = new ArrayList<>();
	                    elementsToRemove.add(studentViewToRemove);
	                    synchronizeLists(() -> {
	                        gamePlayView.removePosition(elementsToRemove);
	                    });
	                }
	                break;
	            }
	        }
	    }
	}
	
		/**
		 * Removes the graphical representation of a professor from the game view and updates the game state accordingly.
		 *
		 * @param prof The professor whose graphical representation needs to be removed.
		 */
		public void removeProfessorView(Professor prof) {
		    List<ElementView> elementsToRemove = new ArrayList<>();

		    Iterator<? extends Professor> iterator;
		    if (prof instanceof Tutor) {
		        iterator = tutorInGame.iterator();
		    } else if (prof instanceof NormalProfessor) {
		        iterator = normalPInGame.iterator();
		    } else if (prof instanceof Rector) {
		        iterator = rectorInGame.iterator();
		    } else {
		        return;
		    }

		    while (iterator.hasNext()) {
		        Professor currentProf = iterator.next();
		        if (currentProf.equals(prof)) {
		            iterator.remove();
		            break;
		        }
		    }

		    // Rimuovi la vista associata al professore
		    if (prof instanceof Tutor) {
		        TutorView tutorViewToRemove = gamePlayView.getTutorViewList().stream()
		                .filter(view -> view.equals(prof))
		                .findFirst()
		                .orElse(null);
		        if (tutorViewToRemove != null) {
		        	synchronizeLists(() -> {
		            gamePlayView.getTutorViewList().remove(tutorViewToRemove);
		        	});
		            elementsToRemove.add(tutorViewToRemove);
		        }
		    } else if (prof instanceof NormalProfessor) {
		        NormalProfView normalPViewToRemove = gamePlayView.getNormalProfessorViewList().stream()
		                .filter(view -> view.equals(prof))
		                .findFirst()
		                .orElse(null);
		        if (normalPViewToRemove != null) {
		        	synchronizeLists(() -> {
		            gamePlayView.getNormalProfessorViewList().remove(normalPViewToRemove);
		        	});
		            elementsToRemove.add(normalPViewToRemove);
		        }
		    } else if (prof instanceof Rector) {
		        RectorView rectorPViewToRemove = gamePlayView.getRectorViewList().stream()
		                .filter(view -> view.equals(prof))
		                .findFirst()
		                .orElse(null);
		        if (rectorPViewToRemove != null) {
		        	synchronizeLists(() -> {
		            gamePlayView.getRectorViewList().remove(rectorPViewToRemove);
		        	});
		            elementsToRemove.add(rectorPViewToRemove);
		        }
		    }

		    synchronizeLists(() -> {
		        gamePlayView.removePosition(elementsToRemove);
		    });
	}
	
	/**
	 * Retrieves the current instance of the GamePlayController, ensuring that only one instance is created.
	 *
	 * @return The current instance of the GamePlayController.
	 */
	public static GamePlayController getInstance() {
        if (instance == null) {
            instance = new GamePlayController();
        }
        return instance;
    }
	/**
	 * Retrieves the score of the current match.
	 *
	 * @return The score of the current match.
	 */
    public Score getScoreMatch() {
		return scoreMatch;
	}
    /**
     * Sets the score of the current match.
     *
     * @param scoreMatch The score of the current match to be set.
     */
	public void setScoreMatch(Score scoreMatch) {
		this.scoreMatch = scoreMatch;
	}
	/**
	 * Checks the status of the game.
	 *
	 * @return True if the game is currently active, false otherwise.
	 */
	public boolean isGameStatus() {
		return gameStatus;
	}
	/**
	 * Sets the status of the game.
	 *
	 * @param status The status of the game to be set.
	 */
	public void setGameStatus(boolean status) {
        gameStatus = status;
    }
	/**
	 * Retrieves the GamePlayView associated with this controller.
	 *
	 * @return The GamePlayView associated with this controller.
	 */
	public GamePlayView getGamePlayView() {
        return gamePlayView;
    }
	/**
	 * Retrieves the GamePlayModel associated with this controller.
	 *
	 * @return The GamePlayModel associated with this controller.
	 */
	public static GamePlayModel getGameModel() {
		return gameModel;
	}
	/**
	 * Retrieves the list of students currently in the game.
	 *
	 * @return The list of students currently in the game.
	 */
	public List<Student> getStudInGame() {
		return studInGame;
	}
	/**
	 * Sets the list of students currently in the game.
	 *
	 * @param studInGame The list of students currently in the game to be set.
	 */
	public void setStudInGame(List<Student> studInGame) {
		this.studInGame = studInGame;
	}
	
}
