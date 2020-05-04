package pl.iwi.copypaste.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pl.iwi.copypaste.model.ControllerMediator;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public MenuBarController menuBarController;
    @FXML
    public PinBarController pinBarController;
    @FXML
    public AddButtonController addButtonController;
    @FXML
    public ButtonsFieldController buttonsFieldController;
    @FXML
    public EditTextController editTextController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControllerMediator.getInstance().registerAddButtonController(addButtonController);
        ControllerMediator.getInstance().registerButtonsFieldController(buttonsFieldController);
        ControllerMediator.getInstance().registerEditTextController(editTextController);
        ControllerMediator.getInstance().registerMenuBarController(menuBarController);
        ControllerMediator.getInstance().registerPinBarController(pinBarController);
    }
}
