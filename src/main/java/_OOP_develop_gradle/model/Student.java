package _OOP_develop_gradle.model;

public class Student {
	private int health;
	private int damage;
	
	//Costruttore
	public Student(int health , int damage) {
		this.health = health;
		this.damage = damage;
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
		if (health <= 0) {
			destroyStudents();
		}
	}
}
