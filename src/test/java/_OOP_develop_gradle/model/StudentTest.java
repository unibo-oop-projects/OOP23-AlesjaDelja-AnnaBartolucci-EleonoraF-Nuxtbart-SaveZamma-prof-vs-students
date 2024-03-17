package _OOP_develop_gradle.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StudentTest {
    private Student student = new Student();
    private static int DEFAULT_DAMAGE =  25;
    private static int DEFAULT_HEALTH =  100;
    private static int DEFAULT_ENERGY = 10;
    private static int DEFAULT_ROW = 5;

    @Test
    public void testDefaultHealth() {
        assertEquals(100, student.getHealthStudent());
    }

    @Test
    public void testDefaultEnergy() {
        assertEquals(10, student.getEnergy());
    }

    @Test
    public void testGenerateRandomPosition() {
        student.generateRandomPosition();
        Elements<Integer, Integer> position = student.getPosition();
        assertTrue(position.getX() >= 0 && position.getX() < 5);
    }

    @Test
    public void testTakeDamageStudentsNegative() {
        int healthBefore = student.getHealthStudent();
        student.takeDamageStudents(-10);
        assertEquals(healthBefore, student.getHealthStudent());
    }

    @Test
    public void testTakeDamageStudentsExceedHealth() {
        student.takeDamageStudents(150);
        assertEquals(0, student.getHealthStudent());
    }

    @Test
    public void testAccessors() {
        student.setHealthStudent(80);
        student.setEnergy(20);
        assertEquals(80, student.getHealthStudent());
        assertEquals(20, student.getEnergy());
    }

    @Test
    public void testDefaultValues() {
        assertEquals(DEFAULT_DAMAGE, student.getDamage());
        assertEquals(DEFAULT_HEALTH, student.getHealthStudent());
        assertEquals(DEFAULT_ENERGY, student.getEnergy());
        Elements<Integer, Integer> position = student.getPosition();
        assertTrue(position.getX() >= 0 && position.getX() < DEFAULT_ROW);
    }
}

