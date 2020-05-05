package pl.iwi.copypaste.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.iwi.copypaste.model.ControllerMediator;

import java.net.URL;
import java.util.ResourceBundle;

public class PinBarController implements Initializable {
    @FXML
    public Menu mPin;
    private static final String IMAGES_PIN = "/images/pin.png";
    private static final String IMAGES_UNPIN = "/images/unpin.png";
    private ImageView pinImage;
    private ImageView unpinImage;
    private boolean isPinned = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pinImage = prepareImageView(IMAGES_PIN);
        unpinImage = prepareImageView(IMAGES_UNPIN);
        setPinned(isPinned);
    }

    @FXML
    public void setPinned() {
        setPinned(!this.isPinned);
    }

    public void setPinned(boolean pinned) {
        this.isPinned = pinned;
        if (pinned) {
            setImageAndWindow(pinImage);
        } else {
            setImageAndWindow(unpinImage);
        }
    }

    private void setImageAndWindow(ImageView image) {
        this.mPin.setGraphic(image);
     //   ControllerMediator.getInstance().mainController_setAlwaysOnTop(isPinned);
    }

    private ImageView prepareImageView(String imageUrl) {
        Image openIcon = new Image(getClass().getResourceAsStream(imageUrl));
        ImageView openView = new ImageView(openIcon);
        openView.setFitWidth(20);
        openView.setFitHeight(20);
        return openView;
    }

}
