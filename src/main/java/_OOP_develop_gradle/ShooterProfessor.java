package application;

public class ShooterProfessor extends Professor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int hitValue;


	public ShooterProfessor(String path, int hitThreshold, int buyThreshold, int x, int y, int healthPoints, int hitValue) {
		super(path, hitThreshold, buyThreshold, x, y, healthPoints);
		this.hitValue = hitValue;
	}

	/**
	 * Returns the hit value of any shooter/attack type plants.
	 * @return the max hit value of the attack plant type 
	 */
	public int getHitValue() {
		return hitValue;
	}
}
