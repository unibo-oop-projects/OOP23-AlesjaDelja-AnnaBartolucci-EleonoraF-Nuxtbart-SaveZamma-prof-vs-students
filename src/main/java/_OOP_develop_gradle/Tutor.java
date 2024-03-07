package application;

//tutor cerbottana
public class Tutor extends ShooterProfessor{

	private static final long serialVersionUID = 1L;
	public static final int TUTOR_HIT_THRESHOLD = 10;
	public static final int TUTOR_BUY_THRESHOLD = 100;
	public static final int TUTOR_HIT_VALUE = 2;
	private int hitValue;
	
	public Tutor(String path, int x, int y) {
		super(path, TUTOR_HIT_THRESHOLD, TUTOR_BUY_THRESHOLD, x, y, TUTOR_HIT_VALUE, y);
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
	
	public String toString() {
		String Status= "";
		Status = "P = " + this.getHitThreshold();
		return Status;
	}
}
