package _OOP_develop_gradle.model;

import _OOP_develop_gradle.Elements;
import _OOP_develop_gradle.view.ProfessorView;
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

	public double getHealthPointsProf() {
		return healthPoints;
	}

	
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


	/*
	 * Ti restituisce danno che il prf causa 
	 */
	public int getDamageProf() {
		return damage;
	}
	
	public void setDamagProf (int damage) {
		this.damage = damage;
	}

	public Elements<Integer, Integer> getPositionProf() {
		return position;
	}

	public boolean isAliveProf() {
		return healthPoints > 0;
	}
	
	/*
	 * Quando prof riceve un danno
	 */
	public void receiveDamageProf(double damageReceived) {
		healthPoints -= damageReceived;
	}
	
	public int getIDProf() {
		return id;
	}

}
