package _OOP_develop_gradle.view;

import javafx.scene.image.Image;
import java.awt.event.MouseEvent;

import _OOP_develop_gradle.model.Professor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TutorView extends ElementView{
	
	public TutorView(GridPane gridPane) {
        super(gridPane);
    }

	@Override
    protected String getImagePath() {
        return "../img/student.png"; // Ritorna il percorso dell'immagine dello studente
    }
        
}
