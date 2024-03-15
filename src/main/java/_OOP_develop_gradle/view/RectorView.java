package _OOP_develop_gradle.view;

import javafx.scene.layout.GridPane;
/**
 * A view class for displaying a rector's image.
 */
public class RectorView extends ElementView{

	/**
     * Constructor for RectorView.
     * @param gridPane The GridPane where the rector view will be added.
     */
	public RectorView(GridPane gridPane) {
		super(gridPane);
	}
	
	/**
     * Retrieves the path to the image file representing the rector.
     * @return The path to the image file.
     */
	@Override
    protected String getImagePath() {
		return "/img/rectorNobg.png";
    }

}
