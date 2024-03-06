package _OOP23_prof_vs_students;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXAppWithFXML extends Application {

    @Override
    public final void start(final Stage primaryStage) throws Exception {
    	
    	// Percorso dell'immagine
        String imagePath = "src/main/img/exitButton.jpg"; // Sostituisci con il percorso effettivo della tua immagine
        
        // Creare un oggetto File per verificare l'esistenza dell'immagine
        File imageFile = new File(imagePath);
        
        // Verificare se l'immagine esiste
        if (imageFile.exists()) {
            System.out.println("Il percorso dell'immagine è corretto: " + imagePath);
        } else {
            System.out.println("Il percorso dell'immagine non esiste o non è corretto: " + imagePath);
        }
    	
    	System.out.println(ClassLoader.getSystemResource("SimpleGui2.fxml"));
	    Parent root = FXMLLoader.load(ClassLoader.getSystemResource("SimpleGui2.fxml"));
	    Scene scene = new Scene(root, 1024, 800);
	    //Label label = (Label) scene.lookup("#myLabel");
        //label.setText(".........................");
        primaryStage.setTitle("App FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void run(final String[] args) {
        launch(args);
    }

    /**
     * Entry point class.
     */
    public static final class Main {
        private Main() {
            // the constructor will never be called directly.
        }

        /**
         * Program's entry point.
         * @param args
         */
        public static void main(final String... args) {
            JavaFXAppWithFXML.run(args);
        }
    }

    static class AnotherStage extends Stage {
        private static final int SCENE_WIDTH = 100;
        private static final int SCENE_HEIGHT = 500;

        AnotherStage() {
            super();
            setTitle("New stage created at " + System.currentTimeMillis());
            final VBox pane = new VBox();
            pane.getChildren().add(new Label("First label"));
            pane.getChildren().add(new Label("Second label"));
            setScene(new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT));
        }
    }
}