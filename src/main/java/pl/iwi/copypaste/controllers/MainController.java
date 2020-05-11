package pl.iwi.copypaste.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.iwi.copypaste.model.MotherController;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public BorderPane mainPane;
    @FXML
    private MenuBarController menuBarController;
    @FXML
    private PinBarController pinBarController;
    @FXML
    private AddButtonController addButtonController;
    @FXML
    private ButtonsFieldController buttonsFieldController;
    @FXML
    private EditTextController editTextController;

    private MotherController motherController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        motherController = MotherController.get();
        motherController.registerMainController(this);
        motherController.registerAddButtonController(addButtonController);
        motherController.registerButtonsFieldController(buttonsFieldController);
        motherController.registerEditTextController(editTextController);
        motherController.registerMenuBarController(menuBarController);
        motherController.registerPinBarController(pinBarController);
    }

    public void setAlwaysOnTop(boolean shouldBeOnTop) {
        ((Stage) mainPane.getScene().getWindow()).setAlwaysOnTop(shouldBeOnTop);
    }
}
