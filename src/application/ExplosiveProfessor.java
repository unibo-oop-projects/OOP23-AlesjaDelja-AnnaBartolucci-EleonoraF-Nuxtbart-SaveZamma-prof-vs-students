package application;

public class ExplosiveProfessor extends Professor{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int explosionDamage;
	private boolean hasExploded;
	
	public ExplosiveProfessor(String path, int hitThreshold, int buyThreshold, int x, int y, int healthPoints, int explosionDamage) {
		super(path, hitThreshold, buyThreshold, x, y, healthPoints);
		this.explosionDamage = explosionDamage;
		hasExploded = false;
	}

	public int getExplosionDamage() {
		return explosionDamage;
	}
	
	public boolean hasExploded() {
		return hasExploded;
	}
	
	public void explode() {
		hasExploded = true;
	}
}
