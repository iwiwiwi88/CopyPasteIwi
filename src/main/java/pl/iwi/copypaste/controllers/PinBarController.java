package pl.iwi.copypaste.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.iwi.copypaste.model.MotherController;

import java.net.URL;
import java.util.ResourceBundle;

public class PinBarController implements Initializable {
    @FXML
    public Button mPin;

    private static final String IMAGES_PIN = "/images/pin.png";
    private static final String IMAGES_UNPIN = "/images/unpin.png";
    private ImageView pinImage;
    private ImageView unpinImage;
    private boolean isPinned = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pinImage = prepareImageView(IMAGES_PIN);
        unpinImage = prepareImageView(IMAGES_UNPIN);
        this.mPin.setGraphic(pinImage);
    }

    @FXML
    public void setPinned() {
        this.isPinned = !this.isPinned;
        MotherController.get().setAlwaysOnTop(isPinned);
    }

    public void setPinned(boolean pinned) {
        this.isPinned = pinned;
        if (pinned) {
            this.mPin.setGraphic(pinImage);
        } else {
            this.mPin.setGraphic(unpinImage);
        }
    }

    private ImageView prepareImageView(String imageUrl) {
        Image openIcon = new Image(getClass().getResourceAsStream(imageUrl));
        ImageView openView = new ImageView(openIcon);
        openView.setFitWidth(20);
        openView.setFitHeight(20);
        return openView;
    }

}
