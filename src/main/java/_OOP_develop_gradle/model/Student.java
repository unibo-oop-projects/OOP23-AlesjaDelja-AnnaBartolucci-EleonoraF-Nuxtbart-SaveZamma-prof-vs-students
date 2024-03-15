package _OOP_develop_gradle.model;

import java.util.Random;


public class Student {
	private int health;
	private int damage;
	private int energy;
	//  TODO da sistemare
	private int DEFAULT_HEALTH = 25;
	private int DEFAULT_DAMAGE = 25;
	private int DEFAULT_ENERGY = 10;
	private Elements<Integer, Integer> positionStudent;
	//Costructor
	public Student() {
		this.health = DEFAULT_HEALTH;
		this.damage = DEFAULT_DAMAGE;
		this.energy = DEFAULT_ENERGY;
        generateRandomPosition();
	}
	
	
	public int getEnergy() {
		return energy;
	}


	public void setEnergy(int energy) {
		this.energy = energy;
	}


	/**
	 * Creates a new Students in the end of the grid in a random row
	 * @return the rows and colum of the student created
	 */
	
	private void generateRandomPosition() {
        Random random = new Random();
        int randomY = random.nextInt(5);
        this.positionStudent = new Elements<>(8, randomY);
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
}
