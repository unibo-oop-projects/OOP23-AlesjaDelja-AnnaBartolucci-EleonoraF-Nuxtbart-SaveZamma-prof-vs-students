package _OOP_develop_gradle.view;

import _OOP_develop_gradle.model.Elements;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ElementView implements ElementViewInterface {
    protected GridPane gridPane;
    protected ImageView imageView;

    // Costruttore
    public ElementView(GridPane gridPane) {
        this.gridPane = gridPane;
    }
    @Override
    public void displayElement(Elements<Integer, Integer> positionElement) {
        Image image = new Image(getClass().getResourceAsStream(getImagePath()));

        imageView = new ImageView(image);
        // Impostare le dimensioni che siano adatte a quello che serve
        imageView.setFitWidth(100); 
        imageView.setFitHeight(50); 

        // Imposta la posizione dell'elemento
        gridPane.add(imageView, positionElement.getX(), positionElement.getY());
    }

    @Override
    public void removeElement() {
        gridPane.getChildren().remove(imageView);
    }

    /**
     * Needed to get the path of the image needed
     * @return the path of the image
     */
    protected String getImagePath() {
        // Ritorna il percorso dell'immagine (da implementare)
        return "";
    }
}
