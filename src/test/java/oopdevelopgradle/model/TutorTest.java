package oopdevelopgradle.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the {@link Tutor} class.
 */
class TutorTest {
    private Tutor tutor;
    /**
     * Sets up a new instance of {@link Tutor} before each test method.
     */
    @BeforeEach
    void setUp() {
        tutor = new Tutor(1, 1);
    }

    /**
     * Test case for the {@link Tutor#getTutorBullet()} method.
     * It checks if the Tutor's bullet is not null.
     */
    @Test
    void testGetTutorBullet() {
        assertNotNull(tutor.getTutorBullet());
    }
    /**
     * Test case for the {@link Tutor#getBulletSpeed()} method.
     * It checks if the Tutor's bullet speed is initialized correctly.
     */
    @Test
    void testGetBulletSpeed() {
        assertEquals(1, tutor.getBulletSpeed());
    }

    /**
     * Test case for the {@link Tutor#setBulletSpeed(int)} method.
     * It verifies if the Tutor's bullet speed can be set correctly.
     */
    @Test
    void testSetBulletSpeed() {
        final int newSpeed = 2;
        tutor.setBulletSpeed(newSpeed);
        assertEquals(newSpeed, tutor.getBulletSpeed());
    }
}
