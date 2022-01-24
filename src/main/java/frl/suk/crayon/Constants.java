package frl.suk.crayon;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class Constants {
    private static double scaleDelta;
    private static FlowPane flowPane;
    private static Canvas canvas;
    private static Scene scene;
    private static Color color;
    private static EventHandlers eventHandlers;

    public void setScaleDelta(double value) { scaleDelta = value; }
    public void setFlowPane(FlowPane value) { flowPane = value; }
    public void setCanvas(Canvas value) { canvas = value; }
    public void setScene(Scene value) { scene = value; }
    public void setColor(Color value) { color = value; }
    public void setEventHandlers(EventHandlers value) { eventHandlers = value; }

    public double getScaleDelta() { return scaleDelta; }
    public FlowPane getFlowPane() { return flowPane; }
    public Canvas getCanvas() { return canvas; }
    public Scene getScene() { return scene; }
    public Color getColor() { return color; }
    public EventHandlers getEventHandlers() { return eventHandlers; }
}
