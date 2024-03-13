package _OOP_develop_gradle.model;

public class Score {

	private int DEFAULT_SCORE = 100;

	/**
	 * Add the score when a students dies
	 * @param score The score at the moment
	 * @return The new Score after the student is Killed
	 */
	
	public int addScore(int score) { 
		int newScore = score + DEFAULT_SCORE;
		return newScore;
	}
}
