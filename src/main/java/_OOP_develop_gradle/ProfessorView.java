package _OOP_develop_gradle;


import javafx.scene.image.Image;
import java.awt.event.MouseEvent;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ProfessorView extends ImageView{
	//private ImageView imageView;
    private boolean isVisible;

    public ProfessorView(String imagePath) {
        // Inizialmente la pianta non è visibile
        isVisible = false;
        // Carica l'immagine della pianta
		/*
		 * Image plantImage = new
		 * Image(getClass().getResourceAsStream("../img/prof.png")); imageView = new
		 * ImageView(plantImage);
		 */
        // Imposta un gestore di eventi per fare clic sulla griglia
        //imageView.setOnMouseClicked(this::placePlant);
        setImage(new Image(ProfessorView.class.getResource(imagePath).toString()));
        setFitWidth(50);
        setFitHeight(50);

        // Aggiungi un gestore per il click per posizionare il professore sulla griglia
        setOnMouseClicked(this::placeProfessor);
    }

    // Metodo per posizionare la pianta sulla griglia quando viene cliccata
    private void placePlant(MouseEvent event) {
        if (!isVisible) {
            // Ottenere le coordinate del clic
            int col = (int) (event.getX() / 50); // Supponiamo che ogni cella sia larga 50 pixel
            int row = (int) (event.getY() / 50); // Supponiamo che ogni cella sia alta 50 pixel

            // Imposta la posizione del professor sulla griglia
            GridPane.setColumnIndex(this, col);
            GridPane.setRowIndex(this, row);

            // Rendi il professor visibile
            isVisible = true;
        }
    }

    // Metodo per ottenere l'ImageView della pianta
    /*public ImageView getImageProf(Professor prof) {
    	ImageView profImg = new ImageView();
    	profImg.setImage(new Image(getClass().getResource(prof.getPathImg()).toString()));
		return profImg;
    }*/

    // Metodo per verificare se la pianta è visibile o meno
    public boolean isVisible() {
        return isVisible;
    }
}
