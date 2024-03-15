package _OOP_develop_gradle.model;

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
     * Fires a bullet diagonally relative to the current position of the professor.
     * The method calculates the new position of the bullet by advancing both along the X-axis and Y-axis simultaneously.
     * The bullet's speed determines how much the bullet will move in both directions.
     * 
     * @param professor The professor from which the bullet is fired.
     * @param studentView The student's view where the bullet will be displayed.
     */
    public void shootDiagonal() {
        // Calculate the new position of the bullet diagonally
        int newBulletX = currentPosition.getX() + bulletSpeed;
        int newBulletY = currentPosition.getY() + bulletSpeed;

        // Check that the bullet does not go beyond the boundaries of the game field
        if (newBulletX >= 0 && newBulletX < 8 && newBulletY >= 0 && newBulletY < 8) {
            // Update the position of the bullet
            currentPosition = new Elements<>(newBulletX, newBulletY);
        }
    }

    
     //POSSO ELIMINARLO?
    public String getPathImgBullet() {
		return pathImgB;
	}
    
}