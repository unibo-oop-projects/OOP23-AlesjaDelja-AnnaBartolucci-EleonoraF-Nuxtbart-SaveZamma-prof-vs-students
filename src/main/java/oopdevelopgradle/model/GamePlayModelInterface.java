package oopdevelopgradle.model;

import java.util.List;

/**
 * Interface representing the model for the gameplay.
 */
public interface GamePlayModelInterface {

    /**
     * Retrieves the match score.
     * 
     * @return The match score.
     */
    int getScoreMacth();

    /**
     * Sets the match score.
     * 
     * @param scoreMacth The match score to set.
     */
    void setScoreMacth(int scoreMacth);

    /**
     * Retrieves the list of normal bullets.
     * 
     * @return The list of normal bullets.
     */
    List<Bullet> getBulletListNormal();

    /**
     * Sets the list of normal bullets.
     * 
     * @param bulletListNormal The list of normal bullets to set.
     */
    void setBulletListNormal(List<Bullet> bulletListNormal);

    /**
     * Retrieves the list of diagonal bullets.
     * 
     * @return The list of diagonal bullets.
     */
    List<Bullet> getBulletListDiagonal();

    /**
     * Sets the list of diagonal bullets.
     * 
     * @param bulletListDiagonal The list of diagonal bullets to set.
     */
    void setBulletListDiagonal(List<Bullet> bulletListDiagonal);

    /**
     * Retrieves the energy.
     * 
     * @return The energy.
     */
    int getEnergy();

    /**
     * Sets the energy.
     * 
     * @param matchScore The energy to set.
     */
    void setEnergy(int matchScore);

    /**
     * Retrieves the total game time.
     * 
     * @return The total game time.
     */
    int getTimeTot();

    /**
     * Sets the total game time.
     * 
     * @param time The total game time to set.
     */
    void setTimeTot(int time);

    /**
     * Retrieves the list of students.
     * 
     * @return The list of students.
     */
    List<Student> getStudentList();

    /**
     * Generates a wave of students.
     * 
     * @param waveSize The size of the wave to generate.
     */
    void generateWave(int waveSize);

    /**
     * Retrieves the list of tutors.
     * 
     * @return The list of tutors.
     */
    List<Tutor> getTutorList();

    /**
     * Sets the list of tutors.
     * 
     * @param tutorList The list of tutors to set.
     */
    void setTutorList(List<Tutor> tutorList);

    /**
     * Retrieves the list of normal professors.
     * 
     * @return The list of normal professors.
     */
    List<NormalProfessor> getNormalProfList();

    /**
     * Sets the list of normal professors.
     * 
     * @param normalProfList The list of normal professors to set.
     */
    void setNormalProfList(List<NormalProfessor> normalProfList);

    /**
     * Retrieves the list of rectors.
     * 
     * @return The list of rectors.
     */
    List<Rector> getRectorList();

    /**
     * Sets the list of rectors.
     * 
     * @param rectorList The list of rectors to set.
     */
    void setRectorList(List<Rector> rectorList);

    /**
     * Sets the list of students.
     * 
     * @param studentList The list of students to set.
     */
    void setStudentList(List<Student> studentList);

    /**
     * Generates a new tutor and adds it to the list.
     * 
     * @param position The position of the new tutor.
     * @return The new tutor generated.
     */
    Tutor generateNewTutor(Elements<Integer, Integer> position);

    /**
     * Generates a new normal professor and adds it to the list.
     * 
     * @param damage        The damage of the new normal professor.
     * @param healthPoints  The health points of the new normal professor.
     * @param position      The position of the new normal professor.
     * @param pathImg       The image path of the new normal professor.
     * @param costProfessor The cost of the new normal professor.
     * @param idProf        The ID of the new normal professor.
     * @return The new normal professor generated.
     */
    NormalProfessor generateNewNormalP(int damage, double healthPoints, Elements<Integer, Integer> position,
            String pathImg, int costProfessor, int idProf);

    /**
     * Generates a new rector and adds it to the list.
     * 
     * @param position The position of the new rector.
     * @return The new rector generated.
     */
    Rector generateNewRector(Elements<Integer, Integer> position);

    /**
     * Generates a new student and adds it to the list.
     */
    void generateNewStudent();

    /**
     * Increases the energy by a specified amount.
     * 
     * @param amount The amount to increase the energy by.
     */
    void increaseEnergy(int amount);

    /**
     * Decreases the energy by a specified amount.
     * 
     * @param amount The amount to decrease the energy by.
     * @return True if the energy was successfully decreased, false otherwise.
     */
    boolean decreaseEnergy(int amount);

    /**
     * Increases the total game time by a specified amount.
     * 
     * @param amount The amount to increase the total game time by.
     */
    void increaseTimeTot(double amount);

    /**
     * Decreases the total game time by a specified amount.
     * 
     * @param amount The amount to decrease the total game time by.
     * @return True if the total game time was successfully decreased, false
     *         otherwise.
     */
    boolean decreaseTimeTot(double amount);
}
