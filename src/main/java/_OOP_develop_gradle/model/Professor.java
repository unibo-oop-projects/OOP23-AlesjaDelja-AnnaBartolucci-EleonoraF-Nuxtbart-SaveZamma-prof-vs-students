package _OOP_develop_gradle.model;


public class Professor extends AbstractGameElement{
    
    private int energyProfessor;
    private boolean isAttacked;
    private int damage;
    private final Elements<Integer, Integer> position;
    private int healthPoints;
    public String pathImgP;
    public int id;
    
    /**
     * Constructor for creating a Professor object.
     *
     * @param damage The damage inflicted by the professor.
     * @param healthPoints The health points of the professor.
     * @param position The position of the professor on the game grid.
     * @param pathImgP The path to the image representing the professor.
     * @param costProfessor The cost to buy the professor.
     * @param id The unique identifier of the professor.
     */
    public Professor(int damage, int healthPoints, Elements<Integer, Integer> position, int energyProfessor) {
          super(damage, position);
		  this.damage = damage; 
		  this.healthPoints = healthPoints; 
		  this.position =position; 
		  this.energyProfessor = energyProfessor; 
		  this.isAttacked = false;
		 
    }

    public boolean isAttacked() {
		return isAttacked;
	}

	public void setAttacked(boolean isAttacked) {
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
    public void setHealthPointsProf(int healthPoints) { 
        this.healthPoints = healthPoints; 
    }
     
    /**
     * Gets the costProfessor of a professor
     * @return the costProfessor of the professor
     */
	
	  public int getEnergyProfessor() { return energyProfessor; }
	 
    
    /**
     * Sets the costProfessor of a professor
     * @param the costProfessor value of the professor
     */
	
	  public void setEnergyProfessor(int energyProfessor) { this.energyProfessor =
	  energyProfessor; }
	 
    
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
    public void setDamageProf(int damage) {
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
    public void receiveDamageProf(int damageReceived) {
        healthPoints -= damageReceived;
    }

}
