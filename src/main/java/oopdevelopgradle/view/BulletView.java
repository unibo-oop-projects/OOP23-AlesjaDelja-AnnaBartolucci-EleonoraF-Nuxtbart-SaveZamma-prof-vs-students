package oopdevelopgradle.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import oopdevelopgradle.model.Elements;
import javafx.scene.layout.GridPane;

/**
 * The class BulletView implements the methods of ElementView in order to
 * display a bullet on the grid pane.
 */
public class BulletView extends ElementView {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    /**
     * Constructor for BulletView.
     * 
     * @param gridPane The GridPane where the bullet view will be added.
     */
    public BulletView(final GridPane gridPane) {
        super(gridPane);
    }

    /**
     * Retrieves the path to the image file representing the bullet.
     * 
     * @return String The path to the image file.
     */
    @Override
    protected String getImagePath() {
        return "/img/pea.png";
    }

    /**
     * Displays the bullet image when it appears on the grid pane.
     * 
     * @param positionElement the position of the bullet
     */
    @Override
    public void displayElement(final Elements<Integer, Integer> positionElement) {
        final Image image = new Image(getClass().getResourceAsStream(getImagePath()));
        imageView = new ImageView(image);
        // Impostare le dimensioni che siano addatte a quello che serve
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);
        // Sets the position of student
        getGridPane().add(imageView, positionElement.getX(), positionElement.getY());
    }
}
