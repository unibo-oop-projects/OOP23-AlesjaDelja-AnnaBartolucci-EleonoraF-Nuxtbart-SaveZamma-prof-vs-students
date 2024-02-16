package application;

import java.awt.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ProfessorView extends Pane {
    private ImageView imageView;

    public ProfessorView(String imagePath) {
        //imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        getChildren().add(imageView);
    }
    
 // Aggiungi questo metodo per cambiare l'immagine della pianta
    public void setPlantImage(String imagePath) {
        //imageView.setImage(new Image(imagePath));
    }
}
