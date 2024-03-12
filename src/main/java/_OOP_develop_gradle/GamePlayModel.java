package _OOP_develop_gradle;

import java.util.List;
import java.util.ArrayList;

import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Student;

public class GamePlayModel {

		private static String STUDENT_PATH ="../../_OOP_develop_gradle/img/student.jpg";
	    private int matchScore; // Punteggio partita
	    private int timeTot; // Tempo di gioco
	    private List<Student> studentList; // Lista di studenti presenti
	    private List<Professor> profList; // Lista di prof presenti
	    private List<Bullet> bulletListNormal;
	    private List<Bullet> bulletListDiagonal;
	    
	    public GamePlayModel() {
	        this.matchScore = 0;
	        this.timeTot = 0;
	        this.studentList = new ArrayList<>();
	        this.profList = new ArrayList<>();
	        this.bulletListNormal = new ArrayList<>();
	        this.bulletListDiagonal = new ArrayList<>();
	    }

		public List<Bullet> getBulletListNormal() {
			return bulletListNormal;
		}


		public void setBulletListNormal(List<Bullet> bulletListNormal) {
			this.bulletListNormal = bulletListNormal;
		}

		public List<Bullet> getBulletListDiagonal() {
			return bulletListDiagonal;
		}

		public void setBulletListDiagonal(List<Bullet> bulletListDiagonal) {
			this.bulletListDiagonal = bulletListDiagonal;
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
	        for (int i = 0; i < waveSize; i++) {
	            generateNewStudent(STUDENT_PATH);
	        }
	    	
	    }

	   public Professor generateNewProf(int damage, double healthPoints, Elements<Integer, Integer> position, String pathImg, int costProfessor) {
	        // Creare un nuovo professore
    		Professor newProf = new Professor(damage, healthPoints, position, pathImg, costProfessor);
    		profList.add(newProf);
    		return newProf;
	    }

	    public void generateNewStudent(String pathToImg) {
	        // Creare un nuovo studente
	    	Student student = new Student(pathToImg);
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
}
