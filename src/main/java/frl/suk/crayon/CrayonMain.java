package frl.suk.crayon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CrayonMain extends Application {
    @Override
    public void start(Stage stage) {
        // Initialising variables
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        final double scaleDelta = 1.1;
        FlowPane flowPane = new FlowPane();
        Canvas canvas = new Canvas(width, height);
        Scene scene = new Scene(flowPane);
        Color color = Color.BLACK;
        Constants constants = new Constants();

        // Set variables for use in other classes
        constants.setScaleDelta(scaleDelta);
        constants.setFlowPane(flowPane);
        constants.setCanvas(canvas);
        constants.setScene(scene);
        constants.setColor(color);

        // Drawing the border
        canvas.getGraphicsContext2D().setStroke(Color.GREY);
        canvas.getGraphicsContext2D().setLineWidth(5);
        canvas.getGraphicsContext2D().strokeRect(x, y, width, height);
        canvas.getGraphicsContext2D().setStroke(Color.BLACK);
        canvas.getGraphicsContext2D().setLineWidth(1);

        // Adding event handlers
        EventHandlers eventHandlers = new EventHandlers();
        constants.setEventHandlers(eventHandlers);

        // Creating the scene and stage
        stage.setTitle("Crayon");
        flowPane.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();

        // Check for events
        Events events = new Events();
        events.events();
    }

    public static void main(String[] args) {
        launch();
    }
}

