package _OOP_develop_gradle.view;

import _OOP_develop_gradle.Elements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ElementView {
	private GridPane gridPane;
	private ImageView imageView;// DA METTERE L'ID PRESENTE IN QUELLO DELL'ANNA
	
	//Costructor
	 public ElementView(GridPane gridPane) {
	        this.gridPane = gridPane;
	    }
	
	 /**
	 * Sets the image of the element when it will appear to the player
	 * @param positionStudent 
	 */
	
	public void displayStudent(Elements<Integer, Integer> positionElement) {
        Image image = new Image(getClass().getResourceAsStream(getImagePath()));

        imageView = new ImageView(image);
        // Impostare le dimensioni che siano addatte a quello che serve
        imageView.setFitWidth(200); 
        imageView.setFitHeight(200); 
        
     // Sets the position of student
        gridPane.add(imageView, positionElement.getX(),positionElement.getY());
    }
	
	/**
	 * Removes the image that is not needed for a student that is dead
	 */
	public void removeElement() {
		gridPane.getChildren().remove(imageView);
	}
	
	/**
	 * Needed to get the path of the image needed
	 * @return
	 */
	protected String getImagePath() {
        return "";
	}
}