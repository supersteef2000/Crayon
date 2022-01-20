package frl.suk.crayon;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CreateNewImage {
    // Creates a new image made up of a 2d array of rectangles
    public Rectangle[][] image(int width, int height, int zoom, Group group) {
        Rectangle[][] rects = new Rectangle[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Rectangle rect = new Rectangle();
                rect.setX(i * zoom);
                rect.setY(j * zoom);
                rect.setWidth(zoom);
                rect.setHeight(zoom);
                rect.setFill(Color.TRANSPARENT);
                group.getChildren().add(rect);
                rects[i][j] = rect;
            }
        }
        return rects;
    }
}
