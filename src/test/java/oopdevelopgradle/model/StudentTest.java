package oopdevelopgradle.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentTest {
    private final Student student = new Student();
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_ENERGY = 10;
    private static final int HEALTH1 = 80;
    private static final int ENERGY1 = 20;
    private static final int DEMAGE = 25;
    private static final int MAX_WI = 5;

    @Test
    void testDefaultHealth() {
        assertEquals(DEFAULT_HEALTH, student.getHealthStudent());
    }

    @Test
    void testDefaultEnergy() {
        assertEquals(DEFAULT_ENERGY, student.getEnergy());
    }
    @Test
    void testAccessors() {
        student.setHealthStudent(HEALTH1);
        student.setEnergy(ENERGY1);
        assertEquals(HEALTH1, student.getHealthStudent());
        assertEquals(ENERGY1, student.getEnergy());
    }

    @Test
    void testDefaultValues() {
        assertEquals(DEMAGE, student.getDamage());
        assertEquals(DEFAULT_HEALTH, student.getHealthStudent());
        assertEquals(DEFAULT_ENERGY, student.getEnergy());
        student.generateRandomPosition();       
        final Elements<Integer, Integer> position = student.getPosition();
        assertTrue(position.getX() >= 0 && position.getX() < MAX_WI); //???
    }
}
