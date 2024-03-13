package _OOP_develop_gradle;


import javax.swing.text.html.ImageView;

import _OOP_develop_gradle.model.Professor;
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
	
	private static final int GRID_SIZE = 8; // Dimensione della griglia (8x8)
    private static final int CELL_SIZE = 50; // Dimensione di ciascuna cella della griglia

    private GridPane gameGrid;
		@Override
		public void start(Stage primaryStage) {
			try {
				addMusic();
				Parent mainPage=FXMLLoader.load(getClass().getResource("GameView.fxml"));
		        Scene scene = new Scene(mainPage,1024,600);
		        primaryStage.setTitle("Prof VS Students");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		        
		        // Creazione del layout di gioco (griglia 8x8)
	            gameGrid = new GridPane();
	            gameGrid.setPrefSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
	            gameGrid.setHgap(1);
	            gameGrid.setVgap(1);
	            
	            // Aggiunta del gestore degli eventi per il click dell'utente
	            gameGrid.setOnMouseClicked(event -> {
	                // Ottenere le coordinate del click
	                int col = (int) (event.getX() / CELL_SIZE);
	                int row = (int) (event.getY() / CELL_SIZE);
	                
	                // Aggiungere il professore alla posizione cliccata
	                addProfessorToGrid(col, row);
	            });
				/*BorderPane root = new BorderPane();
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();*/
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
		// Metodo per aggiungere un professore al layout di gioco nella posizione specificata
	    private void addProfessorToGrid(int col, int row) {
	        // Costruire l'immagine del professore
	        String professorImagePath = "prof.jpg"; // Percorso dell'immagine del professore
	        Professor professor = new Professor(10, 100, new Elements<>(col, row), professorImagePath, 50, 1);
	        ImageView professorImageView = professor.getImageProf(professor);
	        
	        // Aggiungere il professore al layout di gioco
	        gameGrid.add(professorImageView, col, row);
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
