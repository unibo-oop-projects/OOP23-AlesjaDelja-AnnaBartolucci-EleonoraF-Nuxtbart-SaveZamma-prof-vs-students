package _OOP_develop_gradle.model;

import javafx.scene.control.Label;

public interface ScoreInterface {

    /**
     * Getter for the score.
     * @return the current score
     */
    int getScore();

    /**
     * Sets the score.
     * @param score the new score to set
     */
    void setScore(int score);

    /**
     * Adds the score to the current score.
     */
    void addScore();

    /**
     * Updates the score.
     * @param scoreLabel the label that needs to be updated with the score
     */
    void updateScore(Label scoreLabel);

    /**
     * Resets the score to a default number.
     */
    void resetScore();
}
