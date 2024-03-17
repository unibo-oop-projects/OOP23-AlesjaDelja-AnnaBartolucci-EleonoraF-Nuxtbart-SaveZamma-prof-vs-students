package _OOP_develop_gradle.model;

import java.util.Random;

public final class Bullet extends AbstractGameElement{

	private Elements<Integer, Integer> currentPosition;
    private final int bulletSpeed;
    private final int bulletDamage;

    /**
     * Constructor for BulletEntity.
     * 
     * @param speed  the speed of the bullet
     * @param damage the damage of the bullet
     * @param pos    the position of the bullet
     * @param name   the name of the bullet
     * @param pathImg   the name of the bullet
     */
    public Bullet(int speed, int damage, Elements<Integer, Integer> currentPosition) {
    	super(damage, currentPosition);
        this.bulletSpeed = speed;
        this.bulletDamage = damage;
        this.currentPosition = currentPosition;
    }

    /**
	 * Gets the position of the Bullets
	 * @return the current position of the Bullets
	 */
    public Elements<Integer, Integer> getPosition() {
        return currentPosition;
    }

    /**
	 * Gets the speed of the Bullet
	 * @return the current speed of the Bullet
	 */
    public int getBulletSpeed() {
        return this.bulletSpeed;
    }

    /**
	 * Gets the damage of the Bullet
	 * @return the current damage2 of the Bullet
	 */
    public int getBulletDamage() {
        return this.bulletDamage;
    }

    /**
	 * Updates the position when he the bullet is fired.
	 * @return the position after shooting
	 */
    public void move() {
    	this.currentPosition = new Elements<>(currentPosition.getX() + bulletSpeed, currentPosition.getY());
    }
    
    /**
     * Fires a bullet diagonally either to the right or to the left randomly based on a random direction.
     * The method calculates the new position of the bullet by advancing along the diagonal direction.
     * The bullet's speed determines how much the bullet will move.
     * 
     * @param professor The professor from which the bullet is fired.
     */
    public void shootDiagonal() {
        // Calcola la nuova posizione del proiettile in diagonale
        Random random = new Random();
        int direction = random.nextInt(2); // Genera un numero casuale: 0 o 1

        int newBulletX = currentPosition.getX(); // Inizializziamo con la posizione corrente
        int newBulletY = currentPosition.getY(); // Inizializziamo con la posizione corrente

        // Verifica la direzione e aggiorna le coordinate di conseguenza
        if (direction == 0) {
            // Sparare sulla diagonale a destra
            newBulletX += bulletSpeed;
            newBulletY += bulletSpeed;
        } else {
            // Sparare sulla diagonale a sinistra
            newBulletX += bulletSpeed;
            newBulletY -= bulletSpeed;
        }

            // Aggiorna la posizione del proiettile
            currentPosition = new Elements<>(newBulletX, newBulletY);
    }
    
}