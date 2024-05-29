package oopdevelopgradle.model;
/**
 * ScoreInterface is an interface for the score of the game.
 */
public interface ScoreInterface {

    /**
     * Getter for the score.
     * @return the current score
     */
    int getScore();

    /**
     * Adds the score to the current score.
     */
    void addScore();


    /**
     * Resets the score to a default number.
     */
    void resetScore();
}
