package oopdevelopgradle.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ScoreTest {

    private final Score score = new Score();
    @Test
    void testGetScore() {
        assertEquals(0, score.getScore());
    }


    @Test
    void testAddScore() {
        score.addScore();
        assertEquals(100, score.getScore());
    }

    @Test
    void testResetScore() {
        score.addScore();
        score.resetScore();
        assertEquals(0, score.getScore());
    }
}

