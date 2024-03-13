package _OOP_develop_gradle;

import _OOP_develop_gradle.model.Professor;
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
     */
    public Bullet(int speed, int damage, Elements<Integer, Integer> pos, String name, String pathImgB) {
        this.bulletSpeed = speed;
        this.bulletDamage = damage;
        this.currentPosition = pos;
        this.bulletName = name;
        this.pathImgB = pathImgB;
    }

    public Elements<Integer, Integer> getPosition() {
        return currentPosition;
    }

    public boolean isAlive() {
        return true;
    }

    public String getBulletName() {
        return this.bulletName;
    }

    public int getBulletSpeed() {
        return this.bulletSpeed;
    }

    public int getBulletDamage() {
        return this.bulletDamage;
    }

    public void move() {
        this.currentPosition = new Elements<>(currentPosition.getX() + bulletSpeed, currentPosition.getY());
    }
    
<<<<<<< HEAD
    public String getPathImgBullet() {
		return pathImgB;
	}
    
    public ImageView getImageBullet(Bullet bullet) {
    	ImageView profImg = new ImageView();
    	profImg.setImage(new Image(getClass().getResource(bullet.getPathImgBullet()).toString()));
		return profImg;
    }
=======
    public void destroyBullet() { 
		//TODO
	}
>>>>>>> af62eb1aee311b03aa6dbab9b416192142fbf5c3
}
