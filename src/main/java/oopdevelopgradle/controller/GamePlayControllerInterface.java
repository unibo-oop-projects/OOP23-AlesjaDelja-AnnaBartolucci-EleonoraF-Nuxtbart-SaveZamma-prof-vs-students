package oopdevelopgradle.controller;

import java.io.IOException;
import java.util.List;

import oopdevelopgradle.model.Bullet;
import oopdevelopgradle.model.Professor;
import oopdevelopgradle.model.Student;
import oopdevelopgradle.view.GamePlayView;

/**
 * Interface representing the Controller for the gameplay.
 */
public interface GamePlayControllerInterface {
    /**
     * Initializes the game data with the specified {@code GamePlayView}.
     * Initializes various game elements such as score, game status, and lists of
     * bullets and professors. Also sets up the game view and starts the game if
     * there are students present.
     *
     * @param gamePlayView The GamePlayView instance to initialize the game with.
     */
    void initData(GamePlayView gamePlayView);

    /**
     * Initializes the gameplay by generating a new wave of students. Updates the
     * game view with the new positions of the students and professors.
     *
     * @throws IOException If an I/O error occurs while initializing the game.
     */
    void initGamePlay() throws IOException;

    /**
     * Moves the students in the game by advancing their positions and handling
     * collisions with professors. Updates the game status if necessary and removes
     * defeated students from the game.
     */
    void moveStudents();

    /**
     * Handles the behavior of professors in the game, such as shooting bullets and
     * removing defeated professors. Also updates the game energy based on the
     * status of professors.
     */
    void handleProfessors();

    /**
     * Advances the bullets in the game by moving them and handling collisions with
     * students. Removes bullets that have reached their maximum range or have hit a
     * student.
     */
    void advanceBullets();

    /**
     * Starts the game by initializing various game threads and loops to manage
     * gameplay mechanics such as advancing time, updating positions, handling
     * collisions, and checking game status for victory or defeat.
     *
     * @param gamePlayView The GamePlayView instance used to interact with the game
     *                     view.
     */
    void startGame(GamePlayView gamePlayView);

    /**
     * Displays the game status (victory or defeat) to the user in a separate window
     * using JavaFX.
     *
     * @param status The status of the game, either "Vittoria" for victory or
     *               "Sconfitta" for defeat.
     * @throws IOException If an I/O error occurs while loading the game status
     *                     view.
     */
    void userGame(String status) throws IOException;

    /**
     * Checks for collisions between bullets and students, updating game state
     * accordingly.
     *
     * @param studentList The list of students in the game.
     * @param bullet      The bullet to check for collisions with students.
     * @return True if a collision between the bullet and a student is detected,
     *         false otherwise.
     */
    boolean collisionBulletAndStudents(List<Student> studentList, Bullet bullet);

    /**
     * Checks for collisions between a professor and a specific student.
     *
     * @param currentStud The student to check for collisions with professors.
     * @param profList    The list of professor lists to check for collisions with
     *                    the student.
     * @return True if a collision between the professor and the student is
     *         detected, false otherwise.
     */
    boolean collisionProfAndStudent(Student currentStud, List<List<? extends Professor>> profList);

    /**
     * Checks for collisions between professors and students, updating game state
     * accordingly.
     *
     * @param students The list of students in the game.
     * @param prof     The professor to check for collisions with students.
     * @return True if a collision between the professor and a student is detected,
     *         false otherwise.
     */
    boolean collisionProfAndStudents(List<Student> students, Professor prof);

    /**
     * Removes the graphical representation of a bullet from the game view.
     *
     * @param bullet The bullet to remove from the game view.
     */
    // public void removeBulletView(Bullet bullet);
    /**
     * Removes the graphical representation of a professor from the game view and
     * updates the game state accordingly.
     *
     * @param prof The professor whose graphical representation needs to be removed.
     */
    void removeProfessorView(Professor prof);

    /**
     * Retrieves the score of the current match.
     *
     * @return The score of the current match.
     */
    //Score getScoreMatch();

    /**
     * Sets the score of the current match.
     *
     * @param scoreMatch The score of the current match to be set.
     */
    //void setScoreMatch(Score scoreMatch);

    /**
     * Checks the status of the game.
     *
     * @return True if the game is currently active, false otherwise.
     */
    boolean isGameStatus();

    /**
     * Sets the status of the game.
     *
     * @param status The status of the game to be set.
     */
    void setGameStatus(boolean status);

    /**
     * Retrieves the GamePlayView associated with this controller.
     *
     * @return The GamePlayView associated with this controller.
     */
    //GamePlayView getGamePlayView();

    /**
     * Retrieves the list of students currently in the game.
     *
     * @return The list of students currently in the game.
     */
    //List<Student> getStudInGame();

    /**
     * Sets the list of students currently in the game.
     *
     * @param studInGame The list of students currently in the game to be set.
     */
    //void setStudInGame(List<Student> studInGame);
}
