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
        gameModel.increaseEnergy(50);
        assertEquals(150, gameModel.getEnergy());
        assertTrue(gameModel.decreaseEnergy(70));
        assertEquals(80, gameModel.getEnergy());
        assertFalse(gameModel.decreaseEnergy(100)); // Trying to decrease more energy than available
        assertEquals(80, gameModel.getEnergy()); // Energy should remain unchanged
    }
	
	@Test
    void testDecreaseANDIncreaseTimeTot() {
		gameModel.setTimeTot(100);
        assertEquals(100, gameModel.getTimeTot());
        gameModel.increaseTimeTot(50);
        assertEquals(150, gameModel.getTimeTot());
        assertTrue(gameModel.decreaseTimeTot(70));
        assertEquals(80, gameModel.getTimeTot());
        assertFalse(gameModel.decreaseTimeTot(100)); // Trying to decrease more time than available
        assertEquals(80, gameModel.getTimeTot()); // Time should remain unchanged
    }
	
	 @Test
	 void testGenerateWaveAndStudents() {
		 gameModel.generateWave(5);
	        final List<Student> students = gameModel.getStudentList();
	        assertEquals(5, students.size());
	        gameModel.generateNewStudent();
	        assertEquals(6, students.size());
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
