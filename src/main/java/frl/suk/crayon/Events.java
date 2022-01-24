package frl.suk.crayon;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class Events {
    Constants constants = new Constants();
    Canvas canvas = constants.getCanvas();
    EventHandlers eventHandlers = constants.getEventHandlers();
    Scene scene = constants.getScene();

    // Add event handlers for drawing, zooming, and switching colours
    public void events() {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, eventHandlers.mousePressed);
        canvas.addEventHandler(ScrollEvent.SCROLL, eventHandlers.scroll);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, eventHandlers.keyPressed);
    }
}