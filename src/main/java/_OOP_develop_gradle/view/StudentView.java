package _OOP_develop_gradle.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;

public class StudentView extends ElementView {

	private String PATH_STUDENT = "../img/student.png";
	private String PATH_ATTACK = "../img/attack.png";
    public StudentView(GridPane gridPane) {
        super(gridPane);
    }

    @Override
    protected String getImagePath() {
        return PATH_STUDENT; // Ritorna il percorso dell'immagine dello studente
    }

    public void attackStudents() {
        // Salva l'immagine attuale
        Image originalImage = imageView.getImage();

        // Carica l'immagine per l'attacco
        Image attackImage = new Image(getClass().getResourceAsStream(PATH_ATTACK));
        imageView.setImage(attackImage);

        // Crea una Timeline per ritornare all'immagine originale dopo 2 secondi
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
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
