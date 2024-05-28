package oopdevelopgradle.model;

public abstract class AbstractGameElement implements GameElement {
    protected Elements<Integer, Integer> position;
    protected int damage;
    
//mettiamo gli healthpoints nel costruttore??
    public AbstractGameElement(int damage, Elements<Integer, Integer> position) {
		super();
		this.position = position;
		this.damage = damage;
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
