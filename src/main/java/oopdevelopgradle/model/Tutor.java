package oopdevelopgradle.model;

public class Tutor extends Professor {
	
	public static final int TUTOR_HIT_DAMAGE = 25; 
	public static final int TUTOR_BUY_ENERGY = 10;
	public static final int TUTOR_HEALTHPOINTS = 50;
	public Bullet tutorBullet;
	private int bulletSpeed = 1;
	public static final int TUTOR_NAME = 1;
	
	public Tutor(final int col, final int row) {
		super(TUTOR_HIT_DAMAGE, TUTOR_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), TUTOR_BUY_ENERGY);
		tutorBullet = new Bullet(bulletSpeed, TUTOR_HIT_DAMAGE, new Elements<Integer, Integer>(col, row));
	}

	/**
	 * Gets the Bullet of a Tutor.
	 * @return tutorBullet the Bullet of the Tutor
	 */
	public Bullet getTutorBullet() {
		return tutorBullet;
	}

	/**
	 * Sets the Bullet of a Tutor.
	 * @param tutorBullet Value of the Tutor
	 */
	public void setTutorBullet(final Bullet tutorBullet) {
		this.tutorBullet = tutorBullet;
	}

	/**
	 * Gets the BulletSpeed of a Tutor.
	 * @return the bulletSpeed of the Tutor
	 */
	public int getBulletSpeed() {
		return bulletSpeed;
	}

	/**
	 * Sets the BulletSpeed of a Tutor.
	 * @param bulletSpeed Value of the Tutor
	 */
	public void setBulletSpeed(final int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
}
