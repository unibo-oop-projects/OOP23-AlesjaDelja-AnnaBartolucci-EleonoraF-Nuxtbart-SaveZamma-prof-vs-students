package oopdevelopgradle.model;

import java.util.List;
import java.util.ArrayList;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/**
 * Class representing the model for the game play.
 */
public class GamePlayModel implements GamePlayModelInterface {
    private int scoreMacth;
    private int energy;
    private int timeTot;
    private final List<Student> studentList;
    private final List<Tutor> tutorList;
    private final List<NormalProfessor> normalProfList;
    private final List<Rector> rectorList;
    private List<Bullet> bulletListNormal;
    private List<Bullet> bulletListDiagonal;
    private static final String EI_EXPOSE_REP = "EI_EXPOSE_REP";
    /**
     * Constructs of the GamePlayModel.
     */
    public GamePlayModel() {
        this.scoreMacth = 0;
        this.energy = 0;
        this.timeTot = 0;
        this.studentList = new ArrayList<>();
        this.tutorList = new ArrayList<>();
        this.normalProfList = new ArrayList<>();
        this.rectorList = new ArrayList<>();
        this.bulletListNormal = new ArrayList<>();
        this.bulletListDiagonal = new ArrayList<>();
    }

    /**
     * Takes the match score.
     * 
     * @return The match score.
     */
    @Override
    public int getScoreMacth() {
        return scoreMacth;
    }

    /**
     * Takes the match score.
     */
    @Override
    public void setScoreMacth(final int scoreMacth) {
        this.scoreMacth = scoreMacth;
    }

    /**
     * Takes the list of normalProf bullets.
     * 
     * @return The list of normalProf bullets.
     */
    @SuppressFBWarnings({ EI_EXPOSE_REP })
     //Justification:this list is used to update bullet positions and handle collisions,
     //copying the list every time would bring degrade performance.
    @Override
    public List<Bullet> getBulletListNormal() {
        return bulletListNormal;
    }

    /**
     * Sets the list of normalProf bullets.
     * 
     * @param bulletListNormal The list of normalProf bullets.
     */
    @SuppressFBWarnings({ "EI_EXPOSE_REP2" })
     //Justification = this list is updated in a controlled manner within the controller,
     //copying the list every time would bring degrade performance.
    @Override
    public void setBulletListNormal(final List<Bullet> bulletListNormal) {
        this.bulletListNormal = bulletListNormal;
    }

    /**
     * Takes the list of diagonal bullets.
     * 
     * @return The list of diagonal bullets.
     */
    @SuppressFBWarnings({ EI_EXPOSE_REP })
     //Justification:this list is used to update bullet positions and handle collisions,
     //copying the list every time would bring degrade performance.
    @Override
    public List<Bullet> getBulletListDiagonal() {
        return bulletListDiagonal;
    }

    /**
     * Sets the list of diagonal bullets.
     * 
     * @param bulletListDiagonal The list of diagonal bullets.
     */
    @SuppressFBWarnings({ "EI_EXPOSE_REP2" }) 
    //Justification:this list is updated in a controlled manner within the controller,
    //copying the list every time would bring degrade performance.
    @Override
    public void setBulletListDiagonal(final List<Bullet> bulletListDiagonal) {
        this.bulletListDiagonal = bulletListDiagonal;
    }

    /**
     * Takes the energy.
     * 
     * @return The energy.
     */
    @Override
    public int getEnergy() {
        return energy;
    }

    /**
     * Sets the energy.
     * 
     * @param matchScore
     */
    @Override
    public void setEnergy(final int matchScore) {
        this.energy = matchScore;
    }

    /**
     * Takes the total game time.
     * 
     * @return The total game time.
     */
    @Override
    public int getTimeTot() {
        return timeTot;
    }

    /**
     * Sets the total game time.
     * 
     * @param time The total game time.
     */
    @Override
    public void setTimeTot(final int time) {
        timeTot = time;
    }

