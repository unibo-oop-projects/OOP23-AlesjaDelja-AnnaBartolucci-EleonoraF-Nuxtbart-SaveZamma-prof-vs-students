package _OOP_develop_gradle.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;

public class StudentView extends ElementView {
	
	//Variabe used to memorize relative path of the images of Students and when it attacks
	private String PATH_STUDENT = "/img/student.png";
	private String PATH_ATTACK = "/img/attack.png";
	//Costructs
    public StudentView(GridPane gridPane) {
        super(gridPane);
    }

    @Override
    protected String getImagePath() {
        return PATH_STUDENT;
    }
    
    /**
     * Changes the image from students to attack and after 1s return to the original png.
     */
    public void attackStudents() {
        // Saves the current image.
        Image originalImage = imageView.getImage();

        // Changes the image so it attacks.
        Image attackImage = new Image(getClass().getResourceAsStream(PATH_ATTACK));
        imageView.setImage(attackImage);

        // Creates a new Timeline so it can return to the original after 1 second.
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    imageView.setImage(originalImage);
                }
            })
        );
        timeline.play(); // Starts the Timeline.
    }

}
