package oopdevelopgradle.view;

import javafx.scene.layout.GridPane;

/**
 * The class StudentView is used to show the student image on the grid pane.
 */
public class StudentView extends ElementView {
    private static final String PATH_STUDENT = "/img/studenteNewNobg.png";

    /**
     * Constructor for StudentView.
     * 
     * @param gridPane The GridPane where the student view will be added.
     */
    public StudentView(final GridPane gridPane) {
        super(gridPane);
    }

    /**
     * Retrieves the path to the image file representing the student.
     * 
     * @return PATH_STUDENT The path to the image file.
     */
    @Override
    protected String getImagePath() {
        return PATH_STUDENT;
    }
}
