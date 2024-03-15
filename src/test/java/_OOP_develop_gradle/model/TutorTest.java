package _OOP_develop_gradle.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TutorTest {

	//private Tutor tutor;

	private Tutor tutor = new Tutor(0, 0); // Passa le coordinate iniziali
    

    @Test
    public void testConstructor() {
        // Verifica che il costruttore inizializzi correttamente il tutor
        assertNotNull(tutor);
        assertEquals(Tutor.TUTOR_HIT_DAMAGE, tutor.getDamageProf());
        assertEquals(Tutor.TUTOR_HEALTHPOINTS, tutor.getHealthPointsProf());
        assertEquals(new Elements<>(0, 0), tutor.getPositionProf());
        assertEquals(Tutor.TUTOR_IMG_PATH, tutor.getPathImgProf());
        assertEquals(Tutor.TUTOR_BUY_COST, tutor.getCostProfessor());
        assertEquals(Tutor.tutorName, tutor.getTutorname());
        assertNotNull(tutor.getTutorBullet());
        assertEquals(1, tutor.getBulletSpeed());
        assertEquals(Tutor.tutorBulletName, tutor.getTutorbulletname());
    }

    @Test
    public void testBulletProperties() {
        // Verifica le proprietà del bullet del tutor
        Bullet bullet = tutor.getTutorBullet();
        assertNotNull(bullet);
        assertEquals(Tutor.TUTOR_HIT_DAMAGE, bullet.getBulletDamage());
        assertEquals(new Elements<>(0, 0), bullet.getPosition());
        assertEquals(Tutor.tutorBulletName, bullet.getBulletName());
        assertEquals(1, bullet.getBulletSpeed());
    }
}
