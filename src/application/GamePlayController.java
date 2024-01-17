package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class GamePlayController {

	 @FXML
	    private void handleMouseClick(MouseEvent event) {
	        int columnIndex = GridPane.getColumnIndex((Region) event.getSource());
	        int rowIndex = GridPane.getRowIndex((Region) event.getSource());

	        System.out.println("Clicked at column " + columnIndex + " and row " + rowIndex);
	    }
	 

	    @FXML
	    void GameMenu(MouseEvent event) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
	        Parent gameMenu = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(gameMenu));
	        //GameMenuController controller = fxmlLoader.<GameMenuController>getController();
	        //controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
	        stage.show();
	    }

}
