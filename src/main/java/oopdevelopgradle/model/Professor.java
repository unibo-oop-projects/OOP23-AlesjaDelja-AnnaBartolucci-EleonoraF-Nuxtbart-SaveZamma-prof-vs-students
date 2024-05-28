package oopdevelopgradle.model;


public class Professor extends AbstractGameElement{
    
	private int energyProfessor; // The energy level of the professor.
    private boolean isAttacked; // Indicates whether the professor is currently under attack.
    private int damage; // The damage inflicted by the professor.
    private final Elements<Integer, Integer> position; // The position of the professor on the game grid.
    private int healthPoints; // The health points of the professor.
    public String pathImgP; // The file path for the image representing the professor.
    public int id; // The unique identifier for the professor.
    
    /**
     * Constructor for creating a Professor object.
     *
     * @param damage The damage inflicted by the professor.
     * @param healthPoints The health points of the professor.
     * @param position The position of the professor on the game grid.
     * @param energyProfessor The cost to buy the professor.
     */
    public Professor(final int damage, final int healthPoints, final Elements<Integer, Integer> position, final int energyProfessor) {
          super(damage, position);
		  this.damage = damage; 
		  this.healthPoints = healthPoints; 
		  this.position =position; 
		  this.energyProfessor = energyProfessor; 
		  this.isAttacked = false;
		 
    }
    /**
     * Returns a boolean value indicating whether the object has been attacked.
     *
     * @return {@code true} if the object has been attacked, {@code false} otherwise.
     */
    public boolean isAttacked() {
		return isAttacked;
	}
    /**
     * Sets the boolean value indicating whether the object has been attacked.
     *
     * @param isAttacked {@code true} if the object has been attacked, {@code false} otherwise.
     */
	public void setAttacked(final boolean isAttacked) {
		this.isAttacked = isAttacked;
	}

    /**
     * Gets the healthpoints of a professor
     * @return the healthpoints of the professor
     */
    public int getHealthPointsProf() {
        return healthPoints;
    }

    /**
     * Sets the healthpoints of a professor
     * @param the healthpoints value of the professor
     */
    public void setHealthPointsProf(final int healthPoints) { 
        this.healthPoints = healthPoints; 
    }
     
    /**
     * Gets the costProfessor of a professor
     * @return the costProfessor of the professor
     */
	
	  public int getEnergyProfessor() { 
		  return energyProfessor; 
	  }
	 
    
    /**
     * Sets the costProfessor of a professor
     * @param the costProfessor value of the professor
     */
	
	  public void setEnergyProfessor(final int energyProfessor) { 
		  this.energyProfessor =energyProfessor; 
	  }
	 
    
    /**
     * Gets the damage of a professor
     * @return the damage of the professor
     */
    public int getDamageProf() {
        return damage;
    }
    
    /**
     * Sets the damage of a professor
     * @param the damage of the professor
     */
    public void setDamageProf(final int damage) {
        this.damage = damage;
    }
    
    /**
     * Gets the position of the professors
     * @return the current position of the professors
     */
    public Elements<Integer, Integer> getPositionProf() {
        return position;
    } 
    
    /**
     * Updates the health when he gets attacked by a student.
     * If the health is less or equal to 0 then the students is destroyed.
     * @param damageReceived Value of the damage of the student.
     */
    public void receiveDamageProf(final int damageReceived) {
        healthPoints -= damageReceived;
    }

}
