package _OOP_develop_gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;

import _OOP_develop_gradle.model.Professor;

public class ProfessorTest {

    private Professor professor;
    private Elements<Integer, Integer> position;

    @Before
    public void setUp() {
        position = new Elements<>(0, 0);
        professor = new Professor(50, 100, position, "imagePath", 10, 1);
    }

    @Test
    public void testGetPathImgProf() {
        assertEquals("imagePath", professor.getPathImgProf());
    }

    @Test
    public void testSetPathImgProf() {
        professor.setPathImgProf("newImagePath");
        assertEquals("newImagePath", professor.getPathImgProf());
    }

    @Test
    public void testGetHealthPointsProf() {
        assertEquals(100, professor.getHealthPointsProf());
    }

    @Test
    public void testSetHealthPointsProf() {
        professor.setHealthPointsProf(150);
        assertEquals(150, professor.getHealthPointsProf());
    }

    @Test
    public void testGetCostProfessor() {
        assertEquals(10, professor.getCostProfessor());
    }

    @Test
    public void testSetCostProfessor() {
        professor.setCostProfessor(20);
        assertEquals(20, professor.getCostProfessor());
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
        assertEquals(position, professor.getPositionProf());
    }

    @Test
    public void testIsAliveProf() {
        assertTrue(professor.isAliveProf());
    }

    @Test
    public void testReceiveDamageProf() {
        professor.receiveDamageProf(20);
        assertEquals(80, professor.getHealthPointsProf());
    }

    @Test
    public void testGetIDProf() {
        assertEquals(1, professor.getIDProf());
    }
}
