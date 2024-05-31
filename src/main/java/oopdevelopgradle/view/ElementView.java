package oopdevelopgradle.view;

import oopdevelopgradle.model.Elements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The class ElementView implements the methods in order to display a element on
 * the grid pane.
 */
public class ElementView implements ElementViewInterface {
    private static final String EI_EXPOSE_REP = "EI_EXPOSE_REP";
    private final GridPane gridPane;
    /**
     * The image view used in this class.
     */
    private ImageView imageView;
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
    @SuppressFBWarnings({ EI_EXPOSE_REP })
    //Justification:this list is used to define the view of a selected element.
    public ElementView(final GridPane gridPane) {
        this.gridPane = gridPane;
    }
    /**
     * Retrieves the {@link GridPane} associated with this element.
     *
     * @return the {@link GridPane} associated with this element
     */
    public GridPane getGridPane() {
        return gridPane;
    }
    /**
     * Displays the element at the specified position on the grid pane.
     *
     * @param positionElement the element containing the position (x, y) where the image should be displayed
     */
    @Override
    public void displayElement(final Elements<Integer, Integer> positionElement) {
        final Image image = new Image(ElementView.class.getResourceAsStream(getImagePath()));
        setImageView(new ImageView(image));
        getImageView().setFitWidth(WIDTH);
        getImageView().setFitHeight(HEIGHT);
        gridPane.add(getImageView(), positionElement.getX(), positionElement.getY());
    }
    /**
     * Removes the image that is not needed for a student that is dead.
     */
    @Override
    public void removeElement() {
        gridPane.getChildren().remove(getImageView());
        getImageView().setImage(null); // Libera il riferimento all'immagine per consentire la pulizia della memoria
        setImageView(null); // Libera il riferimento all'imageView
    }
    /**
     * Needed to get the path of the image needed.
     * 
     * @return string path of the image
     */
    protected String getImagePath() {
        return "";
    }
    /**
     * Returns the image view used in this class.
     *
     * @return the current image view
     */
    public ImageView getImageView() {
        return imageView;
     }
     /**
     * Sets the image view to be used in this class.
     *
     * @param imageView the new image view to set
     */
     public void setImageView(final ImageView imageView) {
         this.imageView = imageView;
     }
}
