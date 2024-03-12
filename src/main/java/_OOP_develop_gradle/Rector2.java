package _OOP_develop_gradle;

import _OOP_develop_gradle.model.Professor;

//fungo ipnotico
public class Rector2 extends Professor{
	
	private static final long serialVersionUID = 1L;
	public static final int HYPNOSHROOM_HIT_THRESHOLD = 1;
	public static final int HYPNOSHROOM_BUY_THRESHOLD = 125;

	public Rector2(String path, int x, int y, int healthPoints) {
		super(path, HYPNOSHROOM_BUY_THRESHOLD, HYPNOSHROOM_HIT_THRESHOLD, x, y, healthPoints);
	}
	
	public String toString() {
		String Status= "";
		Status = "HS = " + this.getHitThreshold();
		return Status;
	}
}
