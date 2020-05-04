package pl.iwi.copypaste.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.File;

public class ButtonsFieldController {
    @FXML
    public VBox buttonsFieldPane;
    @FXML
    public Label kotek;

    public void addButton(String buttonName, String textToBeCopied) {
        kotek.setText(String.format("Create button [%s] and text:\n[%s]",
                buttonName, textToBeCopied));
    }

    public void addTab(String tabName) {
        kotek.setText("add tab: "+tabName);
    }

    public void loadTabsAndButtons(File xmlFile) {
        kotek.setText("Load from file");
    }
}
