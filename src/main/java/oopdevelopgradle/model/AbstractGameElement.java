package oopdevelopgradle.model;

/**
 * The class AbstractGameElement provides a base implementation for game
 * elements.
 */
public abstract class AbstractGameElement implements GameElement {
    /**
     * used for the position of the element.
     */
    private Elements<Integer, Integer> position;
    /**
     * used for the damage of the element.
     */
    private int damage;

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
    /**
     * gets the position of an element.
     */
    @Override
    public Elements<Integer, Integer> getPosition() {
        return position;
    }
    /**
     * sets the position of an element.
     */
    @Override
    public void setPosition(final Elements<Integer, Integer> position) {
        this.position = position;
    }
    /**
     * gets the damage of an element.
     */
    @Override
    public int getDamage() {
        return damage;
    }
    /**
     * sets the damage of an element.
     */
    @Override
    public void setDamage(final int damage) {
        this.damage = damage;
    }
}
