package _OOP_develop_gradle;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
	public static MediaPlayer mediaPlayer;
	
		@Override
		public void start(Stage primaryStage) {
			try {
				addMusic();
				Parent mainPage=FXMLLoader.load(getClass().getResource("GameView.fxml"));
		        Scene scene = new Scene(mainPage,1024,600);
		        primaryStage.setTitle("Prof VS Students");
		        primaryStage.setScene(scene);
		        primaryStage.show();
				
				/*BorderPane root = new BorderPane();
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();*/
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
		public void addMusic() {
	        Media sound = new Media(getClass().getResource("/music/background.wav").toString());
	        mediaPlayer = new MediaPlayer(sound);
	        mediaPlayer.setAutoPlay(true);
	        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	        mediaPlayer.setStartTime(Duration.seconds(0));
	        mediaPlayer.setStopTime(Duration.seconds(50));
	        mediaPlayer.play();
	    }
	
}
