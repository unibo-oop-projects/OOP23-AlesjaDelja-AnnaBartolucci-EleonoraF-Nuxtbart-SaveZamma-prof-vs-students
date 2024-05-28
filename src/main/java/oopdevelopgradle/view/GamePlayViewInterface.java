package oopdevelopgradle.view;

import java.util.List;

import oopdevelopgradle.model.Bullet;
import oopdevelopgradle.model.Professor;
import oopdevelopgradle.model.Student;
import oopdevelopgradle.controller.GamePlayController;

public interface GamePlayViewInterface {
	/**
	 * Sets the controller associated with this view.
	 *
	 * @param gameController The GamePlayController to be set.
	 */
	void setController(GamePlayController gameController);
	/**
	 * Checks if a professor card has been picked for placement on the game grid.
	 *
	 * @return True if a professor card has been picked, false otherwise.
	 */
	boolean isFirstProfPicked();
	/**
	 * Sets the flag indicating whether a professor card has been picked for placement on the game grid.
	 *
	 * @param firstProfPicked The flag to be set.
	 */
	void setFirstProfPicked(boolean firstProfPicked);
	/**
     * Initializes the view components.
     */
    void initializeView();
    /**
     * Checks if the timer is stopped.
     *
     * @return True if the timer is stopped, false otherwise.
     */
    boolean isTimerStop();
    /**
     * Sets the flag indicating whether the timer is stopped.
     *
     * @param timerStop The flag to be set.
     */
	void setTimerStop(boolean timerStop);
	/**
	 * Retrieves the match score.
	 *
	 * @return The match score.
	 */
	int getMatchScore();
	/**
	 * Sets the match score.
	 *
	 * @param matchScore The match score to be set.
	 */
	void setMatchScore(int matchScore);
	/**
	 * Updates the positions of game elements on the view.
	 *
	 * @param studentList       The list of students.
	 * @param profList          The list of professors.
	 * @param bulletListNormal  The list of normal bullets.
	 * @param bulletList        The list of diagonal bullets.
	 */
	void updatePositions(List<Student> studentList, List<List<? extends Professor>> profList, 
			List<Bullet> bulletListNormal, List<Bullet> bulletList);
	/**
	 * Removes the specified elements from the view.
	 *
	 * @param elementsToRemove The list of elements to be removed.
	 */
	void removePosition(List<? extends ElementView> elementsToRemove);
	
}
