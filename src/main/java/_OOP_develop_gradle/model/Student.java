package _OOP_develop_gradle.model;

import java.util.Random;

import _OOP_develop_gradle.Elements;

public class Student {
	private int health;
	private int damage;
	private int DEFAULT_HEALTH = 100;
	private int DEFAULT_DAMAGE = 25;
	private final Elements<Integer, Integer> position;
	//Costruttore
	public Student() {
		this.position=getPosition();
		this.health = DEFAULT_HEALTH;
		this.damage = DEFAULT_DAMAGE;
	}
	
	/**
	 * Creates a new Students in the end of the grid in a random row
	 * @return the rows and colum of the student created
	 */
	
	private Elements<Integer, Integer> getPosition() {
		Random random = new Random();
	    int randomY = random.nextInt(7); // Genera un numero casuale tra 0 e 6 inclusi
	    return new Elements<>(0, randomY);
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
	
	public void destroyStudents() {
		//TO-DO Distruzione 
	}
	
	/**
	 * Updates the health when he gets attacked by a prof.
	 * If the health is less or equal to 0 then the students is destroyed.
	 * @param damageTaken Value of the damage of the prof.
	 */
	
	public void takeDamageStudents(int damageTaken) {
		health -= damageTaken;
	}
}
