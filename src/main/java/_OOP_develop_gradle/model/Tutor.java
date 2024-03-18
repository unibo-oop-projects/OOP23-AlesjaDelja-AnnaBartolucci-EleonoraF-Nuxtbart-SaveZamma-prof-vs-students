package _OOP_develop_gradle.model;

public class Tutor extends Professor{
	
	public static final int TUTOR_HIT_DAMAGE = 25; 
	public static final int TUTOR_BUY_ENERGY = 10;
	public static final int TUTOR_HEALTHPOINTS = 50;
	public Bullet tutorBullet;
	private int bulletSpeed=1;

	public static final int tutorName = 1;
	
	public Tutor(int col, int row) {
		super(TUTOR_HIT_DAMAGE, TUTOR_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), TUTOR_BUY_ENERGY);
		tutorBullet = new Bullet(bulletSpeed, TUTOR_HIT_DAMAGE, new Elements<Integer, Integer>(col, row));
	}

	/**
	 * Gets the Bullet of a Tutor
	 * @return the Bullet of the Tutor
	 */
	public Bullet getTutorBullet() {
		return tutorBullet;
	}

	/**
	 * Sets the Bullet of a Tutor
	 * @param Bullet Value of the Tutor
	 */
	public void setTutorBullet(Bullet tutorBullet) {
		this.tutorBullet = tutorBullet;
	}

	/**
	 * Gets the BulletSpeed of a Tutor
	 * @return the BulletSpeed of the Tutor
	 */
	public int getBulletSpeed() {
		return bulletSpeed;
	}

	/**
	 * Sets the BulletSpeed of a Tutor
	 * @param BulletSpeed Value of the Tutor
	 */
	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
}
