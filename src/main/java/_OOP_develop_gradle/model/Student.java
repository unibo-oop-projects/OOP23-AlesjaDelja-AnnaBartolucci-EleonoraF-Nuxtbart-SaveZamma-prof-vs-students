package _OOP_develop_gradle.model;

import java.util.Random;

import _OOP_develop_gradle.Elements;
import _OOP_develop_gradle.view.StudentView;

public class Student {
	private int health;
	private int damage;
	private int DEFAULT_HEALTH = 100;
	private int DEFAULT_DAMAGE = 25;
	private int DEFAULT_SCORE = 100;
	private String pathStudentImg;
	private Elements<Integer, Integer> positionStudent;
	//Costruttore
	public Student(String pathStudentImg) {
		this.pathStudentImg = pathStudentImg; // TODO da mettere apposto con la foto che mi serve
		this.health = DEFAULT_HEALTH;
		this.damage = DEFAULT_DAMAGE;
		generateRandomPosition();
	}
	
	
	/**
	 * Creates a new Students in the end of the grid in a random row
	 * @return the rows and colum of the student created
	 */
	
	private void generateRandomPosition() {
        Random random = new Random();
        int randomY = random.nextInt(7);
        this.positionStudent = new Elements<>(0, randomY);
    }

	//Now we make the method that gets and sets the health and damage
	/**
	 * Gets the health of a student
	 * @return the health of the student
	 */
	public int getHealthStudent() {
		return health;
	}
	/**
	 * Gets the damage of a student
	 * @return the damage of the student
	 */
	public int getDamageStudent() {
		return damage;
	}
	/**
	 * Sets the health of a student
	 * @param health Value of the health
	 */
	public void setHealthStudent(int health) {
		this.health = health;
	}
	/**
	 * Sets the damage of a student
	 * @param damage
	 */
	public void setDamageStudent(int damage) {
		this.damage = damage;
	}
	
	/**
	 * Destroys the student
	 * @param score The score at the moment
	 * @return The new Score after the student is Killed
	 */
	
	public int destroyStudents(int score) { 
		StudentView studentView = new StudentView();
		studentView.removeStudent();
		int newScore = score + DEFAULT_SCORE;
		return newScore;
	}
	
	/**
	 * Updates the health when he gets attacked by a prof.
	 * If the health is less or equal to 0 then the students is destroyed.
	 * @param damageTaken Value of the damage of the prof.
	 */
	
	public void takeDamageStudents(int damageTaken) {
		health -= damageTaken;
	}
	/**
	 * Gets the position of the Students
	 * @return the current position of the student
	 */
	public Elements<Integer, Integer> getPositionStudent() {
		return positionStudent;
	} 
	/**
	 * Sets the new Position of the Student
	 * @param position Sets the new position of the student
	 */
	public void setPositionStudent(Elements<Integer, Integer> position) {
        this.positionStudent = position;
    }


	public String getPathStudentImg() {
		return pathStudentImg;
	}


	public void setPathStudentImg(String pathStudentImg) {
		this.pathStudentImg = pathStudentImg;
	}
	/* TODO Crearlo anche per lo studente
	 * private ImageView createImageView() { ImageView image = new ImageView(new
	 * Image(path)); image.setFitWidth(50); // Imposta la larghezza desiderata
	 * image.setFitHeight(50); // Imposta l'altezza desiderata return image; }
	 */
	/* Metodo per ottenere l'ImageView della pianta
    public ProfessorView getImageProf(Professor prof) {
    	return new ProfessorView(pathImg);
    }*/
}
