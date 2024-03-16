package _OOP_develop_gradle.model;

import java.util.List;


import java.util.ArrayList;

/**
 * Class representing the model for the gameplay.
 */
public class GamePlayModel implements GamePlayModelInterface {

		private int scoreMacth;
	    private int energy; // cost
	    private int timeTot;
	    private List<Student> studentList;
	    private List<Tutor> tutorList;
	    private List<NormalProfessor> normalProfList;
	    private List<Rector> rectorList;
	    private List<Bullet> bulletListNormal;
	    private List<Bullet> bulletListDiagonal;
	    
	    public GamePlayModel() {
	    	this.scoreMacth = 0;
	        this.energy = 0;
	        this.timeTot = 0;
	        this.studentList = new ArrayList<>();
	        this.tutorList = new ArrayList<>();
	        this.normalProfList = new ArrayList<>();
	        this.rectorList = new ArrayList<>();
	        this.bulletListNormal = new ArrayList<>();
	        this.bulletListDiagonal = new ArrayList<>();
	    }

	    /**
	     * Takes the match score.
	     * @return The match score.
	     */
	    public int getScoreMacth() {
			return scoreMacth;
		}

	    /**
	     * Takes the match score.
	     * @return The match score.
	     */
		public void setScoreMacth(int scoreMacth) {
			this.scoreMacth = scoreMacth;
		}

		/**
	     * Takes the list of normalProf bullets.
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
	     * Takes the list of diagonal bullets.
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
	     * Takes the energy.
	     * @return The energy.
	     */
		public int getEnergy() {
			return energy;
		}

		 /**
	     * Sets the energy.
	     * @param energy The energy.
	     */
		public void setEnergy(int matchScore) {
			this.energy = matchScore;
		}

		 /**
	     * Takes the total game time.
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
	     * Takes the list of students.
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
	        for (int i = 0; i < waveSize; i++) {
	            generateNewStudent();
	        }
	    }

	    /**
	     * Takes the list of tutors.
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
		 * Takes the list of normal professors.
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
		 * Takes the list of rectors.
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
		 * @return The new tutor generated.
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
		 * @return The new normal professor generated.
		 */
		public NormalProfessor generateNewNormalP(int damage, double healthPoints, Elements<Integer, Integer> position, String pathImg, int costProfessor, int idProf) {
			NormalProfessor newnormalProf = new NormalProfessor(position.getX(), position.getY());
			normalProfList.add(newnormalProf);
    		return newnormalProf;
	    }
		
		/**
		 * Generates a new rector and adds it to the list.
		 * @param position The position of the new rector.
		 * @return The new rector generated.
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
	    public void increaseEnergy(int amount) {
	    	energy += amount;
	    }
	    
	    /**
	     * Decreases the match score by a specified amount.
	     * @param amount The amount to decrease the match score by.
	     * @return True if the match score was successfully decreased, false otherwise.
	     */
	    public boolean decreaseEnergy(int amount) {
	        if (energy >= amount) {
	        	energy -= amount;
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
