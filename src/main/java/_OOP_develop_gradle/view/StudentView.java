package _OOP_develop_gradle.view;

import javafx.scene.layout.GridPane;

public class StudentView extends ElementView {
	
	//Variabe used to memorize relative path of the images of Students and when it attacks
	private String PATH_STUDENT = "/img/studenteNewNobg.png";
	//Costructs
    public StudentView(GridPane gridPane) {
        super(gridPane);
    }

    @Override
    protected String getImagePath() {
        return PATH_STUDENT;
    }
    

}
