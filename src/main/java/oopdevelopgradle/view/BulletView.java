package oopdevelopgradle.view;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import oopdevelopgradle.model.Elements;
import javafx.scene.layout.GridPane;

public class BulletView  extends ElementView{

	public BulletView(final GridPane gridPane) {
		super(gridPane);
	}
	
	@Override
    protected String getImagePath() {
		return "/img/pea.png"; 
    }
	
	@Override
	public void displayElement(final Elements<Integer, Integer> positionElement) {
		 final Image image = new Image(getClass().getResourceAsStream(getImagePath()));

	        imageView = new ImageView(image);
	        // Impostare le dimensioni che siano addatte a quello che serve
	        imageView.setFitWidth(20); 
	        imageView.setFitHeight(20); 
	        
	     // Sets the position of student
	        gridPane.add(imageView, positionElement.getX(),positionElement.getY());
	}
}
