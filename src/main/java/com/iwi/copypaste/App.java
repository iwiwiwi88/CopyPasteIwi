package com.iwi.copypaste;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class App extends Application {

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        this.stage.setScene(new Scene(root));
        this.stage.setTitle("CopyPasteIwi");
        setSize();
        pinWindow(true);

        primaryStage.show();
    }

    private void setSize() {
        Rectangle appSize = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getMaximumWindowBounds();

        this.stage.setHeight(appSize.getHeight());
        this.stage.setX(appSize.getWidth() - this.stage.getScene().getWidth());
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