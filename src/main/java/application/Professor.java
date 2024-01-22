package main.java.application;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Professor {
    private String path;
    private ImageView imageView;
    private int healthPoints;
    private int column;
    private int row;

    public Professor(String path, int healthPoints, int column, int row) {
        this.path = path;
        this.healthPoints = healthPoints;
        this.column = column;
        this.row = row;
        this.imageView = createImageView();
    }

    private ImageView createImageView() {
        ImageView image = new ImageView(new Image(path));
        image.setFitWidth(50); // Imposta la larghezza desiderata
        image.setFitHeight(50); // Imposta l'altezza desiderata
        return image;
    }

    public void addToGrid(GridPane grid) {
        grid.add(imageView, column, row, 1, 1);
    }

    public void performAttack(Pane pane) {
        // Implementa la logica di attacco qui
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
        if (this.healthPoints <= 0) {
            removeProfessorFromGrid();
        }
    }

    public void endAnimation(Timeline timeline) {
        timeline.stop();
    }

    private void removeProfessorFromGrid() {
        // Implementa la logica di rimozione dalla griglia qui
        imageView.setVisible(false);
        imageView.setDisable(true);
    }
}
