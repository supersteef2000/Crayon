module frl.suk.crayon {
    requires javafx.controls;
    requires javafx.fxml;


    opens frl.suk.crayon to javafx.fxml;
    exports frl.suk.crayon;
}