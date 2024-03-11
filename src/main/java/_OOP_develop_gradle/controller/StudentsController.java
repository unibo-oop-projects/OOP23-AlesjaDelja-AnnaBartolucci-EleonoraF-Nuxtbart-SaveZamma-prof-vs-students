package _OOP_develop_gradle.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import java.util.Random;

public class StudentsController extends Application {

    private static final int GRID_SIZE = 3;
    private static final int CELL_SIZE = 100;
    private static final int SPEED = 1;

    private int blockX;
    private int blockY;
    private Rectangle block;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        Random random = new Random();
        blockX = random.nextInt(GRID_SIZE);
        blockY = random.nextInt(GRID_SIZE);

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.BLACK);
                gridPane.add(cell, col, row);
            }
        }

        block = new Rectangle(CELL_SIZE, CELL_SIZE, Color.RED);
        gridPane.add(block, blockX, blockY);

        Scene scene = new Scene(gridPane, GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Grid With Moving Block");
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 1_000_000_000 / SPEED) {
                    moveBlock();
                    lastUpdate = now;
                }
            }
        };
        timer.start();
    }

    private void moveBlock() {
        if (blockX > 0) {
            blockX--;
        } else {
            // If block reaches the start of the grid, reset its position to a random row and the last column
            //Da mettere apposto
            Random random = new Random();
            blockX = GRID_SIZE - 1;
            blockY = random.nextInt(GRID_SIZE);
        }

        block.relocate(blockX * CELL_SIZE, blockY * CELL_SIZE);
    }
}
