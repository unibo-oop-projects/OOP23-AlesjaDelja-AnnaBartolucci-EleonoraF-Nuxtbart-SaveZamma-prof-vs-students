package _OOP_develop_gradle;

import _OOP_develop_gradle.model.Professor;

public class NormalProfessor extends Professor{

	public static final int NORMALPROF_HIT_DAMAGE = 50; //DANNO CHE INFLIGGO ALLO STUDENTE
	public static final int NORMALPROF_BUY_COST = 20;
	public static final int NORMALPROF_HEALTHPOINTS = 150;
	public static final String NORMALPROF_IMG_PATH = "img/professor.png";
	public static final String tutorBulletName = "tutorBullet";
	public static final int NormalProfName = 2;
	public Bullet normalProfBullet;
	public int bulletSpeed=2;
	private String pathImgNP;
	
	/**
	 * Constructor for creating a NormalProfessor object.
	 *
	 * @param col The column position of the NormalProfessor.
	 * @param row The row position of the NormalProfessor.
	 */
	public NormalProfessor(int col, int row) {
		super(NORMALPROF_HIT_DAMAGE, NORMALPROF_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), NORMALPROF_IMG_PATH, NORMALPROF_BUY_COST, NormalProfName);
		normalProfBullet = new Bullet(bulletSpeed, NORMALPROF_HIT_DAMAGE, new Elements<Integer, Integer>(col, row), tutorBulletName, pathImgNP);
	}

	/**
	 * Gets the Bullet of a Tutor
	 * @return the Bullet of the Tutor
	 */
	public Bullet getTutorBullet() {
		return normalProfBullet;
	}

	/**
	 * Sets the Bullet of a Tutor
	 * @param Bullet Value of the Tutor
	 */
	public void setTutorBullet(Bullet tutorBullet) {
		this.normalProfBullet = tutorBullet;
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

	/**
	 * Gets the BulletName of a Tutor
	 * @return the BulletName of the Tutor
	 */
	public static String getTutorbulletname() {
		return tutorBulletName;
	}

}
