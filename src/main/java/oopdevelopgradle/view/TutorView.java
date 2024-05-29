package oopdevelopgradle.view;

import javafx.scene.layout.GridPane;

/**
 * A view class for displaying a tutor's image.
 */
public class TutorView extends ElementView {
    /**
     * Constructor for TutorView.
     * 
     * @param gridPane The GridPane where the tutor view will be added.
     */
    public TutorView(final GridPane gridPane) {
        super(gridPane);
    }

    /**
     * Retrieves the path to the image file representing the tutor.
     * 
     * @return The path to the image file.
     */
    @Override
    protected String getImagePath() {
        return "/img/tutorNobg.png";
    }
}
