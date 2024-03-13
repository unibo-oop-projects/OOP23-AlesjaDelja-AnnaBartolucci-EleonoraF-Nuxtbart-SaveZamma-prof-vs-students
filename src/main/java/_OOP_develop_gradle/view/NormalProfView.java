package _OOP_develop_gradle.view;

import javafx.scene.layout.GridPane;

public class NormalProfView extends ElementView{

	public NormalProfView(GridPane gridPane) {
		super(gridPane);
	}

	@Override
    protected String getImagePath() {
        return "../img/student.png"; // Ritorna il percorso dell'immagine dello studente
    }
}
