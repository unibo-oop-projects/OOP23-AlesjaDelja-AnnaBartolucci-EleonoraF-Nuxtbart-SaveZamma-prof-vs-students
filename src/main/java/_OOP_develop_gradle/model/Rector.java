package _OOP_develop_gradle.model;

import _OOP_develop_gradle.model.Professor;

public class Rector extends Professor{

	private Elements<Integer, Integer> currentPosition;
	
	public static final int RECTOR_HIT_DAMAGE = 25; //DANNO CHE INFLIGGO ALLO STUDENTE
	public static final int RECTOR_BUY_COST = 10;
	public static final int RECTOR_HEALTHPOINTS = 100;
	public static final String RECTOR_IMG_PATH = "img/professor.png";
	public static final String rectorBulletName = "rectorBullet";
	public Bullet rectorBullet;
	private int bulletSpeed=3;
	
	public String pathImgR;
	public static final int rectorName = 3;
	
	
	/**
     * Constructor for creating a Rector object.
     *
     * @param col The column position of the Rector.
     * @param row The row position of the Rector.
     */
	public Rector(int col, int row) {
		super(RECTOR_HIT_DAMAGE, RECTOR_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), RECTOR_IMG_PATH, RECTOR_BUY_COST, rectorName);
		this.currentPosition = new Elements<Integer, Integer>(col, row);
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
	public void setRectorBullet(Bullet rectorBullet) {
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
	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
	
	/**
     * Gets the name of the bullet used by the Rector.
     *
     * @return The name of the bullet used by the Rector.
     */
	public static String getRectorbulletname() {
		return rectorBulletName;
	}
	
	/**
     * Shoots a bullet diagonally from the Rector's current position.
     *
     * @param col The total number of columns in the game grid.
     * @param row The total number of rows in the game grid.
     */
	//funzione per sparare in diagonale
	public void shootDiagonal(int col, int row) {
	    // Calcola la posizione del proiettile in diagonale rispetto alla posizione corrente del rettore
	    int bulletCol = currentPosition.getX() + bulletSpeed;
	    int bulletRow = currentPosition.getY() + bulletSpeed;
	    // Crea un nuovo proiettile sparato in diagonale
	    if (bulletCol >= 0 && bulletCol < col && bulletRow >= 0 && bulletRow < row) {
	        // Crea un nuovo proiettile sparato in diagonale
	        rectorBullet = new Bullet(bulletSpeed, RECTOR_HIT_DAMAGE, new Elements<>(bulletCol, bulletRow), rectorBulletName, pathImgR);
	    }
	}
	
}