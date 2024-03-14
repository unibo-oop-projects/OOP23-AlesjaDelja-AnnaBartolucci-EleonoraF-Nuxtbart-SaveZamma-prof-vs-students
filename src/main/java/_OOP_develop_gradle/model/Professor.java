package _OOP_develop_gradle.model;

import _OOP_develop_gradle.Elements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Professor {
	
	private int costProfessor;
	private int damage;
	private final Elements<Integer, Integer> position;
	private double healthPoints;
	public String pathImgP;
	public int id;
	
	//Costructor
	public Professor(int damage, double healthPoints, Elements<Integer, Integer> position, String pathImgP, int costProfessor, int id) {
		this.damage = damage;
		this.healthPoints = healthPoints;
		this.position = position;
		this.pathImgP = pathImgP;
		this.costProfessor = costProfessor;
		this.id = id;
	}

	public String getPathImgProf() {
		return pathImgP;
	}
	
	public void setPathImgProf(String pathImg) {
		this.pathImgP = pathImg;
	}

	/**
	 * Gets the healthpoints of a professor
	 * @return the healthpoints of the professor
	 */
	public double getHealthPointsProf() {
		return healthPoints;
	}

	/**
	 * Sets the healthpoints of a professor
	 * @param the healthpoints value of the professor
	 */
	 public void setHealthPointsProf(int healthPoints) 
	 { 
		 this.healthPoints = healthPoints; 
	 }
	 
	public int getcostProfessor() {
		return costProfessor;
	}
	
	public void setcostProfessor(int costProfessor) {
		this.costProfessor = costProfessor;
	}


	/**
	 * Gets the damage of a professor
	 * @return the damage of the professor
	 */
	public int getDamageProf() {
		return damage;
	}
	
	/**
	 * Sets the damage of a professor
	 * @param the damage of the professor
	 */
	public void setDamagProf (int damage) {
		this.damage = damage;
	}

	/**
	 * Gets the position of the professors
	 * @return the current position of the professors
	 */
	public Elements<Integer, Integer> getPositionProf() {
		return position;
	}

	/**
	 * Check if the professor is still alive
	 * @return true if is alive, false if is not
	 */
	public boolean isAliveProf() {
		return healthPoints > 0;
	}
	
	/**
	 * Updates the health when he gets attacked by a student.
	 * If the health is less or equal to 0 then the students is destroyed.
	 * @param damageReceived Value of the damage of the student.
	 */
	public void receiveDamageProf(double damageReceived) {
		healthPoints -= damageReceived;
	}
	
	/**
	 * Gets the id of a professor
	 * @return the id of a prof
	 */
	public int getIDProf() {
		return id;
	}

}
