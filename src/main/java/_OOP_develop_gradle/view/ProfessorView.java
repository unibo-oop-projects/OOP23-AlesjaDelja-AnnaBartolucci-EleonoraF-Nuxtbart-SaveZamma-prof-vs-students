package _OOP_develop_gradle.view;


import javafx.scene.image.Image;
import java.awt.event.MouseEvent;

import _OOP_develop_gradle.model.Professor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ProfessorView {
	private ImageView imageView;
    private boolean isVisible;

    public ProfessorView() {
        // Inizialmente la pianta non è visibile
        isVisible = false;
        imageView = new ImageView(); // Creazione dell'immagine del professore
        // Carica l'immagine della pianta
		/*
		 * Image plantImage = new
		 * Image(getClass().getResourceAsStream("../img/prof.png")); imageView = new
		 * ImageView(plantImage);
		 */
        // Imposta un gestore di eventi per fare clic sulla griglia
        //imageView.setOnMouseClicked(this::placePlant);
    }

    // Metodo per posizionare la pianta sulla griglia quando viene cliccata
    private void placeProfessor(int col, int row) {
        if (!isVisible) {
            //  // Ottenere le coordinate del clic e impostare la posizione del professore sulla griglia
            GridPane.setColumnIndex(imageView, col);
            GridPane.setRowIndex(imageView, row);

            // Rendi l'immagine del professore visibile
            isVisible = true;
        }
    }

    // Metodo per ottenere l'ImageView della pianta
    /*public ImageView getImageProf(Professor prof) {
    	ImageView profImg = new ImageView();
    	profImg.setImage(new Image(getClass().getResource(prof.getPathImg()).toString()));
		return profImg;
    }*/

 // Metodo per ottenere l'ImageView del professore
    public ImageView getImageProf(Professor professor) {
        imageView.setImage(new Image(getClass().getResource(professor.getPathImgProf()).toString()));
        return imageView;
    }
    
    // Metodo per verificare se la pianta è visibile o meno
    public boolean isVisible() {
        return isVisible;
    }
}
