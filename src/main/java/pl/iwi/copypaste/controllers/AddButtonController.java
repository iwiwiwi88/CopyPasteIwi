package pl.iwi.copypaste.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static pl.iwi.copypaste.model.utils.AlertProvider.*;
import static pl.iwi.copypaste.model.utils.AlertProvider.showOnTopAndWait;
import static pl.iwi.copypaste.model.utils.CommonProperties.addTextLimiter;

public class AddButtonController implements Initializable {
    @FXML
    private TextField buttonName;
    @FXML
    private TextArea textToBeCopied;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addTextLimiter(buttonName, 40);
    }

    @FXML
    private void addNewButton() {
        String buttonNameText = buttonName.getText();
        String phraseToBeCopied = textToBeCopied.getText();
        if (buttonNameText.trim().length() > 0 && phraseToBeCopied.trim().length() > 0) {
            MotherController.get().addButton(buttonNameText, phraseToBeCopied);
        } else {
            Alert alert = provideWarningAlert("Empty values", "Add button issue",
                    "Both 'Button name' and it's 'Text to be copied' should not be empty");
            showOnTopAndWait(alert);
        }
    }

    @FXML
    private void clearAddButtonForm() {
        this.buttonName.setText("");
        this.textToBeCopied.setText("");
    }

}
