package _OOP_develop_gradle.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * This class contains the test for the GamePlayModel
 */

class GamePlayModelTest {
	
	GamePlayModel gameModel = new GamePlayModel();
	
	@Test
    public void testInitialValues() {
        assertEquals(0, gameModel.getScoreMacth());
        assertEquals(0, gameModel.getEnergy());
        assertEquals(0, gameModel.getTimeTot());
        assertTrue(gameModel.getStudentList().isEmpty());
        assertTrue(gameModel.getTutorList().isEmpty());
        assertTrue(gameModel.getNormalProfList().isEmpty());
        assertTrue(gameModel.getRectorList().isEmpty());
        assertTrue(gameModel.getBulletListNormal().isEmpty());
        assertTrue(gameModel.getBulletListDiagonal().isEmpty());
    }
	
	
	@Test
    public void testDecreaseANDIncreaseEnergy() {
		gameModel.setEnergy(100);
        assertEquals(100, gameModel.getEnergy());
        
        gameModel.increaseEnergy(50);
        assertEquals(150, gameModel.getEnergy());
        
        assertTrue(gameModel.decreaseEnergy(70));
        assertEquals(80, gameModel.getEnergy());
        
        assertFalse(gameModel.decreaseEnergy(100)); // Trying to decrease more energy than available
        assertEquals(80, gameModel.getEnergy()); // Energy should remain unchanged
    }
	
	@Test
    public void testDecreaseANDIncreaseTimeTot() {
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
	    public void testGenerateWaveAndStudents() {
		 gameModel.generateWave(5);
	        List<Student> students = gameModel.getStudentList();
	        assertEquals(5, students.size());
	        
	        gameModel.generateNewStudent();
	        assertEquals(6, students.size());
	    }
	 
	 @Test
	    public void testGenerateTutor() {
	        Tutor tutor = gameModel.generateNewTutor(new Elements<>(1, 1));
	        List<Tutor> tutors = gameModel.getTutorList();
	        assertEquals(1, tutors.size());
	        assertTrue(tutors.contains(tutor));
	    }
	 
	 @Test
	    public void testGenerateNormalProfessor() {
	        NormalProfessor normalProfessor = gameModel.generateNewNormalP(10, 100, new Elements<>(2, 2), "image.png", 50, 1);
	        List<NormalProfessor> normalProfessors = gameModel.getNormalProfList();
	        assertEquals(1, normalProfessors.size());
	        assertTrue(normalProfessors.contains(normalProfessor));
	    }
	 @Test
	    public void testGenerateRector() {
	        Rector rector = gameModel.generateNewRector(new Elements<>(3, 3));
	        List<Rector> rectors = gameModel.getRectorList();
	        assertEquals(1, rectors.size());
	        assertTrue(rectors.contains(rector));
	    }
	 
	 @Test
	    public void testBulletLists() {
	        Bullet bullet1 = new Bullet(1, 10, new Elements<>(1, 3));
	        Bullet bullet2 = new Bullet(2, 10, new Elements<>(2, 4));
	        
	        gameModel.getBulletListNormal().add(bullet1);
	        gameModel.getBulletListDiagonal().add(bullet2);
	        
	        List<Bullet> bulletListNormal = gameModel.getBulletListNormal();
	        List<Bullet> bulletListDiagonal = gameModel.getBulletListDiagonal();
	        
	        assertEquals(1, bulletListNormal.size());
	        assertEquals(1, bulletListDiagonal.size());
	        assertTrue(bulletListNormal.contains(bullet1));
	        assertTrue(bulletListDiagonal.contains(bullet2));
	    }

}
