package oopdevelopgradle.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StudentTest {
    private final Student student = new Student();

    @Test
    void testDefaultHealth() {
        assertEquals(100, student.getHealthStudent());
    }

    @Test
    void testDefaultEnergy() {
        assertEquals(10, student.getEnergy());
    }
    @Test
    void testAccessors() {
        student.setHealthStudent(80);
        student.setEnergy(20);
        assertEquals(80, student.getHealthStudent());
        assertEquals(20, student.getEnergy());
    }

    @Test
    void testDefaultValues() {
        assertEquals(25, student.getDamage());
        assertEquals(100, student.getHealthStudent());
        assertEquals(10, student.getEnergy());
        //final Elements<Integer, Integer> position = student.getPosition();
        //assertTrue(position.getX() >= 0 && position.getX() < 5); //???
    }
}
