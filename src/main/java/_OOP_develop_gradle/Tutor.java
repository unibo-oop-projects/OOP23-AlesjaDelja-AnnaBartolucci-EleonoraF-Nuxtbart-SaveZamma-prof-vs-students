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
	//public static final int TUTOR_HIT_VALUE = 2;
	private int hitValue;
	
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

	/**
     * Shoots a pea at zombie, if zombie is close enough.
     * @return hit value to a zombie object without negation
     */
    public int shootPea() {
        return hitValue; // Restituisce il valore senza negarlo
    }

    // Metodo set per impostare il segno
    public void setHitValue(int hitValue) {
        this.hitValue = -hitValue;
    }
	
    public void shootDiagonal(int col, int rowDia) {
	    // Calcola la posizione del proiettile in diagonale rispetto alla posizione corrente del rettore
	    int bulletCol = currentPosition.getX() + bulletSpeed;
	    int bulletRow = currentPosition.getY() + bulletSpeed;
	    // Crea un nuovo proiettile sparato in diagonale
	    if (bulletCol >= 0 && bulletCol < col && bulletRow >= 0 && bulletRow < row) {
	        // Crea un nuovo proiettile sparato in diagonale
	    	tutorBullet = new Bullet(bulletSpeed, RECTOR_HIT_DAMAGE, new Elements<>(bulletCol, bulletRow), tutorBulletName);
	    }
	}
}
