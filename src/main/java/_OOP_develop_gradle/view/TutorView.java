package _OOP_develop_gradle.view;

import javafx.scene.image.Image;
import java.awt.event.MouseEvent;

import _OOP_develop_gradle.model.Professor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
/**
 * A view class for displaying a tutor's image.
 */
public class TutorView extends ElementView{
	
	/**
     * Constructor for TutorView.
     * @param gridPane The GridPane where the tutor view will be added.
     */
	public TutorView(GridPane gridPane) {
        super(gridPane);
    }

	/**
     * Retrieves the path to the image file representing the tutor.
     * @return The path to the image file.
     */
	@Override
    protected String getImagePath() {
        return "_OOP_develop_gradle/img/tutorNobg.png"; 
    }
        
}
