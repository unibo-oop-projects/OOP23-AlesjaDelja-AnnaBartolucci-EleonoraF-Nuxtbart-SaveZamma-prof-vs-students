package oopdevelopgradle.view;

import oopdevelopgradle.model.Elements;

public interface ElementViewInterface {

    /**
     * Displays the element image when it appears to the player.
     * @param positionElement the position of the element
     */
    void displayElement(Elements<Integer, Integer> positionElement);

    /**
     * Removes the image of the element.
     */
    void removeElement();
}
