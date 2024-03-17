package _OOP_develop_gradle.model;

public abstract class AbstractGameElement implements GameElement {
    protected Elements<Integer, Integer> position;
    protected int damage;
    protected int healthPoints;
    protected int energy;
    
//mettiamo gli healthpoints nel costruttore??
    public AbstractGameElement(int damage, int healthPoints, Elements<Integer, Integer> position, int energy) {
		super();
		this.position = position;
		this.damage = damage;
		this.healthPoints = healthPoints;
		this.energy = energy;
    }
    
    public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public Elements<Integer, Integer> getPosition() {
        return position;
    }

	public void setPosition(Elements<Integer, Integer> position) {
        this.position = position;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
