package _OOP_develop_gradle;

import _OOP_develop_gradle.model.Professor;

//tutor cerbottana
public class Tutor extends Professor{
	
	public static final int TUTOR_HIT_DAMAGE = 25; //DANNO CHE INFLIGGO ALLO STUDENTE
	public static final int TUTOR_BUY_COST = 10;
	public static final int TUTOR_HEALTHPOINTS = 100;
	public static final String TUTOR_IMG_PATH = "img/professor.png";
	public static final String tutorBulletName = "tutorBullet";
	public Bullet tutorBullet;
	private int bulletSpeed=1;
	public static final int tutorName = 1;
	private String pathImgT;
	
	private Elements<Integer, Integer> currentPosition;
	public Tutor(int col, int row) {
		super(TUTOR_HIT_DAMAGE, TUTOR_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), TUTOR_IMG_PATH, TUTOR_BUY_COST, tutorName);
		tutorBullet = new Bullet(bulletSpeed, TUTOR_HIT_DAMAGE, new Elements<Integer, Integer>(col, row), tutorBulletName, pathImgT);
	}


	public Bullet getTutorBullet() {
		return tutorBullet;
	}

	public void setTutorBullet(Bullet tutorBullet) {
		this.tutorBullet = tutorBullet;
	}



	public int getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}

	public static String getTutorbulletname() {
		return tutorBulletName;
	}
	
}
