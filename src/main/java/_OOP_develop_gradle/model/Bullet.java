package _OOP_develop_gradle.model;

import java.util.Random;

import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.view.StudentView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class Bullet {

    private Elements<Integer, Integer> currentPosition;
    private final int bulletSpeed;
    private final int bulletDamage;
    private final String bulletName;
	private String pathImgB;

    /**
     * Constructor for BulletEntity.
     * 
     * @param speed  the speed of the bullet
     * @param damage the damage of the bullet
     * @param pos    the position of the bullet
     * @param name   the name of the bullet
     * @param pathImg   the name of the bullet
     */
    public Bullet(int speed, int damage, Elements<Integer, Integer> pos, String name, String pathImgB) {
        this.bulletSpeed = speed;
        this.bulletDamage = damage;
        this.currentPosition = pos;
        this.bulletName = name;
        this.pathImgB = pathImgB;
    }

    /**
	 * Gets the position of the Bullets
	 * @return the current position of the Bullets
	 */
    public Elements<Integer, Integer> getPosition() {
        return currentPosition;
    }

    //é da togliere???
    public boolean isAlive() {
        return true;
    }

    /**
	 * Gets the name of the Bullet
	 * @return the current name of the Bullet
	 */
    public String getBulletName() {
        return this.bulletName;
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

        int newBulletX;
        int newBulletY;

        if (direction == 0) {
            // Sparare sulla diagonale a destra
            newBulletX = currentPosition.getX() + bulletSpeed;
            newBulletY = currentPosition.getY() + bulletSpeed;
        } else {
            // Sparare sulla diagonale a sinistra
            newBulletX = currentPosition.getX() + bulletSpeed;
            newBulletY = currentPosition.getY() - bulletSpeed;
        }

        // Verifica che il proiettile non esca dai limiti del campo di gioco
        if (newBulletX >= 0 && newBulletX < 8 && newBulletY >= 0 && newBulletY < 8) {
            // Aggiorna la posizione del proiettile
            currentPosition = new Elements<>(newBulletX, newBulletY);
        }
    }
    
     //POSSO ELIMINARLO?
    public String getPathImgBullet() {
		return pathImgB;
	}
    
}