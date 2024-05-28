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
    /**
     * Sets up a new instance of {@link Professor} before each test method.
     */
    @BeforeEach
    void setUp() {
        professor = new Professor(20, 100, new Elements<>(1, 1), 50);
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
        assertEquals(100, professor.getHealthPointsProf());
    }

    /**
     * Test case for the {@link Professor#setHealthPointsProf(int)} method.
     * It checks if the professor's health points can be set correctly.
     */
    @Test
    void testSetHealthPointsProf() {
        final int newHealthPoints = 80;
        professor.setHealthPointsProf(newHealthPoints);
        assertEquals(newHealthPoints, professor.getHealthPointsProf());
    }

    /**
     * Test case for the {@link Professor#getEnergyProfessor()} method.
     * It verifies if the professor's energy level is initialized correctly.
     */
    @Test
    void testGetEnergyProfessor() {
        assertEquals(50, professor.getEnergyProfessor());
    }

    /**
     * Test case for the {@link Professor#setEnergyProfessor(int)} method.
     * It checks if the professor's energy level can be set correctly.
     */
    @Test
    void testSetEnergyProfessor() {
       final int newEnergy = 60;
        professor.setEnergyProfessor(newEnergy);
        assertEquals(newEnergy, professor.getEnergyProfessor());
    }

    /**
     * Test case for the {@link Professor#getDamageProf()} method.
     * It verifies if the professor's damage value is initialized correctly.
     */
    @Test
    void testGetDamageProf() {
        assertEquals(20, professor.getDamageProf());
    }

    /**
     * Test case for the {@link Professor#setDamageProf(int)} method.
     * It checks if the professor's damage value can be set correctly.
     */
    @Test
    void testSetDamageProf() {
        final int newDamage = 30;
        professor.setDamageProf(newDamage);
        assertEquals(newDamage, professor.getDamageProf());
    }

    /**
     * Test case for the {@link Professor#getPositionProf()} method.
     * It verifies if the professor's position is initialized correctly.
     */
    @Test
    void testGetPositionProf() {
        assertEquals(new Elements<>(1, 1), professor.getPositionProf());
    }

    /**
     * Test case for the {@link Professor#receiveDamageProf(int)} method.
     * It checks if the professor's health points are updated correctly when receiving damage.
     */
    @Test
    void testReceiveDamageProf() {
       final int initialHealth = professor.getHealthPointsProf();
       final int damageReceived = 10;
        professor.receiveDamageProf(damageReceived);
        assertEquals(initialHealth - damageReceived, professor.getHealthPointsProf());
    }
}
