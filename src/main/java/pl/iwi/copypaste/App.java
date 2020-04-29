package pl.iwi.copypaste;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/main.fxml"));
        Parent root = loader.load();

        this.stage.setScene(new Scene(root));
        this.stage.setTitle("CopyPasteIwi");
        setSize();
        pinWindow(true);

        primaryStage.show();
    }

    private void setSize() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();

        this.stage.setHeight(screenBounds.getHeight());
        this.stage.setX(screenBounds.getWidth() - this.stage.getScene().getWidth());
        this.stage.setResizable(false);
    }

    public void pinWindow(boolean pinned) {
        this.stage.setAlwaysOnTop(pinned);
        // menu.setPin(pinned);
    }

    public void pinWindow() {
        pinWindow(!this.stage.isAlwaysOnTop());
    }
}