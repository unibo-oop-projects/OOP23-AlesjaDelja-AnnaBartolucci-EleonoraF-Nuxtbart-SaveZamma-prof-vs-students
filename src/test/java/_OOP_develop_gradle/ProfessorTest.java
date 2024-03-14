import static org.junit.Assert.*;

import _OOP_develop_gradle.Elements;
import _OOP_develop_gradle.model.Professor;

import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {

    private Professor professor;

    @Before
    public void setUp() {
        // Creazione di un oggetto Professor per i test
        int damage = 50;
        double healthPoints = 100;
        Elements<Integer, Integer> position = new Elements<>(0, 0);
        String pathImgP = "professor.png";
        int costProfessor = 20;
        int id = 1;
        professor = new Professor(damage, healthPoints, position, pathImgP, costProfessor, id);
    }

    @Test
    public void testGetPathImgProf() {
        assertEquals("professor.png", professor.getPathImgProf());
    }

    @Test
    public void testSetPathImgProf() {
        professor.setPathImgProf("new_professor.png");
        assertEquals("new_professor.png", professor.getPathImgProf());
    }

    @Test
    public void testGetHealthPointsProf() {
        assertEquals(100, professor.getHealthPointsProf(), 0);
    }

    @Test
    public void testSetHealthPointsProf() {
        professor.setHealthPointsProf(150);
        assertEquals(150, professor.getHealthPointsProf(), 0);
    }

    @Test
    public void testGetCostProfessor() {
        assertEquals(20, professor.getCostProfessor());
    }

    @Test
    public void testSetCostProfessor() {
        professor.setCostProfessor(30);
        assertEquals(30, professor.getCostProfessor());
    }

    @Test
    public void testGetDamageProf() {
        assertEquals(50, professor.getDamageProf());
    }

    @Test
    public void testSetDamageProf() {
        professor.setDamageProf(60);
        assertEquals(60, professor.getDamageProf());
    }

    @Test
    public void testGetPositionProf() {
        Elements<Integer, Integer> position = professor.getPositionProf();
        assertEquals(0, (int) position.getX());
        assertEquals(0, (int) position.getY());
    }

    @Test
    public void testIsAliveProf() {
        assertTrue(professor.isAliveProf());
        professor.receiveDamageProf(120); // Danno superiore alla salute iniziale
        assertFalse(professor.isAliveProf());
    }

    @Test
    public void testReceiveDamageProf() {
        professor.receiveDamageProf(20);
        assertEquals(80, professor.getHealthPointsProf(), 0);
    }

    @Test
    public void testGetIDProf() {
        assertEquals(1, professor.getIDProf());
    }
}
