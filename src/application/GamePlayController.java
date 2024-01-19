package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.GamePlayModel.GameModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.Window;

public class GamePlayController {
	
	public static boolean gameStatus;
	private GamePlayModel gameModel;
	@FXML
    public AnchorPane GamePlayRoot;
	

	public void initialize() throws Exception {
		gameModel = new GamePlayModel();
	}
	
    @FXML
    public void initData() {
    	gameMatch();
    }

    public void gameMatch(){
    	try {
    		if(gameStatus) {
    			//handleStudentKilled(student); // chiamato quando uno studente viene ucciso
                //handleProfKilled(prof); // chiamato quando un professore viene ucciso
    			userWin();
    		}else {
    			userLost();
    		}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
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
	        MenuController controller = fxmlLoader.<MenuController>getController();
	        //controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
	        stage.show();
	    }

	    public void userLost() throws IOException{
	    	//carico il file fxml con la scritta hai perso
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LostGameView.fxml"));
	        Parent lostGame = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(lostGame));
	        MenuController controller = fxmlLoader.<MenuController>getController(); //controller uguale a quello del menu perchè ho gli stessi pulsanti
	        //controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
	        stage.show();
	    }
	    
	    public void userWin() throws IOException{
	    	//carico il file fxml con la scritta hai vinto
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WinGameView.fxml"));
	        Parent lostGame = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(lostGame));
	        MenuController controller = fxmlLoader.<MenuController>getController(); //controller uguale a quello del menu perchè ho gli stessi pulsanti
	        //controller.initData(GamePlayRoot, levelNumber,d,sunCount,allPlants, allZombies, allMowers, timeElapsed, l.getZombieList1(), l.getZombieList2());
	        stage.show();
	    }
	    
	    public void handleStudentKilled(GameModel.Student student, GameModel gameModel ) {
	        gameModel.increaseTimeTot(gameModel.getTimeTot());
	        gameModel.getStudentList().remove(student);
	        //gestire la view
	        //gameView.update(gameModel); ???

	    }

	    public void handleProfKilled(GameModel.Prof prof, GameModel gameModel ) {
	        gameModel.decreaseTimeTot(gameModel.getTimeTot());
	        gameModel.getProfList().remove(prof);
	        //gestire la view
	        //update(gameModel);

	    }
}
