package _OOP_develop_gradle.model;

import javafx.scene.control.Label;

public class Score {
	
	private static final int DEFAULT_RESET = 0;
	private static final int DEFAULT_SCORE = 100;
	private int score;
	

	

	/**
	 * Getter of score
	 * @return the current score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score
	 * @param score Sets the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Adds the score to the current one and updates the label with the new Score
	 * @param scoreLabel The label that needs to be updated
	 */
	
	public void addScore(Label scoreLabel) { 
		this.score = score +  DEFAULT_SCORE;
		updateScore(scoreLabel);
	}
	
	/**
	 * Updates the score
	 * @param scoreLabel The label that needs to be updated
	 */
	public void updateScore(Label scoreLabel) {
		scoreLabel.setText("Score: " + score);
	}
	public void resetScore() {
		this.score = DEFAULT_RESET;
	}
}
