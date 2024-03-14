package _OOP_develop_gradle.view;

import javafx.scene.layout.GridPane;

public class RectorView extends ElementView{

	public RectorView(GridPane gridPane) {
		super(gridPane);
	}
	
	@Override
    protected String getImagePath() {
        return "_OOP_develop_gradle/img/rectorNobg.png";
    }

}
