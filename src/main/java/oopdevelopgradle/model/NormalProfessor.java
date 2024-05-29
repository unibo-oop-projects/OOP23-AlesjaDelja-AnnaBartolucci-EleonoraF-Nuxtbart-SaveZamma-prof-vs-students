package oopdevelopgradle.model;

/**
 * The class NormalProfessor defines the properties of a normal professor in the
 * game.
 */
public class NormalProfessor extends Professor {
    /**
     * The initial DAMAGE of the normal professor.
     */
    public static final int NORMALPROF_HIT_DAMAGE = 50;
    /**
     * The initial ENERGY of the normal professor.
     */
    public static final int NORMALPROF_BUY_ENERGY = 20;
    /**
     * The initial HEALTH POINTS of the normal professor.
     */
    public static final int NORMALPROF_HEALTHPOINTS = 100;
    /**
     * The ID of the normal professor.
     */
    public static final int NORMAL_PROF_NAME = 2;
    public Bullet normalProfBullet;
    private int bulletSpeed = 1;

    /**
     * Constructor for creating a NormalProfessor object.
     *
     * @param col The column position of the NormalProfessor.
     * @param row The row position of the NormalProfessor.
     */
    public NormalProfessor(final int col, final int row) {
        super(NORMALPROF_HIT_DAMAGE, NORMALPROF_HEALTHPOINTS, new Elements<Integer, Integer>(col, row),
                NORMALPROF_BUY_ENERGY);
        normalProfBullet = new Bullet(bulletSpeed, NORMALPROF_HIT_DAMAGE, new Elements<Integer, Integer>(col, row));
    }

    /**
     * Gets the bullet used by the NormalProfessor.
     *
     * @return The bullet used by the NormalProfessor.
     */
    public Bullet getNormalProfBullet() {
        return normalProfBullet;
    }

    /**
     * Sets the bullet used by the NormalProfessor.
     *
     * @param normalProfBullet The bullet to be used by the NormalProfessor.
     */
    public void setNormalProfBullet(final Bullet normalProfBullet) {
        this.normalProfBullet = normalProfBullet;
    }

    /**
     * Gets the speed of the bullet used by the NormalProfessor.
     *
     * @return The speed of the bullet used by the NormalProfessor.
     */
    public int getBulletSpeed() {
        return bulletSpeed;
    }

    /**
     * Sets the speed of the bullet used by the NormalProfessor.
     *
     * @param bulletSpeed The speed of the bullet used by the NormalProfessor.
     */
    public void setBulletSpeed(final int bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }
}
