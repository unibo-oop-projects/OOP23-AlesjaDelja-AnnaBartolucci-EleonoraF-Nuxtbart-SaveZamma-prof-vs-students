package oopdevelopgradle.model;
/**
 * The class Rector defines the properties of a rector in the game.
 */
public class Rector extends Professor {
/**
	 * The initial DAMAGE of the rector.
	 */
	public static final int RECTOR_HIT_DAMAGE = 50;
	/**
	 * The initial ENERGY of the rector.
	 */
	public static final int RECTOR_BUY_ENERGY = 30;
	/**
	 * The initial HEALTH POINTS of the rector.
	 */
	public static final int RECTOR_HEALTHPOINTS = 150;
	/**
	 * The ID of the rector.
	 */
	public static final int RECTOR_NAME = 3;
	public Bullet rectorBullet;
	private int bulletSpeed = 1;
	/**
     * Constructor for creating a Rector object.
     *
     * @param col The column position of the Rector.
     * @param row The row position of the Rector.
     */
	public Rector(final int col, final int row) {
		super(RECTOR_HIT_DAMAGE, RECTOR_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), RECTOR_BUY_ENERGY);
		final Elements<Integer, Integer> currentPosition = new Elements<>(col, row);
		final int bulletCol = currentPosition.getX() + bulletSpeed;
	    final int bulletRow = currentPosition.getY() + bulletSpeed;
	    rectorBullet = new Bullet(bulletSpeed, RECTOR_HIT_DAMAGE, new Elements<>(bulletCol, bulletRow));
	}
	/**
     * Gets the bullet used by the Rector.
     *
     * @return The bullet used by the Rector.
     */
	public Bullet getRectorBullet() {
		return rectorBullet;
	}
	/**
     * Sets the bullet used by the Rector.
     *
     * @param rectorBullet The bullet to be used by the Rector.
     */
	public void setRectorBullet(final Bullet rectorBullet) {
		this.rectorBullet = rectorBullet;
	}
	/**
     * Gets the speed of the bullet used by the Rector.
     *
     * @return The speed of the bullet used by the Rector.
     */
	public int getBulletSpeed() {
		return bulletSpeed;
	}
	/**
     * Sets the speed of the bullet used by the Rector.
     *
     * @param bulletSpeed The speed of the bullet used by the Rector.
     */
	public void setBulletSpeed(final int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
}
