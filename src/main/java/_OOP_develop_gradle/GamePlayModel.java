package _OOP_develop_gradle;

import java.util.List;
import java.util.ArrayList;

import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Student;
/**
 * Class representing the model for the gameplay.
 */
public class GamePlayModel {

	    private int matchScore; // Punteggio partita
	    private int timeTot; // Tempo di gioco
	    private List<Student> studentList; // Lista di studenti presenti
	    private List<Tutor> tutorList; // Lista di tutor presenti
	    private List<NormalProfessor> normalProfList; // Lista di normal p presenti
	    private List<Rector> rectorList; // Lista di rector presenti
	    private List<Bullet> bulletListNormal;
	    private List<Bullet> bulletListDiagonal;
	    
	    public GamePlayModel() {
	        this.matchScore = 0;
	        this.timeTot = 0;
	        this.studentList = new ArrayList<>();
	        this.tutorList = new ArrayList<>();
	        this.normalProfList = new ArrayList<>();
	        this.rectorList = new ArrayList<>();
	        this.bulletListNormal = new ArrayList<>();
	        this.bulletListDiagonal = new ArrayList<>();
	    }

	    /**
	     * Retrieves the list of normalProf bullets.
	     * @return The list of normalProf bullets.
	     */
		public List<Bullet> getBulletListNormal() {
			return bulletListNormal;
		}

		/**
	     * Sets the list of normalProf bullets.
	     * @param bulletListNormal The list of normalProf bullets.
	     */
		public void setBulletListNormal(List<Bullet> bulletListNormal) {
			this.bulletListNormal = bulletListNormal;
		}

		/**
	     * Retrieves the list of diagonal bullets.
	     * @return The list of diagonal bullets.
	     */
		public List<Bullet> getBulletListDiagonal() {
			return bulletListDiagonal;
		}

		 /**
	     * Sets the list of diagonal bullets.
	     * @param bulletListDiagonal The list of diagonal bullets.
	     */
		public void setBulletListDiagonal(List<Bullet> bulletListDiagonal) {
			this.bulletListDiagonal = bulletListDiagonal;
		}

		/**
	     * Retrieves the match score.
	     * @return The match score.
	     */
		public int getMatchScore() {
			return matchScore;
		}

		 /**
	     * Sets the match score.
	     * @param matchScore The match score.
	     */
		public void setMatchScore(int matchScore) {
			this.matchScore = matchScore;
		}

		 /**
	     * Retrieves the total game time.
	     * @return The total game time.
	     */
		public int getTimeTot() {
	        return timeTot;
	    }

		/**
	     * Sets the total game time.
	     * @param time The total game time.
	     */
	    public void setTimeTot(int time) {
	    	timeTot=time;
	    }
	    
	    /**
	     * Retrieves the list of students.
	     * @return The list of students.
	     */
	    public List<Student> getStudentList() {
	        return this.studentList;
	    }

	    /**
	     * Generates a wave of students.
	     * @param waveSize The size of the wave.
	     */
	    public void generateWave(int waveSize) {
	        // Creare una nuova ondata di studenti
	        for (int i = 0; i < waveSize; i++) {
	            generateNewStudent();
	        }
	    	
	    }

	    /**
	     * Retrieves the list of tutors.
	     * @return The list of tutors.
	     */
	   public List<Tutor> getTutorList() {
			return tutorList;
		}

	   /**
	    * Sets the list of tutors.
	    * @param tutorList The list of tutors.
	    */
		public void setTutorList(List<Tutor> tutorList) {
			this.tutorList = tutorList;
		}

		/**
		 * Retrieves the list of normal professors.
		 * @return The list of normal professors.
		 */
		public List<NormalProfessor> getNormalProfList() {
			return normalProfList;
		}

		/**
		 * Sets the list of normal professors.
		 * @param normalProfList The list of normal professors.
		 */
		public void setNormalProfList(List<NormalProfessor> normalProfList) {
			this.normalProfList = normalProfList;
		}

		/**
		 * Retrieves the list of rectors.
		 * @return The list of rectors.
		 */
		public List<Rector> getRectorList() {
			return rectorList;
		}

		/**
		 * Sets the list of rectors.
		 * @param rectorList The list of rectors.
		 */
		public void setRectorList(List<Rector> rectorList) {
			this.rectorList = rectorList;
		}

		/**
		 * Sets the list of students.
		 * @param studentList The list of students.
		 */
		public void setStudentList(List<Student> studentList) {
			this.studentList = studentList;
		}

		/**
		 * Generates a new tutor and adds it to the list.
		 * @param position The position of the new tutor.
		 * @return The newly generated tutor.
		 */
		public Tutor generateNewTutor(Elements<Integer, Integer> position) {
			Tutor newTutor = new Tutor(position.getX(), position.getY());
    		tutorList.add(newTutor);
    		return newTutor;
	    }
		/**
		 * Generates a new normal professor and adds it to the list.
		 * @param damage The damage of the new normal professor.
		 * @param healthPoints The health points of the new normal professor.
		 * @param position The position of the new normal professor.
		 * @param pathImg The image path of the new normal professor.
		 * @param costProfessor The cost of the new normal professor.
		 * @param idProf The ID of the new normal professor.
		 * @return The newly generated normal professor.
		 */
		public NormalProfessor generateNewNormalP(int damage, double healthPoints, Elements<Integer, Integer> position, String pathImg, int costProfessor, int idProf) {
			NormalProfessor newnormalProf = new NormalProfessor(position.getX(), position.getY());
			normalProfList.add(newnormalProf);
    		return newnormalProf;
	    }
		/**
		 * Generates a new rector and adds it to the list.
		 * @param position The position of the new rector.
		 * @return The newly generated rector.
		 */
		public Rector generateNewRector(Elements<Integer, Integer> position ) {
			Rector newRector = new Rector(position.getX(), position.getY());
    		rectorList.add(newRector);
    		return newRector;
	    }
		/**
		 * Generates a new student and adds it to the list.
		 */
	    public void generateNewStudent() {
	    	Student student = new Student();
	    	this.studentList.add(student);
	    }
	    /**
	     * Increases the match score by a specified amount.
	     * @param amount The amount to increase the match score by.
	     */
	    public void increaseMatchScore(int amount) {
	    	matchScore += amount;
	    }
	    /**
	     * Decreases the match score by a specified amount.
	     * @param amount The amount to decrease the match score by.
	     * @return True if the match score was successfully decreased, false otherwise.
	     */
	    public boolean decreaseMatchScore(int amount) {
	        if (matchScore >= amount) {
	        	matchScore -= amount;
	        	return true;
	        } 
	        return false;
	    }
	    /**
	     * Increases the total game time by a specified amount.
	     * @param amount The amount to increase the total game time by.
	     */
	    public void increaseTimeTot(double amount) {
	    	timeTot += amount;
	    }
	    /**
	     * Decreases the total game time by a specified amount.
	     * @param amount The amount to decrease the total game time by.
	     * @return True if the total game time was successfully decreased, false otherwise.
	     */
	    public boolean decreaseTimeTot(double amount) {
	        if (timeTot >= amount) {
	        	timeTot -= amount;
	        	return true;
	        } 
	        return false;
	    }
}
