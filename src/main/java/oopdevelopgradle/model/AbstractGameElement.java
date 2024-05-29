package oopdevelopgradle.model;

/**
 * The class AbstractGameElement provides a base implementation for game
 * elements.
 */
public abstract class AbstractGameElement implements GameElement {
    protected Elements<Integer, Integer> position;
    protected int damage;

    /**
     * Constructor of an abstract game element.
     * 
     * @param damage   the damage of the element.
     * @param position the position of the element.
     */
    public AbstractGameElement(final int damage, final Elements<Integer, Integer> position) {
        super();
        this.position = position;
        this.damage = damage;
    }

    @Override
    public Elements<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public void setPosition(final Elements<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(final int damage) {
        this.damage = damage;
    }
}
