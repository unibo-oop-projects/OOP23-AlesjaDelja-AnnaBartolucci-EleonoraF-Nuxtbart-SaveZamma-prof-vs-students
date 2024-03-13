package _OOP_develop_gradle.view;

import _OOP_develop_gradle.Elements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class StudentView {
	private AnchorPane anchorPane;
	private ImageView imageView;// DA METTERE L'ID PRESENTE IN QUELLO DELL'ANNA
	
	 public StudentView(AnchorPane anchorPane) {
	        this.anchorPane = anchorPane;
	    }
	
	 /**
	 * Sets the image of the student when it will appear to the player
	 * @param positionStudent 
	 */
	
	public void displayStudent(Elements<Integer, Integer> positionStudent) {
        Image image = new Image(getClass().getResourceAsStream("../img/student.png"));

        imageView = new ImageView(image);
        // Imposta le dimensioni dell'ImageView DA METTERE APPOSTO
        imageView.setFitWidth(200); // Imposta la larghezza desiderata
        imageView.setFitHeight(200); // Imposta l'altezza desiderata
        
     // Imposta la posizione dell'ImageView
        imageView.setLayoutX(positionStudent.getX()); // Imposta la coordinata X
        imageView.setLayoutY(positionStudent.getY()); // Imposta la coordinata Y
        
        anchorPane.getChildren().add(imageView);
    }
	
	/**
	 * Removes the image that is not needed for a student that is dead
	 */
	public void removeStudent() {
		anchorPane.getChildren().remove(imageView);
	}
}
