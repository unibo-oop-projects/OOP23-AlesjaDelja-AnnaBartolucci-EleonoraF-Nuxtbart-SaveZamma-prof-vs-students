package _OOP_develop_gradle.view;

import _OOP_develop_gradle.Elements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class StudentView {
	private AnchorPane anchorPane;
	private ImageView imageView;// DA METTERE L'ID PRESENTE IN QUELLO DELL'ANNA
	
	//Costructor
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
        // Impostare le dimensioni che siano addatte a quello che serve
        imageView.setFitWidth(200); 
        imageView.setFitHeight(200); 
        
     // Sets the position of student
        imageView.setLayoutX(positionStudent.getX()); 
        imageView.setLayoutY(positionStudent.getY()); 
        
        anchorPane.getChildren().add(imageView);
    }
	
	/**
	 * Removes the image that is not needed for a student that is dead
	 */
	public void removeStudent() {
		anchorPane.getChildren().remove(imageView);
	}
}
