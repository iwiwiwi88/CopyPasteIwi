package pl.iwi.copypaste.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioMenuItem;

public class MenuBarController {

    @FXML
    public void setColorTheme(ActionEvent actionEvent) {
        String colorName = ((RadioMenuItem) actionEvent.getTarget()).getText();
        MotherController.get().setColorTheme(colorName);
    }
}
