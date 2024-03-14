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
	 * Adds the score to the current one.
	 */
	
	public void addScore() { 
		this.score = score +  DEFAULT_SCORE;
	}
	
	/**
	 * Updates the score
	 * @param scoreLabel The label that needs to be updated
	 */
	public void updateScore(Label scoreLabel) {
		scoreLabel.setText("Score: " + score);
	}
	/**
	 * Resets the score to a dafault number
	 */
	public void resetScore() {
		this.score = DEFAULT_RESET;
	}
}
