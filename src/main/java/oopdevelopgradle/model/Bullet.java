package oopdevelopgradle.model;

import java.util.Random;
/**
 * The class Bullet implements the methods to interact with
 * a bullet during the game.
 */
public final class Bullet extends AbstractGameElement {
	private Elements<Integer, Integer> currentPosition;
    private final int bulletSpeed;
    private final int bulletDamage;
    /**
     * Constructor for BulletEntity.
     * 
     * @param speed  the speed of the bullet
     * @param damage the damage of the bullet
     * @param currentPosition the current position of the bullet
     */
    public Bullet(final int speed, final int damage, final Elements<Integer, Integer> currentPosition) {
    	super(damage, currentPosition);
        this.bulletSpeed = speed;
        this.bulletDamage = damage;
        this.currentPosition = currentPosition;
    }
    /**
	 * Gets the position of the Bullets.
	 * @return the current position of the Bullets
	 */
    @Override
    public Elements<Integer, Integer> getPosition() {
        return currentPosition;
    }
    /**
	 * Gets the speed of the Bullet.
	 * @return the current speed of the Bullet
	 */
    public int getBulletSpeed() {
        return this.bulletSpeed;
    }
    /**
	 * Gets the damage of the Bullet.
	 * @return the current damage2 of the Bullet
	 */
    public int getBulletDamage() {
        return this.bulletDamage;
    }
    /**
	 * Updates the position when he the bullet is fired.
	 * set the position after shooting.
	 */
    public void move() {
    	this.currentPosition = new Elements<>(currentPosition.getX() + bulletSpeed, currentPosition.getY());
    }
    /**
     * Fires a bullet diagonally either to the right or to the left randomly based on a random direction.
     * The method calculates the new position of the bullet by advancing along the diagonal direction.
     * The bullet's speed determines how much the bullet will move.
     * 
     */
    public void shootDiagonal() {
        // Calcola la nuova posizione del proiettile in diagonale
        final Random random = new Random();
        final int direction = random.nextInt(2); // Genera un numero casuale: 0 o 1
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