package _OOP_develop_gradle.view;

import java.util.List;

import _OOP_develop_gradle.controller.GamePlayController;
import _OOP_develop_gradle.model.Bullet;
import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Student;

public interface GamePlayViewInterface {

	/**
     * Retrieves the list of StudentView objects associated with this view.
     *
     * @return The list of StudentView objects.
     */
    public List<StudentView> getStudentViewList();
    /**
     * Sets the list of StudentView objects associated with this view.
     *
     * @param studentViewList The list of StudentView objects to be set.
     */
	public void setStudentViewList(List<StudentView> studentViewList);
	/**
	 * Retrieves the list of TutorView objects associated with this view.
	 *
	 * @return The list of TutorView objects.
	 */
	public List<TutorView> getTutorViewList();
	/**
	 * Sets the list of TutorView objects associated with this view.
	 *
	 * @param tutorViewList The list of TutorView objects to be set.
	 */
	public void setTutorViewList(List<TutorView> tutorViewList);
	/**
	 * Retrieves the list of NormalProfView objects associated with this view.
	 *
	 * @return The list of NormalProfView objects.
	 */
	public List<NormalProfView> getNormalProfessorViewList();
	/**
	 * Sets the list of NormalProfView objects associated with this view.
	 *
	 * @param normalProfessorViewList The list of NormalProfView objects to be set.
	 */
	public void setNormalProfessorViewList(List<NormalProfView> normalProfessorViewList);
	/**
	 * Retrieves the list of RectorView objects associated with this view.
	 *
	 * @return The list of RectorView objects.
	 */
	public List<RectorView> getRectorViewList();
	/**
	 * Sets the list of RectorView objects associated with this view.
	 *
	 * @param rectorViewList The list of RectorView objects to be set.
	 */
	public void setRectorViewList(List<RectorView> rectorViewList);
	/**
	 * Retrieves the list of BulletView objects associated with this view.
	 *
	 * @return The list of BulletView objects.
	 */
	public List<BulletView> getBulletViewList();
	/**
	 * Sets the list of BulletView objects associated with this view.
	 *
	 * @param bulletViewList The list of BulletView objects to be set.
	 */
	public void setBulletViewList(List<BulletView> bulletViewList);
	/**
	 * Sets the controller associated with this view.
	 *
	 * @param gameController The GamePlayController to be set.
	 */
	public void setController(GamePlayController gameController);
	/**
	 * Checks if a professor card has been picked for placement on the game grid.
	 *
	 * @return True if a professor card has been picked, false otherwise.
	 */
	public boolean isFirstProfPicked();
	/**
	 * Sets the flag indicating whether a professor card has been picked for placement on the game grid.
	 *
	 * @param firstProfPicked The flag to be set.
	 */
	public void setFirstProfPicked(boolean firstProfPicked);
	/**
     * Initializes the view components.
     */
    public void initializeView();
    /**
     * Checks if the timer is stopped.
     *
     * @return True if the timer is stopped, false otherwise.
     */
    public boolean isTimerStop();
    /**
     * Sets the flag indicating whether the timer is stopped.
     *
     * @param timerStop The flag to be set.
     */
	public void setTimerStop(boolean timerStop);
	/**
	 * Retrieves the match score.
	 *
	 * @return The match score.
	 */
	public int getMatchScore();
	/**
	 * Sets the match score.
	 *
	 * @param matchScore The match score to be set.
	 */
	public void setMatchScore(int matchScore);
	/**
	 * Updates the positions of game elements on the view.
	 *
	 * @param studentList       The list of students.
	 * @param profList          The list of professors.
	 * @param bulletListNormal  The list of normal bullets.
	 * @param bulletList        The list of diagonal bullets.
	 */
	public void updatePositions(List<Student> studentList, List<List<? extends Professor>> profList, List<Bullet> bulletListNormal, List<Bullet> bulletList);
	/**
	 * Removes the specified elements from the view.
	 *
	 * @param elementsToRemove The list of elements to be removed.
	 */
	public void removePosition(List<? extends ElementView> elementsToRemove);
	
}
