package oopdevelopgradle.model;

public abstract class AbstractGameElement implements GameElement {
    protected Elements<Integer, Integer> position;
    protected int damage;
//mettiamo gli healthpoints nel costruttore??
    public AbstractGameElement(final int damage, final Elements<Integer, Integer> position) {
		super();
		this.position = position;
		this.damage = damage;
    }

	public Elements<Integer, Integer> getPosition() {
        return position;
    }
	public void setPosition(final Elements<Integer, Integer> position) {
        this.position = position;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(final int damage) {
        this.damage = damage;
    }
}
