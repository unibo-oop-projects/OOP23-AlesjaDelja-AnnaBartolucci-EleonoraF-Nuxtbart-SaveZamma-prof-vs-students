package _OOP_develop_gradle;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Student;

public class GamePlayModel {

	    private int matchScore; // Punteggio partita
	    private int timeTot; // Tempo di gioco
	    private List<Student> studentList; // Lista di studenti presenti
	    private List<Professor> profList; // Lista di prof presenti
	    //private int COST_OF_PROF = 1;
	    
	    public GamePlayModel() {
	        this.matchScore = 0;
	        this.timeTot = 0;
	        this.studentList = new ArrayList<>();
	        this.profList = new ArrayList<>();
	    }

		
	    public int getMatchScore() {
			return matchScore;
		}

		public void setMatchScore(int matchScore) {
			this.matchScore = matchScore;
		}

		public int getTimeTot() {
	        return timeTot;
	    }

	    public void setTimeTot(int time) {
	    	timeTot=time;
	    }
	    
	    public List<Student> getStudentList() {
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

	   public Professor generateNewProf(int damage, double healthPoints, Elements<Integer, Integer> position, String pathImg, int costProfessor) {
	        // Creare un nuovo professore
    		Professor newProf = new Professor(damage, healthPoints, position, pathImg, costProfessor);
    		profList.add(newProf);
    		return newProf;
	    }

	    public void generateNewStudent(int col, int row) {
	        // Creare un nuovo studente
	    	Student student = new Student(col,row);
	    	this.studentList.add(student);
	    }

	    public void increaseMatchScore(int amount) {
	    	matchScore += amount;
	    }

	    public boolean decreaseMatchScore(int amount) {
	        if (matchScore >= amount) {
	        	matchScore -= amount;
	        	return true;
	        } 
	        return false;
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

	   /* public void profKilled(Professor prof) {
	        // Logica quando un professore viene ucciso
	    	// [prof.getTimeCost()] per ogni professore morto devo togliere un tot di tempo, 
	    	// sarebbe da togliere in base al tipo di prof, per ora lo metto un valore fisso
	    	decreaseMatchScore(COST_OF_PROF);
	        // Rimuovi il prof dalla lista
	        profList.remove(prof);
	    }*/
}
