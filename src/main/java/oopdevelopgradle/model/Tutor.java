package oopdevelopgradle.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The class Tutor defines the properties of a tutor in the game.
 */
public class Tutor extends Professor {
    /**
     * The initial DAMAGE of the tutor.
     */
    public static final int TUTOR_HIT_DAMAGE = 25;
    /**
     * The initial ENERGY of the tutor.
     */
    public static final int TUTOR_BUY_ENERGY = 10;
    /**
     * The initial HEALTH POINTS of the tutor.
     */
    public static final int TUTOR_HEALTHPOINTS = 50;
    /**
     * The ID of the tutor.
     */
    public static final int TUTOR_NAME = 1;
    /**
     * The bullet object used by the tutor in this class.
     */
    private final Bullet tutorBullet;
    /**
     * the speed of the bullet.
     */
    private int bulletSpeed = 1;

    /**
     * Constructor for creating a Tutor object.
     * 
     * @param col The column position of the Tutor.
     * @param row The row position of the Tutor.
     */
    public Tutor(final int col, final int row) {
        super(TUTOR_HIT_DAMAGE, TUTOR_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), TUTOR_BUY_ENERGY);
        tutorBullet = new Bullet(bulletSpeed, TUTOR_HIT_DAMAGE, new Elements<Integer, Integer>(col, row));
    }

    /**
     * Gets the Bullet of a Tutor.
     * 
     * @return tutorBullet the Bullet of the Tutor
     */
    @SuppressFBWarnings({ "EI_EXPOSE_REP" })
    //Justification = this method is used in a controlled manner and does not expose internal data.
    public Bullet getTutorBullet() {
        return tutorBullet;
    }

    /**
     * Gets the BulletSpeed of a Tutor.
     * 
     * @return the bulletSpeed of the Tutor
     */
    public int getBulletSpeed() {
        return bulletSpeed;
    }

    /**
     * Sets the BulletSpeed of a Tutor.
     * 
     * @param bulletSpeed Value of the Tutor
     */
    public void setBulletSpeed(final int bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }
}
