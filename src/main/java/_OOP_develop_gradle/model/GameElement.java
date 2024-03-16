package _OOP_develop_gradle.model;

public interface GameElement {
	/**
	 *  Gets the position of an element.
	 * @return position
	 */
    Elements<Integer, Integer> getPosition();
    /**
     * Sets the position of an element.
     * @param position
     */
    void setPosition(Elements<Integer, Integer> position);
    
    /**
     * Gets the damage of the element.
     * @return
     */
    int getDamage();
    /**
     * Sets the damage of the element.
     * @param damage
     */
    void setDamage(int damage);
}
