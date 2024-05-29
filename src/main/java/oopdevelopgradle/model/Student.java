package oopdevelopgradle.model;

import java.util.Random;
/**
 * The class Student defines the features of a student in the game.
 */
public class Student extends AbstractGameElement {
	private int health; // The health points of the student.
    private int energy; // The energy level of the student.
    private static final int DEFAULT_DAMAGE = 25; // The default damage inflicted by the student.
    private static final int DEFAULT_HEALTH = 100; // The default health points of the student.
    private static final int DEFAULT_ENERGY = 10; // The default energy level of the student.
    private static final int DEFAULT_ROW = 5; // The default row position of the student.
    private static final int DEFAULT_COL = 8; // The default column position of the student.
    /**
     * Constructor for creating a Student object.
     */
    public Student() {
    	super(DEFAULT_DAMAGE, null);
        this.health = DEFAULT_HEALTH;
        this.energy = DEFAULT_ENERGY;
        generateRandomPosition();
    }
    /**
     * Generates a random position for the student within the game grid.
     */
    void generateRandomPosition() {
        final Random random = new Random();
        final int randomY = random.nextInt(DEFAULT_ROW);
        this.position = new Elements<>(DEFAULT_COL, randomY);
    }
    /**
     * Gets the health points of the student.
     *
     * @return The health points of the student.
     */
    public int getHealthStudent() {
        return health;
    }
    /**
     * Gets the energy level of the student.
     *
     * @return The energy level of the student.
     */
    public int getEnergy() {
        return energy;
    }
    /**
     * Sets the health points of the student.
     *
     * @param health The health points to set.
     */
    public void setHealthStudent(final int health) {
        this.health = health;
    }
    /**
     * Sets the energy level of the student.
     *
     * @param energy The energy level to set.
     */
    public void setEnergy(final int energy) {
        this.energy = energy;
    }
    /**
     * Reduces the health of the student by the specified damage amount.
     *
     * @param damageTaken The amount of damage taken by the student.
     */
    public void takeDamageStudents(final int damageTaken) {
        health -= damageTaken;
    }
}
