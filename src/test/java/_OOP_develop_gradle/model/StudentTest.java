package _OOP_develop_gradle.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student = new Student();

    @Test
    public void testDefaultHealth() {
        assertEquals(100, student.getHealthStudent());
    }

    @Test
    public void testDefaultEnergy() {
        assertEquals(10, student.getEnergy());
    }
    
    @Test
    public void testAccessors() {
        student.setHealthStudent(80);
        student.setEnergy(20);
        assertEquals(80, student.getHealthStudent());
        assertEquals(20, student.getEnergy());
    }

    
    public void testDefaultValues() {
        assertEquals(20, student.getDamage());
        assertEquals(10, student.getHealthStudent());
        assertEquals(10, student.getEnergy());
        Elements<Integer, Integer> position = student.getPosition();
        assertTrue(position.getX() >= 0 && position.getX() < 5);
    }
}

