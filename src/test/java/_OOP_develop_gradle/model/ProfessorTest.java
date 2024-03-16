package _OOP_develop_gradle.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProfessorTest {

	Elements<Integer, Integer> position= new Elements<>(0, 0);
    Professor professor = new Professor(50, 100, new Elements<>(0, 0), 10);
    

    @Test
    public void testConstructor() {
        // Verifica che il costruttore inizializzi correttamente il Professor
        assertNotNull(professor);
        assertEquals(50, professor.getDamageProf());
        assertEquals(100, professor.getHealthPointsProf());
        assertEquals(new Elements<>(0, 0), professor.getPositionProf());
        assertEquals(10, professor.getEnergyProfessor());
        assertFalse(professor.isAttacked());
    }

    @Test
    public void testReceiveDamageProf() {
        // Verifica che il metodo receiveDamageProf sottragga correttamente i danni dai punti vita del professor
        assertEquals(100, professor.getHealthPointsProf());
        professor.receiveDamageProf(25);
        assertEquals(75, professor.getHealthPointsProf());
    }

    @Test
    public void testSetAttacked() {
        // Verifica che il metodo setAttacked imposti correttamente lo stato del professor
        assertFalse(professor.isAttacked());
        professor.setAttacked(true);
        assertTrue(professor.isAttacked());
    }

    @Test
    public void testSetHealthPointsProf() {
        // Verifica che il metodo setHealthPointsProf imposti correttamente i punti vita del professor
        assertEquals(100, professor.getHealthPointsProf());
        professor.setHealthPointsProf(80);
        assertEquals(80, professor.getHealthPointsProf());
    }

    @Test
    public void testSetEnergyProfessor() {
        // Verifica che il metodo setEnergyProfessor imposti correttamente l'energia del professor
        assertEquals(10, professor.getEnergyProfessor());
        professor.setEnergyProfessor(15);
        assertEquals(15, professor.getEnergyProfessor());
    }

    @Test
    public void testSetDamageProf() {
        // Verifica che il metodo setDamageProf imposti correttamente i danni del professor
        assertEquals(50, professor.getDamageProf());
        professor.setDamageProf(60);
        assertEquals(60, professor.getDamageProf());
    }
}
