package _OOP_develop_gradle;

import javafx.scene.layout.GridPane;

public class BulletView  extends ElementView{

	public BulletView(GridPane gridPane) {
		super(gridPane);
	}
	
	@Override
    protected String getImagePath() {
        return "/img/pea.png"; 
    }

}
