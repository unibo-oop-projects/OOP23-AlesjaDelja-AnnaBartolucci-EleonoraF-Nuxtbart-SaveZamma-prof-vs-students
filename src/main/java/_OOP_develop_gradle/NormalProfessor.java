package _OOP_develop_gradle;

public class NormalProfessor extends Professor{

	public static final int NORMALPROF_HIT_DAMAGE = 50; //DANNO CHE INFLIGGO ALLO STUDENTE
	public static final int NORMALPROF_BUY_COST = 20;
	public static final int NORMALPROF_HEALTHPOINTS = 150;
	public static final String NORMALPROF_IMG_PATH = "img/professor.png";
	public static final String tutorBulletName = "tutorBullet";
	public Bullet tutorBullet;
	public int bulletSpeed=2;
	
	public NormalProfessor(int col, int row) {
		super(NORMALPROF_HIT_DAMAGE, NORMALPROF_HEALTHPOINTS, new Elements<Integer, Integer>(col, row), NORMALPROF_IMG_PATH, NORMALPROF_BUY_COST);
		tutorBullet = new Bullet(bulletSpeed, NORMALPROF_HIT_DAMAGE, new Elements<Integer, Integer>(col, row), tutorBulletName);
	}

}
