package _OOP_develop_gradle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Professor {

	private ProfessorView ProfessorView;
	private int costProfessor;
	private int damage;
	private final Elements<Integer, Integer> position;
	private double healthPoints;
	private String pathImg;
	private boolean hitted = false;

	public Professor(int damage, double healthPoints, Elements<Integer, Integer> position, String pathImg, int costProfessor) {
		this.damage = damage;
		this.healthPoints = healthPoints;
		this.position = position;
		this.pathImg = pathImg;
		this.costProfessor = costProfessor;
	}

	/*
	 * private ImageView createImageView() { ImageView image = new ImageView(new
	 * Image(path)); image.setFitWidth(50); // Imposta la larghezza desiderata
	 * image.setFitHeight(50); // Imposta l'altezza desiderata return image; }
	 */
	// Metodo per ottenere l'ImageView della pianta
    public ImageView getImageProf(Professor prof) {
    	ImageView profImg = new ImageView();
    	profImg.setImage(new Image(getClass().getResource(prof.getPathImg()).toString()));
		return profImg;
    }

	public String getPathImg() {
		return pathImg;
	}
	
	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public boolean performAttack(Pane pane) {
		// Implementa la logica di attacco qui
		return false;
		
	}

	public double getHealthPoints() {
		return healthPoints;
	}

	
	 public void setHealthPoints(int healthPoints) 
	 { 
		 this.healthPoints = healthPoints; 
	 }
	 

	/*
	 * private void removeProfessorFromGrid() { // Implementa la logica di rimozione
	 * dalla griglia qui imageView.setVisible(false); imageView.setDisable(true); }
	 */
	public int getcostProfessor() {
		return costProfessor;
	}
	
	public void setcostProfessor(int costProfessor) {
		this.costProfessor = costProfessor;
	}


	/*
	 * Ti restituisce danno che il prf causa 
	 */
	public double getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Elements<Integer, Integer> getPosition() {
		return position;
	}

	public boolean isAlive() {
		return healthPoints > 0;
	}
	
	/*
	 * Quando prof riceve un danno
	 */
	public void receiveDamage(double damageReceived) {
		healthPoints -= damageReceived;
		if (healthPoints <= 0) {
			destroy();
		}
	}
	
	public boolean hittedProfessor() {
		if (hitted == true) {
			return true;
		}
		return false;
	}

	private void destroy() {
		// TODO Auto-generated method stub
		
	}
}
