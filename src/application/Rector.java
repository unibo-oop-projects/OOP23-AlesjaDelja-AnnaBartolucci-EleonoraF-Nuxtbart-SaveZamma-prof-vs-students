package application;
//fungo ipnotico
public class Rector extends PassiveProfessor{
	
	private static final long serialVersionUID = 1L;
	public static final int HYPNOSHROOM_HIT_THRESHOLD = 1;
	public static final int HYPNOSHROOM_BUY_THRESHOLD = 125;

	public Rector(String path, int x, int y, int healthPoints) {
		super(path, HYPNOSHROOM_BUY_THRESHOLD, HYPNOSHROOM_HIT_THRESHOLD, x, y, healthPoints);
	}
	
	public String toString() {
		String Status= "";
		Status = "HS = " + this.getHitThreshold();
		return Status;
	}
}
