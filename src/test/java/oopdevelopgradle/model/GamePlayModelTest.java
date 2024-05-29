package oopdevelopgradle.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

/**
 * This class contains the test for the GamePlayModel.
 */

class GamePlayModelTest {
	private final GamePlayModel gameModel = new GamePlayModel();
	private static final int INIT = 0;
	private static final int INIT_ENERGY = 100;
	private static final int INIT_TIME = 100;
	private static final int TIME1 = 150;
	private static final int TIME2 = 80;
	private static final int ENERGY1 = 150;
	private static final int ENERGY2 = 80;
	private static final int INCREASE1 = 50;
	private static final int DECREASE1 = 70;
	private static final int DECREASE2 = 100;
	private static final int NUM_STUD = 5;
	private static final int NEW_NUM_STUD = 6;
	@Test
    void testInitialValues() {
        assertEquals(INIT, gameModel.getScoreMacth());
        assertEquals(INIT, gameModel.getEnergy());
        assertEquals(INIT, gameModel.getTimeTot());
        assertTrue(gameModel.getStudentList().isEmpty());
        assertTrue(gameModel.getTutorList().isEmpty());
        assertTrue(gameModel.getNormalProfList().isEmpty());
        assertTrue(gameModel.getRectorList().isEmpty());
        assertTrue(gameModel.getBulletListNormal().isEmpty());
        assertTrue(gameModel.getBulletListDiagonal().isEmpty());
    }
	
	
	@Test
    void testDecreaseANDIncreaseEnergy() {
		gameModel.setEnergy(INIT_ENERGY);
        assertEquals(INIT_ENERGY, gameModel.getEnergy());
        gameModel.increaseEnergy(INCREASE1);
        assertEquals(ENERGY1, gameModel.getEnergy());
        assertTrue(gameModel.decreaseEnergy(DECREASE1));
        assertEquals(ENERGY2, gameModel.getEnergy());
        assertFalse(gameModel.decreaseEnergy(DECREASE2)); // Trying to decrease more energy than available
        assertEquals(ENERGY2, gameModel.getEnergy()); // Energy should remain unchanged
    }
	
	@Test
    void testDecreaseANDIncreaseTimeTot() {
		gameModel.setTimeTot(INIT_TIME);
        assertEquals(INIT_TIME, gameModel.getTimeTot());
        gameModel.increaseTimeTot(INCREASE1);
        assertEquals(TIME1, gameModel.getTimeTot());
        assertTrue(gameModel.decreaseTimeTot(DECREASE1));
        assertEquals(TIME2, gameModel.getTimeTot());
        assertFalse(gameModel.decreaseTimeTot(DECREASE2)); // Trying to decrease more time than available
        assertEquals(TIME2, gameModel.getTimeTot()); // Time should remain unchanged
    }
	
	 @Test
	 void testGenerateWaveAndStudents() {
		 gameModel.generateWave(NUM_STUD);
	        final List<Student> students = gameModel.getStudentList();
	        assertEquals(NUM_STUD, students.size());
	        gameModel.generateNewStudent();
	        assertEquals(NEW_NUM_STUD, students.size());
	    }
	 @Test
	 void testGenerateTutor() {
	        final Tutor tutor = gameModel.generateNewTutor(new Elements<>(1, 1));
	        final List<Tutor> tutors = gameModel.getTutorList();
	        assertEquals(1, tutors.size());
	        assertTrue(tutors.contains(tutor));
	    }

	 @Test
	 void testGenerateNormalProfessor() {
	        final NormalProfessor normalProfessor = 
	        		gameModel.generateNewNormalP(10, 100, new Elements<>(2, 2), "image.png", 50, 1);
	        final List<NormalProfessor> normalProfessors = gameModel.getNormalProfList();
	        assertEquals(1, normalProfessors.size());
	        assertTrue(normalProfessors.contains(normalProfessor));
	    }
	 @Test
	 void testGenerateRector() {
	        final Rector rector = gameModel.generateNewRector(new Elements<>(3, 3));
	        final List<Rector> rectors = gameModel.getRectorList();
	        assertEquals(1, rectors.size());
	        assertTrue(rectors.contains(rector));
	    }
	 @Test
	  void testBulletLists() {
	       final Bullet bullet1 = new Bullet(1, 10, new Elements<>(1, 3));
	       final Bullet bullet2 = new Bullet(2, 10, new Elements<>(2, 4));
	        gameModel.getBulletListNormal().add(bullet1);
	        gameModel.getBulletListDiagonal().add(bullet2);
	       final List<Bullet> bulletListNormal = gameModel.getBulletListNormal();
	       final List<Bullet> bulletListDiagonal = gameModel.getBulletListDiagonal();
	        assertEquals(1, bulletListNormal.size());
	        assertEquals(1, bulletListDiagonal.size());
	        assertTrue(bulletListNormal.contains(bullet1));
	        assertTrue(bulletListDiagonal.contains(bullet2));
	    }
}
