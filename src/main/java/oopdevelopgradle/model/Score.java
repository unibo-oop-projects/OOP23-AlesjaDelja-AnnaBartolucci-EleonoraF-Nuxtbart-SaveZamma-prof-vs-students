package oopdevelopgradle.model;
/**
 * Score is a class that implements the features of the score in the game.
 */
public final class Score implements ScoreInterface {
    private static final int DEFAULT_RESET = 0;
    private static final int DEFAULT_SCORE = 100;
    private int scoreGame;
    @Override
    public int getScore() {
        return scoreGame;
    }
    @Override
    public void addScore() {
        this.scoreGame += DEFAULT_SCORE;
    }
    @Override
    public void resetScore() {
        this.scoreGame = DEFAULT_RESET;
    }
}
