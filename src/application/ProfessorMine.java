package application;

public class ProfessorMine extends ExplosiveProfessor{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int POTATOMINE_HIT_THRESHOLD = 15;
	public static final int POTATOMINE_BUY_THRESHOLD = 75;
	public static final int TURNS_UNTIL_EXPLOSION = 3;
	public static final int POTATOMINE_EXPLOSION_DAMAGE = 10;
	
	
	private int countDownStartToExplode;
	private boolean isPrimed;
	
	public ProfessorMine(String path, int x, int y, int healthPoints) {
		super(path, POTATOMINE_HIT_THRESHOLD, POTATOMINE_BUY_THRESHOLD, x, y, POTATOMINE_EXPLOSION_DAMAGE, healthPoints);
		countDownStartToExplode = TURNS_UNTIL_EXPLOSION;
		setPrimed(false);
	}
	
	public void decrementExplosionCountdown() {
        int currentCountDown = countDownToExplode(countDownStartToExplode);
        if (currentCountDown == 0) {
            countDownStartToExplode = TURNS_UNTIL_EXPLOSION;
            isPrimed = true;
        }
    }
	
	public boolean isPrimed() {
        return getPrimed();
    }
	
	// Getter and setter for isPrimed
    private boolean getPrimed() {
        return isPrimed;
    }
    
    private void setPrimed(boolean primed) {
        this.isPrimed = primed;
    }
    
    private int countDownToExplode(int startCountDown) {
        if (startCountDown != 0) {
            countDownStartToExplode--;
            startCountDown = countDownStartToExplode;
        }
        return startCountDown;
    }
	
	/**
	 * Text-Based PvZ support.
	 */
	public String toString() {
		String Status= "";
		Status = "PM = " + this.getHitThreshold();
		return Status;
	}

}
