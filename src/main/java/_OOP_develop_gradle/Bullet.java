package _OOP_develop_gradle;

public final class Bullet {

    private Elements<Integer, Integer> currentPosition;
    private final int bulletSpeed;
    private final int bulletDamage;
    private final String bulletName;

    /**
     * Constructor for BulletEntity.
     * 
     * @param speed  the speed of the bullet
     * @param damage the damage of the bullet
     * @param pos    the position of the bullet
     * @param name   the name of the bullet
     */
    public Bullet(int speed, int damage, Elements<Integer, Integer> pos, String name) {
        this.bulletSpeed = speed;
        this.bulletDamage = damage;
        this.currentPosition = pos;
        this.bulletName = name;
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
    
    public void destroyBullet() { 
		//TODO
	}
}
