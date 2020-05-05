package pl.iwi.copypaste;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {

    private static final double WINDOW_WIDTH = 500;
    private static final String APP_NAME = "CopyPasteIwi";
    private static final String FXML_MAIN = "/fxml/main.fxml";
    private static final String CSS_FILE = "/css/theme.css";
    private static final String IMAGES_APP_ICON = "/images/iwi_icon.png";
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        Parent root = initParent();
        this.stage.setScene(initScene(root));
        initBasicElements();
        primaryStage.show();
    }

    private Parent initParent() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(FXML_MAIN));
        return loader.load();
    }

    private Scene initScene(Parent root) {
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(CSS_FILE).toExternalForm());
        return scene;
    }

    private void initBasicElements() {
        this.stage.setTitle(APP_NAME);
        this.stage.getIcons().add(new Image(getClass().getResourceAsStream(IMAGES_APP_ICON)));
        setSize();
    }

    private void setSize() {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        this.stage.setX(visualBounds.getWidth() - WINDOW_WIDTH);
        this.stage.setY(visualBounds.getMinY());
        this.stage.setWidth(WINDOW_WIDTH);
        this.stage.setHeight(visualBounds.getHeight());
        this.stage.setResizable(false);
    }

}
