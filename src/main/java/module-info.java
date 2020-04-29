module pl.iwi.copypaste.App {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    opens pl.iwi.copypaste to javafx.graphics, javafx.fxml;
    opens pl.iwi.copypaste.controllers to javafx.graphics, javafx.fxml;
}