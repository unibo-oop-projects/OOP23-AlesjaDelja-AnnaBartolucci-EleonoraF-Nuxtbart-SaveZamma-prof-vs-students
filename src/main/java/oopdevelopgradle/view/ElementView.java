package oopdevelopgradle.view;

import oopdevelopgradle.model.Elements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * The class ElementView implements the methods in order to display a element on
 * the grid pane.
 */
public class ElementView implements ElementViewInterface {
    private GridPane gridPane;
    /**
     * Retrieves the {@link GridPane} associated with this element.
     *
     * @return the {@link GridPane} associated with this element
     */
    public GridPane getGridPane() {
		return gridPane;
	}
    /**
     * Sets the {@link GridPane} for this element.
     *
     * @param gridPane the {@link GridPane} to set
     */
	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}
	/**
     * The image view used in this class.
     */
	protected ImageView imageView;
	/**
     * The width of the element.
     */
    private static final int WIDTH = 100;
    /**
     * The height of the element.
     */
    private static final int HEIGHT = 50;

    /**
     * Constructor for ElementView.
     * 
     * @param gridPane The GridPane where the element view will be added.
     */
    public ElementView(final GridPane gridPane) {
        this.gridPane = gridPane;
    }

    @Override
    public void displayElement(final Elements<Integer, Integer> positionElement) {
        final Image image = new Image(getClass().getResourceAsStream(getImagePath()));
        imageView = new ImageView(image);
        // Impostare le dimensioni che siano adatte a quello che serve
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);
        // Imposta la posizione dell'elemento
        gridPane.add(imageView, positionElement.getX(), positionElement.getY());
    }

    /**
     * Removes the image that is not needed for a student that is dead.
     */
    @Override
    public void removeElement() {
        gridPane.getChildren().remove(imageView);
        imageView.setImage(null); // Libera il riferimento all'immagine per consentire la pulizia della memoria
        imageView = null; // Libera il riferimento all'imageView
    }

    /**
     * Needed to get the path of the image needed.
     * 
     * @return string path of the image
     */
    protected String getImagePath() {
        return "";
    }
}