    /**
     * Takes the list of students.
     * 
     * @return The list of students.
     */
    @SuppressFBWarnings({ EI_EXPOSE_REP })
     //Justification:this list is used to iterate and update the students positions,
     //Avoiding copying the list improves performance without compromising security.
    @Override
    public List<Student> getStudentList() {
        return this.studentList;
    }

    /**
     * Generates a wave of students.
     * 
     * @param waveSize The size of the wave.
     */
    @Override
    public void generateWave(final int waveSize) {
        for (int i = 0; i < waveSize; i++) {
            generateNewStudent();
        }
    }

    /**
     * Takes the list of tutors.
     * 
     * @return The list of tutors.
     */
    @SuppressFBWarnings({ EI_EXPOSE_REP })
     //justification:this list is used to iterate and update tutor positions,
     //copying the list every time would bring degrade performance.
    @Override
    public List<Tutor> getTutorList() {
        return tutorList;
    }

    /**
     * Takes the list of normal professors.
     * 
     * @return The list of normal professors.
     */
    @SuppressFBWarnings({ EI_EXPOSE_REP }) 
     //Justification:this list is used to update and handle the prof positions,
     //copying the list every time would bring unnecessary overhead and degrade performance.
    @Override
    public List<NormalProfessor> getNormalProfList() {
        return normalProfList;
    }

    /**
     * Takes the list of rectors.
     * 
     * @return The list of rectors.
     */
    @SuppressFBWarnings({ EI_EXPOSE_REP })
     //Justification:this list is used to iterate and update rector positions,
     //copying the list every time would bring degrade performance.
    @Override
    public List<Rector> getRectorList() {
        return rectorList;
    }

    /**
     * Generates a new tutor and adds it to the list.
     * 
     * @param position The position of the new tutor.
     * @return The new tutor generated.
     */
    @Override
    public Tutor generateNewTutor(final Elements<Integer, Integer> position) {
        final Tutor newTutor = new Tutor(position.getX(), position.getY());
        tutorList.add(newTutor);
        return newTutor;
    }

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
    @Override
    public NormalProfessor generateNewNormalP(final int damage, final double healthPoints,
            final Elements<Integer, Integer> position, final String pathImg, final int costProfessor,
            final int idProf) {
        final NormalProfessor newnormalProf = new NormalProfessor(position.getX(), position.getY());
        normalProfList.add(newnormalProf);
        return newnormalProf;
    }

    /**
     * Generates a new rector and adds it to the list.
     * 
     * @param position The position of the new rector.
     * @return The new rector generated.
     */
    @Override
    public Rector generateNewRector(final Elements<Integer, Integer> position) {
        final Rector newRector = new Rector(position.getX(), position.getY());
        rectorList.add(newRector);
        return newRector;
    }

    /**
     * Generates a new student and adds it to the list.
     */
    @Override
    public void generateNewStudent() {
        final Student student = new Student();
        this.studentList.add(student);
    }

    /**
     * Increases the match score by a specified amount.
     * 
     * @param amount The amount to increase the match score by.
     */
    @Override
    public void increaseEnergy(final int amount) {
        energy += amount;
    }

    /**
     * Decreases the match score by a specified amount.
     * 
     * @param amount The amount to decrease the match score by.
     * @return True if the match score was successfully decreased, false otherwise.
     */
    @Override
    public boolean decreaseEnergy(final int amount) {
        if (energy >= amount) {
            energy -= amount;
            return true;
        }
        return false;
    }

    /**
     * Increases the total game time by a specified amount.
     * 
     * @param amount The amount to increase the total game time by.
     */
    @Override
    public void increaseTimeTot(final double amount) {
        timeTot += amount;
    }

    /**
     * Decreases the total game time by a specified amount.
     * 
     * @param amount The amount to decrease the total game time by.
     * @return True if the total game time was successfully decreased, false
     *         otherwise.
     */
    @Override
    public boolean decreaseTimeTot(final double amount) {
        if (timeTot >= amount) {
            timeTot -= amount;
            return true;
        }
        return false;
    }
}
