package _OOP_develop_gradle.view;

import _OOP_develop_gradle.Elements;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class StudentView {
	private GridPane gridPane;
	private ImageView imageView;// DA METTERE L'ID PRESENTE IN QUELLO DELL'ANNA
	
	//Costructor
	 public StudentView(GridPane gridPane) {
	        this.gridPane = gridPane;
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
        gridPane.add(imageView, positionStudent.getX(),positionStudent.getY());
    }
	
	/**
	 * Removes the image that is not needed for a student that is dead
	 */
	public void removeStudent() {
		gridPane.getChildren().remove(imageView);
	}
	
	 public void attackStudents() {
	        // Salva l'immagine attuale
	        Image originalImage = imageView.getImage();

	        // Carica l'immagine per l'attacco
	        Image attackImage = new Image(getClass().getResourceAsStream("../img/attack.png")); //
	        imageView.setImage(attackImage);

	        // Crea una Timeline per ritornare all'immagine originale dopo 2 secondi
	        Timeline timeline = new Timeline(
	            new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
	                @Override
	                public void handle(ActionEvent event) {
	                    // Ritorna all'immagine originale dopo 2 secondi
	                    imageView.setImage(originalImage);
	                }
	            })
	        );
	        timeline.play(); // Avvia la Timeline
	    }
}
