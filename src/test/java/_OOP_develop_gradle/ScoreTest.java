package _OOP_develop_gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*import static org.junit.Assert.assertEquals;
import org.junit.Before;
import javafx.scene.control.Label;
import org.junit.Test;*/
import _OOP_develop_gradle.model.Score;

public class ScoreTest {

    private Score score = new Score();;
    @Test
    public void testGetScore() {
        assertEquals(0, score.getScore());
    }

    @Test
    public void testSetScore() {
        score.setScore(50);
        assertEquals(50, score.getScore());
    }

    @Test
    public void testAddScore() {
        score.addScore();
        assertEquals(100, score.getScore());
    }

    @Test
    public void testResetScore() {
        score.setScore(50);
        score.resetScore();
        assertEquals(0, score.getScore());
    }
}

