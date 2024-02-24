package application;

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
    private GridPane gridPane;
    private ProfessorView plantView;

    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();

        // Ipotizziamo che tu abbia un'istanza di PlantView chiamata plantView
        // e che imagePath sia il percorso dell'immagine associata alla nuova pianta
        // Crea un'istanza di PlantView
        plantView = new ProfessorView("path_to_default_plant_image");

        // Aggiungi la PlantView alla griglia
        gridPane.add(plantView, 0, 0);

        // Creazione di un'istanza di CharacterChoiceTable e aggiunta alla griglia
        CharacterChoiceTable characterChoiceTable = new CharacterChoiceTable(plantView);
        gridPane.add(characterChoiceTable, 1, 0);

        Scene scenes = new Scene(gridPane, 800, 600);
        primaryStage.setScene(scenes);
        primaryStage.show();

        try {
            addMusic();
            Parent mainPage = FXMLLoader.load(getClass().getResource("GameView.fxml"));
            Scene scene = new Scene(mainPage, 1024, 600);
            primaryStage.setTitle("Prof VS Students");
            primaryStage.setScene(scene);
            primaryStage.show();

            /*
             * BorderPane root = new BorderPane();
             * Scene scene = new Scene(root,400,400);
             * scene.getStylesheets().add(getClass().getResource("application.css").
             * toExternalForm());
             * primaryStage.setScene(scene);
             * primaryStage.show();
             */
        } catch (Exception e) {
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

    // ELE?
    // Metodo per aggiungere un personaggio alla griglia
    private void addCharacter(String characterName, String imagePath) {
        ProfessorView characterView = new ProfessorView(imagePath);
        gridPane.add(characterView, 0, 0);

        // Aggiungi un gestore eventi per il clic del mouse su questo personaggio
        characterView.setOnMouseClicked(event -> changeCharacter(characterName));
    }

    // ELE
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
