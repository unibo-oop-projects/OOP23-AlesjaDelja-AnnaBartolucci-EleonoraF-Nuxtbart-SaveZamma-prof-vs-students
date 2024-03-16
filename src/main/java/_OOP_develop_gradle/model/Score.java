package _OOP_develop_gradle.model;

import javafx.scene.control.Label;

public class Score implements ScoreInterface {
    
    private static final int DEFAULT_RESET = 0;
    private static final int DEFAULT_SCORE = 100;
    private int score;
    
    @Override
    public int getScore() {
        return score;
    }
    
    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void addScore() {
        this.score += DEFAULT_SCORE;
    }

    @Override
    public void updateScore(Label scoreLabel) {
        scoreLabel.setText("Score: " + score);
    }

    @Override
    public void resetScore() {
        this.score = DEFAULT_RESET;
    }
}
