package _OOP_develop_gradle.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class StudentView {
	private AnchorPane anchorPane;
	private ImageView imageView;// DA METTERE L'ID PRESENTE IN QUELLO DELL'ANNA
	
	/**
	 * Sets the image of the student when it will appear to the player
	 */
	
	public void displayStudent() {
        Image image = new Image(getClass().getResourceAsStream("../img/student.png"));

        imageView = new ImageView(image);
        // Imposta le dimensioni dell'ImageView
        imageView.setFitWidth(200); // Imposta la larghezza desiderata
        imageView.setFitHeight(200); // Imposta l'altezza desiderata

        anchorPane.getChildren().add(imageView);
    }
	
	/**
	 * Removes the image that is not needed for a student that is dead
	 */
	public void removeStudent() {
		anchorPane.getChildren().remove(imageView);
	}
}
