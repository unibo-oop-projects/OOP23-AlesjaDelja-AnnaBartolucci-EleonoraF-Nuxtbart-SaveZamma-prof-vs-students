package _OOP_develop_gradle;

import _OOP_develop_gradle.model.Professor;

public class Rector extends Professor{

	private Elements<Integer, Integer> currentPosition;
	
	public static final int RECTOR_HIT_DAMAGE = 25; //DANNO CHE INFLIGGO ALLO STUDENTE
	public static final int RECTOR_BUY_COST = 10;
	public static final int RECTOR_HEALTHPOINTS = 100;
	public static final String RECTOR_IMG_PATH = "img/professor.png";
	public static final String tutorBulletName = "rectorBullet";
	public Bullet rectorBullet;
	public String pathImgR;
	
	public static String getTutorbulletname() {
		return tutorBulletName;
	}
	public static final int rectorName = 3;
	//public static final int TUTOR_HIT_VALUE = 2;
	private int hitValue;
	private int bulletSpeed=3;
	
	public Rector(int col, int row) {
		super(RECTOR_HIT_DAMAGE, RECTOR_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), RECTOR_IMG_PATH, RECTOR_BUY_COST, rectorName);
		this.currentPosition = new Elements<Integer, Integer>(col, row);
	}
	
	public Bullet getRectorBullet() {
		return rectorBullet;
	}
	public void setRectorBullet(Bullet rectorBullet) {
		this.rectorBullet = rectorBullet;
	}
	public int getBulletSpeed() {
		return bulletSpeed;
	}
	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
	
	//funzione per sparare in diagonale
	public void shootDiagonal(int col, int row) {
	    // Calcola la posizione del proiettile in diagonale rispetto alla posizione corrente del rettore
	    int bulletCol = currentPosition.getX() + bulletSpeed;
	    int bulletRow = currentPosition.getY() + bulletSpeed;
	    // Crea un nuovo proiettile sparato in diagonale
	    if (bulletCol >= 0 && bulletCol < col && bulletRow >= 0 && bulletRow < row) {
	        // Crea un nuovo proiettile sparato in diagonale
	        rectorBullet = new Bullet(bulletSpeed, RECTOR_HIT_DAMAGE, new Elements<>(bulletCol, bulletRow), tutorBulletName, pathImgR);
	    }
	}
}
