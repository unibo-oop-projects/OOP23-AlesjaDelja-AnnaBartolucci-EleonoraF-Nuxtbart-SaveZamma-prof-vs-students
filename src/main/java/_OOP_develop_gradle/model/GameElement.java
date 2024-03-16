package _OOP_develop_gradle.model;

public interface GameElement {
	/**
	 *  Gets the position of an element.
	 * @return
	 */
    Elements<Integer, Integer> getPosition();
    
    /**
     * Checks if a element is alive.
     * @return
     */
    boolean isAlive();
    /**
     * Gets the name of an element.
     * @return
     */
    String getName();
    /**
     * Gets the damage of the element.
     * @return
     */
    int getDamage();
}
