package pl.iwi.copypaste.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.iwi.copypaste.model.tools.colortheme.ColorThemeProvider;
import pl.iwi.copypaste.model.utils.FileChanges;

import java.net.URL;
import java.util.ResourceBundle;

import static pl.iwi.copypaste.model.tools.colortheme.ColorTheme.GREY;
import static pl.iwi.copypaste.model.utils.ResourcesConstants.CSS_FILE_WITH_VARS;

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
        exchangeCssVariables(GREY.colorThemeName);
    }

    public void setAlwaysOnTop(boolean shouldBeOnTop) {
        getMainStage().setAlwaysOnTop(shouldBeOnTop);
    }

    public void setColorTheme(String colorThemeName) {
        exchangeCssVariables(colorThemeName);
        getMainStage().getScene().getStylesheets().remove(getClass().getResource(CSS_FILE_WITH_VARS).toExternalForm());
        getMainStage().getScene().getStylesheets().add(getClass().getResource(CSS_FILE_WITH_VARS).toExternalForm());
    }

    private void exchangeCssVariables(String colorThemeName) {
        String cssValuesChange = ColorThemeProvider.prepareCssChange(colorThemeName);
        FileChanges.replaceFileContent(getClass().getResource(CSS_FILE_WITH_VARS), cssValuesChange);
    }


    private Stage getMainStage() {
        return (Stage) mainPane.getScene().getWindow();
    }
}
