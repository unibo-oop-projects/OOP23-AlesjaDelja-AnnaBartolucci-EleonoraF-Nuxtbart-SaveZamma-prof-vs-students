package oopdevelopgradle.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Test class for the {@link Professor} class.
 */
class ProfessorTest {
    private Professor professor;
    private static final int DAMAGE = 20;
    private static final int HEALTH_POINT = 100;
    private static final int ENERGY = 50;
    private static final int X = 1;
    private static final int Y = 1;
    private static final int NEW_HEALTH_POINT = 80;
    private static final int NEW_ENERGY = 60;
    private static final int NEW_DAMAGE = 30;
    private static final int DAMAGE_RECEIVED = 10;
    /**
     * Sets up a new instance of {@link Professor} before each test method.
     */
    @BeforeEach
    void setUp() {
        professor = new Professor(DAMAGE, HEALTH_POINT, new Elements<>(X, Y), ENERGY);
    }

    /**
     * Test case for the {@link Professor#isAttacked()} method.
     * It verifies if the professor is initially not attacked.
     */
    @Test
    void testIsAttacked() {
        assertFalse(professor.isAttacked());
    }

    /**
     * Test case for the {@link Professor#setAttacked(boolean)} method.
     * It checks if the professor's attacked status can be set correctly.
     */
    @Test
    void testSetAttacked() {
        professor.setAttacked(true);
        assertTrue(professor.isAttacked());
    }

    /**
     * Test case for the {@link Professor#getHealthPointsProf()} method.
     * It verifies if the professor's health points are initialized correctly.
     */
    @Test
    void testGetHealthPointsProf() {
        assertEquals(HEALTH_POINT, professor.getHealthPointsProf());
    }

    /**
     * Test case for the {@link Professor#setHealthPointsProf(int)} method.
     * It checks if the professor's health points can be set correctly.
     */
    @Test
    void testSetHealthPointsProf() {
        professor.setHealthPointsProf(NEW_HEALTH_POINT);
        assertEquals(NEW_HEALTH_POINT, professor.getHealthPointsProf());
    }

    /**
     * Test case for the {@link Professor#getEnergyProfessor()} method.
     * It verifies if the professor's energy level is initialized correctly.
     */
    @Test
    void testGetEnergyProfessor() {
        assertEquals(ENERGY, professor.getEnergyProfessor());
    }

    /**
     * Test case for the {@link Professor#setEnergyProfessor(int)} method.
     * It checks if the professor's energy level can be set correctly.
     */
    @Test
    void testSetEnergyProfessor() {
        professor.setEnergyProfessor(NEW_ENERGY);
        assertEquals(NEW_ENERGY, professor.getEnergyProfessor());
    }

    /**
     * Test case for the {@link Professor#getDamageProf()} method.
     * It verifies if the professor's damage value is initialized correctly.
     */
    @Test
    void testGetDamageProf() {
        assertEquals(DAMAGE, professor.getDamageProf());
    }

    /**
     * Test case for the {@link Professor#setDamageProf(int)} method.
     * It checks if the professor's damage value can be set correctly.
     */
    @Test
    void testSetDamageProf() {
        professor.setDamageProf(NEW_DAMAGE);
        assertEquals(NEW_DAMAGE, professor.getDamageProf());
    }

    /**
     * Test case for the {@link Professor#getPositionProf()} method.
     * It verifies if the professor's position is initialized correctly.
     */
    @Test
    void testGetPositionProf() {
        assertEquals(new Elements<>(X, Y), professor.getPositionProf());
    }

    /**
     * Test case for the {@link Professor#receiveDamageProf(int)} method.
     * It checks if the professor's health points are updated correctly when receiving damage.
     */
    @Test
    void testReceiveDamageProf() {
       final int initialHealth = professor.getHealthPointsProf();
        professor.receiveDamageProf(DAMAGE_RECEIVED);
        assertEquals(initialHealth - DAMAGE_RECEIVED, professor.getHealthPointsProf());
    }
}
