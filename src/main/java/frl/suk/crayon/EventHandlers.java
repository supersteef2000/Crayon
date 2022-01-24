package frl.suk.crayon;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

import static java.lang.Math.round;

public class EventHandlers {
    Constants constants = new Constants();
    double scaleDelta = constants.getScaleDelta();
    FlowPane flowPane = constants.getFlowPane();
    Canvas canvas = constants.getCanvas();
    Color color = constants.getColor();

    // Event handler for zooming
    EventHandler<ScrollEvent> scroll = scrollEvent -> {
        // I have no clue what most of this does, I copied it from Stack Overflow, and it works exactly like I wanted
        double scale = flowPane.getScaleY();
        double oldScale = scale;
        if (scrollEvent.getDeltaY() < 0) {
            scale /= scaleDelta;
        } else {
            scale *= scaleDelta;
        }
        double f = (scale / oldScale) - 1;
        double dx = (scrollEvent.getSceneX() - (flowPane.getBoundsInParent().getWidth() / 2 + flowPane.getBoundsInParent().getMinX()));
        double dy = (scrollEvent.getSceneY() - (flowPane.getBoundsInParent().getHeight() / 2 + flowPane.getBoundsInParent().getMinY()));
        flowPane.setScaleX(scale);
        flowPane.setScaleY(scale);
        flowPane.setTranslateX(flowPane.getTranslateX() - f * dx);
        flowPane.setTranslateY(flowPane.getTranslateY() - f * dy);
        scrollEvent.consume();
    };

    // Event handler for colour switching and zooming (control)
    public EventHandler<KeyEvent> keyPressed = keyEvent -> {
        switch (keyEvent.getCode()) {
            case DIGIT1 -> color = Color.RED;
            case DIGIT2 -> color = Color.GREEN;
            case DIGIT3 -> color = Color.BLUE;
            case DIGIT4 -> color = Color.YELLOW;
            case DIGIT5 -> color = Color.BLACK;
            case DIGIT6 -> color = Color.WHITE;
        }
    };

    // Event handler for drawing
    public EventHandler<MouseEvent> mouseDragged = mouseEvent -> {
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            canvas.getGraphicsContext2D().lineTo(round(mouseEvent.getX()), round(mouseEvent.getY()));
            canvas.getGraphicsContext2D().stroke();
        }
    };

    // Event handler for drawing (start)
    public EventHandler<MouseEvent> mousePressed = mouseEvent -> {
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            canvas.getGraphicsContext2D().beginPath();
            canvas.getGraphicsContext2D().moveTo(round(mouseEvent.getX()), round(mouseEvent.getY()));
            canvas.getGraphicsContext2D().setStroke(color);
            canvas.getGraphicsContext2D().stroke();
            canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseDragged);
        }
    };

}
