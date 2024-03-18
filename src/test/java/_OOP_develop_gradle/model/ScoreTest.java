package _OOP_develop_gradle.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    private Score score = new Score();;
    @Test
    public void testGetScore() {
        assertEquals(0, score.getScore());
    }


    @Test
    public void testAddScore() {
        score.addScore();
        assertEquals(100, score.getScore());
    }

    @Test
    public void testResetScore() {
        score.addScore();
        score.resetScore();
        assertEquals(0, score.getScore());
    }
}

