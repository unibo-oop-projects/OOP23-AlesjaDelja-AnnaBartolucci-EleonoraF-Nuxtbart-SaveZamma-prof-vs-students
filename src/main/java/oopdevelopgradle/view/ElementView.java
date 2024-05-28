package oopdevelopgradle.view;

import oopdevelopgradle.model.Elements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ElementView implements ElementViewInterface {
    protected GridPane gridPane;
    protected ImageView imageView;

    // Costruttore
    public ElementView(final GridPane gridPane) {
        this.gridPane = gridPane;
    }
    @Override
    public void displayElement(final Elements<Integer, Integer> positionElement) {
        final Image image = new Image(getClass().getResourceAsStream(getImagePath()));

        imageView = new ImageView(image);
        // Impostare le dimensioni che siano adatte a quello che serve
        imageView.setFitWidth(100); 
        imageView.setFitHeight(50); 

        // Imposta la posizione dell'elemento
        gridPane.add(imageView, positionElement.getX(), positionElement.getY());
    }

	/**
	 * Removes the image that is not needed for a student that is dead
	 */
    @Override
	public void removeElement() {
		gridPane.getChildren().remove(imageView);
		//Image image = imageView.getImage();
	    imageView.setImage(null); // Libera il riferimento all'immagine per consentire la pulizia della memoria
	    imageView = null; // Libera il riferimento all'imageView
	    
	}
	
	/**
	 * Needed to get the path of the image needed
	 * @return
	 */
	protected String getImagePath() {

        return "";
    }
}
