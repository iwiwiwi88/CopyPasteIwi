package pl.iwi.copypaste.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.iwi.copypaste.model.ControllerMediator;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControllerMediator.getInstance().registerMainController(this);
        ControllerMediator.getInstance().registerAddButtonController(addButtonController);
        ControllerMediator.getInstance().registerButtonsFieldController(buttonsFieldController);
        ControllerMediator.getInstance().registerEditTextController(editTextController);
        ControllerMediator.getInstance().registerMenuBarController(menuBarController);
        ControllerMediator.getInstance().registerPinBarController(pinBarController);
    }

    public void setAlwaysOnTop(boolean shouldBeOnTop) {
        ((Stage) mainPane.getParent().getScene().getWindow())
                .setAlwaysOnTop(shouldBeOnTop);
    }
}
