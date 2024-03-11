package _OOP_develop_gradle;

//tutor cerbottana
public class Tutor extends Professor{
	
	public static final int TUTOR_HIT_DAMAGE = 25; //DANNO CHE INFLIGGO ALLO STUDENTE
	public static final int TUTOR_BUY_COST = 10;
	public static final int TUTOR_HEALTHPOINTS = 100;
	public static final String TUTOR_IMG_PATH = "img/professor.png";
	public static final String tutorBulletName = "tutorBullet";
	public Bullet tutorBullet;
	//public static final int TUTOR_HIT_VALUE = 2;
	private int hitValue;
	private int bulletSpeed=1;
	
	public Tutor(int col, int row) {
		super(TUTOR_HIT_DAMAGE, TUTOR_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), TUTOR_IMG_PATH, TUTOR_BUY_COST);
		tutorBullet = new Bullet(bulletSpeed, TUTOR_HIT_DAMAGE, new Elements<Integer, Integer>(col, row), tutorBulletName);
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
	
}
