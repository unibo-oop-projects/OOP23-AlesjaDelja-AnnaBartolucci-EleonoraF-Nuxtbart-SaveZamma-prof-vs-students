package _OOP_develop_gradle;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GamePlayModel {

	    private int solarEnergy; // Energia solare
	    private int timeTot; // Tempo di gioco
	    private List<Student> studentList; // Lista di studenti presenti
	    private List<Professor> profList; // Lista di prof presenti
	    private int COST_OF_PROF = 1;
	    private int HEALTH_POINTS = 5;
	    
	    public GamePlayModel() {
	        this.solarEnergy = 0;
	        this.timeTot = 0;
	        this.studentList = new ArrayList<>();
	        this.profList = new ArrayList<>();
	    }

		public int getSolarEnergy() {
	        return solarEnergy;
	    }

	    public int getTimeTot() {
	        return timeTot;
	    }

	    public void setTimeTot(int time) {
	    	timeTot=time;
	    }
	    
	    public List<GamePlayModel.Student> getStudentList() {
	        return this.studentList;
	    }

	    public List<Professor> getProfList() {
	        return this.profList;
	    }

	    public void generateWave(int waveSize) {
	        // Creare una nuova ondata di studenti
	    	Random rand = new Random();
	    	
	        for (int i = 0; i < waveSize; i++) {
	            int randomRow = rand.nextInt(5); // numero casuale tra 0 e 5 per le righe
	            int col = 8; // gli studenti partono dall ultima colonna e poi avanzano

	            generateNewStudent(col, randomRow);
	        }
	    	
	    }

	   public Professor generateNewProf(int col, int row) {
	        // Creare un nuovo professore
	    	
    		col = 0;
    		Professor newProf = new Professor("", HEALTH_POINTS, col, row, null);
    		profList.add(newProf);
    		return newProf;
	    }

	    public void generateNewStudent(int col, int row) {
	        // Creare un nuovo studente
	    	// da implementare correttamente quando verrà implementata la classe Student
	    	Student student = new Student(col,row, "/img/sun.png");
	    	this.studentList.add(student);
	    }

	    public void increaseSolarEnergy(int amount) {
	        solarEnergy += amount;
	    }

	    public void decreaseSolarEnergy(int amount) {
	        if (solarEnergy >= amount) {
	            solarEnergy -= amount;
	        } else {
	        	// Manca energia
	        }
	    }
	    
	    public void increaseTimeTot(double amount) {
	    	timeTot += amount;
	    }

	    public boolean decreaseTimeTot(double amount) {
	        if (timeTot >= amount) {
	        	timeTot -= amount;
	        	return true;
	        } 
	        return false;
	    }

	    public void profKilled(Professor prof) {
	        // Logica quando un professore viene ucciso
	    	// [prof.getTimeCost()] per ogni professore morto devo togliere un tot di tempo, 
	    	// sarebbe da togliere in base al tipo di prof, per ora lo metto un valore fisso
	    	decreaseTimeTot(COST_OF_PROF);
	        // Rimuovi il prof dalla lista
	        profList.remove(prof);
	    }

	    

	    // Definizione classe Student (da implementare)

	    public class Student {
	        public int col;
	        public int row;
	        private String pathImg;
	        
			public Student(int col, int row, String pathImg) {
				this.col = col;
				this.row = row;
				this.pathImg = pathImg;
			}

			public ImageView getImageStud(Student stud) {
				ImageView studentImg = new ImageView(); // se crea già metodo --> stud.getImg() anche direttamente sotto nel setConstraints() ??
	    		studentImg.setImage(new Image(getClass().getResource(stud.getPathImg()).toString()));
	    		return studentImg;
			}
			public String getPathImg() {
				return pathImg;
			}

			public void setPathImg(String pathImg) {
				this.pathImg = pathImg;
			}

			public int getCol() {
				return col;
			}

			public void setCol(int col) {
				this.col = col;
			}

			public int getRow() {
				return row;
			}

			public void setRow(int row) {
				this.row = row;
			}
	        
	        // ...
	    }

	    public void handleStudentKilled(Student student) {
	        increaseTimeTot(getTimeTot());
	        getStudentList().remove(student);
	        //gestire la view //penso che si debba gestire nel controller
	        //gameView.update(gameModel); ???

	    }

	    public void handleProfKilled(Professor prof) {
	        decreaseTimeTot(getTimeTot());
	        getProfList().remove(prof);
	        //gestire la view //penso che si debba gestire nel controller
	        //update(gameModel);

	    }

}
