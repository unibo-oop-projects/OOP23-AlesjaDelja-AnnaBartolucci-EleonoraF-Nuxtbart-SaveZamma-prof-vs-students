package oopdevelopgradle.model;
/**
 * The interface GameElement provides methods to interact 
 * with the game elements during a match.
 */
public interface GameElement {
	/**
	 * *  Gets the position of an element.
	 * * @return position
	 */
	Elements<Integer, Integer> getPosition();
    /**
     * Sets the position of an element.
     * @param position
     */
    void setPosition(Elements<Integer, Integer> position);
    /**
     * Gets the damage of the element.
     * @return damage the damage suffered
     */
    int getDamage();
    /**
     * Sets the damage of the element.
     * @param damage
     */
    void setDamage(int damage);
}
