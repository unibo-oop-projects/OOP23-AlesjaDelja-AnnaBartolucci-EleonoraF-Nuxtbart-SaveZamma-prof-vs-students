package _OOP_develop_gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains the test for the GamePlayModel
 */

class GamePlayModelTest {
	
	GamePlayModel gameModel = new GamePlayModel();
	
	
    @Test 
    public void testGenerateWave() {
    	gameModel.generateWave(3);
        assertEquals(3, gameModel.getStudentList().size());
    }
    
    
    @Test
    public void testIncreaseTimeTot() {
    	gameModel.increaseTimeTot(2);
        assertEquals(2, gameModel.getTimeTot());
    }
    
    @Test
    public void testDecreaseTimeTot() {
    	// Test when time is enough
    	gameModel.increaseTimeTot(5);
    	assertTrue(gameModel.decreaseTimeTot(2));
        assertEquals(3, gameModel.getTimeTot());
        
        // Test when time is NOT enough
        assertFalse(gameModel.decreaseTimeTot(5));
    }
    
    @Test 
    public void testGenerateNewProf() {
    	/* TO-DO: DA MODIFICARE IN BASE ALLA IMPLEMENTAZIONE DI Professor
    	Professor prof = gameModel.generateNewProf(3, 2);
        assertNotNull(prof);
        assertEquals(5, prof.getHealthPoints());
        assertEquals(3, prof.getCol());
        assertEquals(2, prof.getRow());
        assertTrue(gameModel.getProfList().contains(prof));
        */
    }
    
    @Test 
    public void testGenerateNewStudent() {
    	// TO-DO: da modificare in base all'implementazione di Student
    	gameModel.generateNewStudent();
        /*assertEquals(1, gameModel.getStudentList().size());
        assertEquals(1, gameModel.getStudentList().get(0).getPositionStudent().getY());
        assertEquals(2, gameModel.getStudentList().get(0).getPositionStudent().getX());*/
    }
}
