package _OOP_develop_gradle.view;

import javafx.scene.layout.GridPane;

public class BulletView  extends ElementView{

	public BulletView(GridPane gridPane) {
		super(gridPane);
	}
	
	@Override
    protected String getImagePath() {
		return "/img/pea.png"; 
    }
	
	// Metodo per ottenere un'immagine ridimensionata
    private Image getResizedImage() {
        Image image = new Image(getImagePath());
        // Definisci la nuova larghezza e altezza desiderata per l'immagine
        double newWidth = 20; // Nuova larghezza desiderata
        double newHeight = 20; // Nuova altezza desiderata
        // Crea un'ImageView per l'immagine e imposta le nuove dimensioni
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(newWidth);
        imageView.setFitHeight(newHeight);
        // Restituisci l'immagine ridimensionata
        return imageView.snapshot(null, null);
    }

}
