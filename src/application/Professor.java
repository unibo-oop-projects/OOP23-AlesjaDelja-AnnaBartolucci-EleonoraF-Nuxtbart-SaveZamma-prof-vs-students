package application;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import application.GamePlayController;

public class Professor {
	
	public int sunUse;
	protected int WIDTH;
    protected int HEIGHT;
    private String path;
    GamePlayController gameplay;
    private ImageView imageView;
    private int healthPoints;
    private int column;
    private int row;

    public Professor(String path, int healthPoints, int column, int row, int sunUse, GamePlayController gameplay) {
        this.path = path;
        this.healthPoints = healthPoints;
        this.column = column;
        this.row = row;
        this.gameplay = gameplay;
        this.sunUse = sunUse;
        this.imageView = createImageView();
        this.setSize(WIDTH, HEIGHT);
        this.setOpaque(false);
        this.setVisible(true);
        redrawTimer = new Timer(25, (ActionEvent) -> repaint());
        redrawTimer.start();
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
    
  //getter
    public GamePlayController getGamePlay() {
        return gameplay;
    }
    public int getSunUse() {
        return sunUse;
    }
}
