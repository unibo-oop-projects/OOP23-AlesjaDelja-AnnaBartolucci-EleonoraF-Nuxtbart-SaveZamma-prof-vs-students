package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
	public static MediaPlayer mediaPlayer;
	private GridPane gridPane;
    private ProfessorView plantView;
	
	@Override
	public void start(Stage primaryStage) {
		//gridPane = new GridPane();

        // Ipotizziamo che tu abbia un'istanza di PlantView chiamata plantView
        // e che imagePath sia il percorso dell'immagine associata alla nuova pianta
     // Crea un'istanza di PlantView
    /*   plantView = new ProfessorView("path_to_default_plant_image");

     // Aggiungi la PlantView alla griglia
        gridPane.add(plantView, 0, 0);

     // Aggiungi diversi personaggi alla griglia
        addCharacter("Character 1", "path_to_character1_image");
        addCharacter("Character 2", "path_to_character2_image");
        addCharacter("Character 3", "path_to_character3_image");

     // Imposta un gestore eventi per il cambio del personaggio al clic del mouse
        plantView.setOnMouseClicked(event -> {
            // Simula il cambio del personaggio (puoi ottenere questa informazione dalla tua interfaccia utente)
            String selectedCharacter = "Character 2";  // Cambia questo valore in base alla tua logica di selezione
            changeCharacter(selectedCharacter);
        });
        */
       /* Scene scenes = new Scene(gridPane, 800, 600);
        primaryStage.setScene(scenes);
        primaryStage.show();*/
        
        
		
		try {
			addMusic();
			
			Parent mainPage=FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
	        Scene scene = new Scene(mainPage,1024,600);
	        primaryStage.setTitle("Plants VS Zombies");
	        primaryStage.setScene(scene);
	        primaryStage.show();
			
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
	
	// Metodo per aggiungere un personaggio alla griglia
    private void addCharacter(String characterName, String imagePath) {
        ProfessorView characterView = new ProfessorView(imagePath);
        gridPane.add(characterView, 0, 0);

        // Aggiungi un gestore eventi per il clic del mouse su questo personaggio
        characterView.setOnMouseClicked(event -> changeCharacter(characterName));
    }
	
	// Metodo per cambiare il personaggio selezionato
    private void changeCharacter(String character) {
        // In base al personaggio selezionato, imposta l'immagine corrispondente
        switch (character) {
            case "character1":
                plantView.setPlantImage("path_to_character1_image");
                break;
            case "character2":
                plantView.setPlantImage("path_to_character2_image");
                break;
            case "character3":
                plantView.setPlantImage("path_to_character3_image");
                break;
            // Aggiungi altri personaggi se necessario
            default:
                // Gestione del caso di default o errore
                break;
        }
    }

}
