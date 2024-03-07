package application;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import application.GamePlayController;

public class Professor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private ProfessorView plantView;
	
	public int sunUse;
	
	private final int buyThreshold; // Constant cost value for different plants 
	private int hitThreshold; // Maximum hits a plant can take before it is dead
	private int xPos; // Grid position x
	private int yPos; // Grid position y
	private int healthPoints;
    GamePlayModel gameplay;
    private ImageView imageView;
    private String path;
   

    public Professor(String path, int hitThreshold, int buyThreshold, int x, int y, int healthPoints) {
        this.healthPoints = healthPoints;
        this.gameplay = gameplay;
        this.sunUse = sunUse;
        this.path = path;
        this.buyThreshold = buyThreshold;
		this.hitThreshold = hitThreshold;
		this.setxPos(x);
		this.setyPos(y);
		
		//this.imageView = createImageView();
		plantView = new ProfessorView(path);
    }

	/*
	 * private ImageView createImageView() { ImageView image = new ImageView(new
	 * Image(path)); image.setFitWidth(50); // Imposta la larghezza desiderata
	 * image.setFitHeight(50); // Imposta l'altezza desiderata return image; }
	 */

    public void addToGrid(GridPane grid) {
        grid.add(plantView, xPos, yPos, 1, 1);
    }

    public void performAttack(Pane pane) {
        // Implementa la logica di attacco qui
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
        if (this.healthPoints <= 0) {
            removeProfessorFromGrid();
        }
    }

    public void endAnimation(Timeline timeline) {
        timeline.stop();
    }

    private void removeProfessorFromGrid() {
        // Implementa la logica di rimozione dalla griglia qui
        imageView.setVisible(false);
        imageView.setDisable(true);
    }
    
  //getter
    public GamePlayModel getGamePlay() {
        return gameplay;
    }
    public int getSunUse() {
        return sunUse;
    }
    
    /**
	 * Returns Plant's sunflower cost.
	 * @return plant cost in sunflower
	 */
	public int getBuyThreshold() {
		return buyThreshold;
	}

	/**
	 * Health points or maximum hits plants 
	 * can take within a game level.
	 * @return plant maximum hitThreshold before plant dies
	 */
	public int getHitThreshold() {
		return hitThreshold;
	}

	/**
	 * Sets the current health of a plant.
	 * @param currentHP Updates plants health points 
	 * or the current hit count
	 */
	public void setHitThreshold(int currentHP) {
		this.hitThreshold = currentHP;
	}
	
	
    /**
	 * Checks if current bought plants are alive.
	 * @return true if the plant is dead false if it is still alive
	 */
	public boolean isPlantDead() {
		if (getHitThreshold() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return x position
	 */
	public int getxPos() {
		return xPos;
	}
	
	/**
	 * @return y position
	 */
	public int getyPos() {
		return yPos;
	}
	
	/**
	 * @param xPos set x to this position 
	 */
	public void setxPos(int xPos) {
		if (xPos >= 0 && xPos <= 8) {
			this.xPos = xPos;
		}	
	}
	
	/**
	 * @param yPos set y to this position
	 */
	public void setyPos(int yPos) {
		if (yPos >= 0 && yPos <= 4) {
			this.yPos = yPos;
		}
	}
	
	/*
	 * public Professor clone() throws CloneNotSupportedException { return
	 * (Professor) super.clone(); }
	 */
	
}
