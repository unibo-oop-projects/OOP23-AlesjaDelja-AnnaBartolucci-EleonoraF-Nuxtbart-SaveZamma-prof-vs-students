package _OOP_develop_gradle.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TutorTest {

	//private Tutor tutor;

	private Tutor tutor = new Tutor(0, 0); // Passa le coordinate iniziali
    

	 @Test
	    public void testConstructor() {
	        // Verifica che il costruttore inizializzi correttamente il Tutor
	        assertNotNull(tutor);
	        assertEquals(25, tutor.getDamageProf());
	        assertEquals(100, tutor.getHealthPointsProf());
	        assertEquals(10, tutor.getEnergyProfessor());
	        assertEquals(1, tutor.getBulletSpeed());
	        assertNotNull(tutor.getTutorBullet());
	    }

	    @Test
	    public void testSetTutorBullet() {
	        // Verifica che il metodo setTutorBullet imposti correttamente il Bullet del Tutor
	        Bullet bullet = new Bullet(2, 30, new Elements<>(1, 1));
	        tutor.setTutorBullet(bullet);
	        assertEquals(bullet, tutor.getTutorBullet());
	    }

	    @Test
	    public void testSetBulletSpeed() {
	        // Verifica che il metodo setBulletSpeed imposti correttamente la velocità del Bullet del Tutor
	        tutor.setBulletSpeed(2);
	        assertEquals(2, tutor.getBulletSpeed());
	    }
}
