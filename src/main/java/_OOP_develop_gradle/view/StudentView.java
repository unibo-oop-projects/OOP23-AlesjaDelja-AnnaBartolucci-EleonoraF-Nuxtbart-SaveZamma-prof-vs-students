package _OOP_develop_gradle.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class StudentView {
	private AnchorPane anchorPane; // DA METTERE L'ID PRESENTE IN QUELLO DELL'ANNA
	
	/**
	 * Sets the image of the student when it will appear to the player
	 */
	
	public void displayStudent() {
        Image image = new Image(getClass().getResourceAsStream("../img/student.png"));

        ImageView imageView = new ImageView(image);
        // Imposta le dimensioni dell'ImageView
        imageView.setFitWidth(200); // Imposta la larghezza desiderata
        imageView.setFitHeight(200); // Imposta l'altezza desiderata

        anchorPane.getChildren().add(imageView);
    }
}
