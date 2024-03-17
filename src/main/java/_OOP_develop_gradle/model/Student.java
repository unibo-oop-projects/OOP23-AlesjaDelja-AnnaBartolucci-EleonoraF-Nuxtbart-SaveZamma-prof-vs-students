package _OOP_develop_gradle.model;

import java.util.Random;

public class Student extends AbstractGameElement {
    private int health;
    private int energy;
    private static int DEFAULT_DAMAGE =  25;
    private static int DEFAULT_HEALTH =  100;
    private static int DEFAULT_ENERGY = 10;
    private static int DEFAULT_ROW = 5;
    private static int DEFAULT_COL = 8;
//MODIFICATO COSTRUTTORE
    public Student() {
    	super(DEFAULT_DAMAGE, DEFAULT_HEALTH, null, DEFAULT_ENERGY);
    	//guardare se settare i campi
        this.health = DEFAULT_HEALTH;
        this.energy = DEFAULT_ENERGY;
        generateRandomPosition();
    }

    private void generateRandomPosition() {
        Random random = new Random();
        int randomY = random.nextInt(DEFAULT_ROW);
        this.position = new Elements<>(DEFAULT_COL, randomY);
    }

    public int getHealthStudent() {
        return health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setHealthStudent(int health) {
        this.health = health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void takeDamageStudents(int damageTaken) {
        health -= damageTaken;
    }

}
