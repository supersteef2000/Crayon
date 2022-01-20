package frl.suk.crayon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class CrayonMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Initialising variables
        int width = 100;
        int height = 100;
        // TODO: Allow zooming with scroll wheel/buttons
        int zoom = 5;
        Group group = new Group();

        // Creating the scene and stage
        // TODO: Add menu bar with save, save as, open, number of different tools
        Scene scene = new Scene(group, width * zoom, height * zoom);
        stage.setTitle("Crayon");
        CreateNewImage rects = new CreateNewImage();
        Rectangle[][] image = rects.image(width, height, zoom, group);
        stage.setScene(scene);
        stage.show();

        // Colour picker
        // TODO: Make proper colour picker
        AtomicReference<Color> color = new AtomicReference<>(Color.BLACK);
        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case DIGIT1 -> color.set(Color.RED);
                case DIGIT2 -> color.set(Color.GREEN);
                case DIGIT3 -> color.set(Color.BLUE);
                case DIGIT4 -> color.set(Color.YELLOW);
                case DIGIT5 -> color.set(Color.BLACK);
                case DIGIT6 -> color.set(Color.WHITE);
                case DIGIT7 -> color.set(Color.TRANSPARENT);
            }
        });

        // Change colour of the clicked square to the colour selected above
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int finalI = i;
                int finalJ = j;
                // TODO: Figure out a way to allow dragging
                image[i][j].setOnMousePressed(mouseEvent -> image[finalI][finalJ].setFill(color.get()));
                //image[i][j].setOnMouseEntered(mouseEvent -> image[finalI][finalJ].setFill(color.get()));
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}