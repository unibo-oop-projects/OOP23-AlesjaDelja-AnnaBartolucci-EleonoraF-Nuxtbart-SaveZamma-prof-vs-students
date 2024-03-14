import static org.junit.Assert.*;

import _OOP_develop_gradle.Elements;
import _OOP_develop_gradle.model.Professor;

import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {

    private Professor professor;

    @Before
    public void setUp() {
        // Crea un nuovo oggetto Professor per ogni test
        int damage = 50;
        double healthPoints = 100.0;
        Elements<Integer, Integer> position = new Elements<>(0, 0);
        String pathImgP = "img/professor.png";
        int costProfessor = 20;
        int id = 1;
        professor = new Professor(damage, healthPoints, position, pathImgP, costProfessor, id);
    }

    @Test
    public void testGetPathImgProf() {
        // Verifica se il metodo getPathImgProf restituisce il percorso corretto dell'immagine del professore
        assertEquals("img/professor.png", professor.getPathImgProf());
    }

    @Test
    public void testSetPathImgProf() {
        // Imposta un nuovo percorso immagine e verifica se viene memorizzato correttamente
        professor.setPathImgProf("new_image.png");
        assertEquals("new_image.png", professor.getPathImgProf());
    }

    @Test
    public void testGetHealthPointsProf() {
        // Verifica se il metodo getHealthPointsProf restituisce i punti vita corretti del professore
        assertEquals(100.0, professor.getHealthPointsProf(), 0.01);
    }

    @Test
    public void testSetHealthPointsProf() {
        // Imposta nuovi punti vita e verifica se vengono memorizzati correttamente
        professor.setHealthPointsProf(150);
        assertEquals(150.0, professor.getHealthPointsProf(), 0.01);
    }

    @Test
    public void testGetCostProfessor() {
        // Verifica se il metodo getCostProfessor restituisce il costo corretto del professore
        assertEquals(20, professor.getCostProfessor());
    }

    @Test
    public void testSetCostProfessor() {
        // Imposta un nuovo costo e verifica se viene memorizzato correttamente
        professor.setCostProfessor(25);
        assertEquals(25, professor.getCostProfessor());
    }

    @Test
    public void testGetDamageProf() {
        // Verifica se il metodo getDamageProf restituisce il danno corretto del professore
        assertEquals(50, professor.getDamageProf());
    }

    @Test
    public void testSetDamageProf() {
        // Imposta un nuovo danno e verifica se viene memorizzato correttamente
        professor.setDamageProf(60);
        assertEquals(60, professor.getDamageProf());
    }

    @Test
    public void testGetPositionProf() {
        // Verifica se il metodo getPositionProf restituisce la posizione corretta del professore
        assertEquals(new Elements<>(0, 0), professor.getPositionProf());
    }

    @Test
    public void testIsAliveProf() {
        // Verifica se il metodo isAliveProf restituisce correttamente lo stato di vita del professore
        assertTrue(professor.isAliveProf());
    }

    @Test
    public void testReceiveDamageProf() {
        // Simula l'attacco al professore e verifica se la salute viene ridotta correttamente
        professor.receiveDamageProf(30.0);
        assertEquals(70.0, professor.getHealthPointsProf(), 0.01);
    }

    @Test
    public void testGetIDProf() {
        // Verifica se il metodo getIDProf restituisce l'ID corretto del professore
        assertEquals(1, professor.getIDProf());
    }
}