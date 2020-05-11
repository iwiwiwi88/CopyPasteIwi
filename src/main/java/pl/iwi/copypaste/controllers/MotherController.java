package pl.iwi.copypaste.model;

import pl.iwi.copypaste.controllers.*;

import java.io.File;

public class MotherController {
    private MainController mainController;
    private AddButtonController addButtonController;
    private ButtonsFieldController buttonsFieldController;
    private EditTextController editTextController;
    private MenuBarController menuBarController;
    private PinBarController pinBarController;

    public void setAlwaysOnTop(boolean shouldBeOnTop) {
        this.mainController.setAlwaysOnTop(shouldBeOnTop);
        this.pinBarController.setPinned(shouldBeOnTop);
    }

    public void loadTabsAndButtons(File xmlFile) {
        this.buttonsFieldController.loadTabsAndButtons(xmlFile);
    }

    public void addTab(String tabName) {
        this.buttonsFieldController.addTab(tabName);
    }

    public void addButton(String buttonName, String textToBeCopied) {
        this.buttonsFieldController.addButton(buttonName, textToBeCopied);
    }

    // REGISTER CONTROLLERS
    public void registerMainController(MainController controller) {
        this.mainController = controller;
    }

    public void registerAddButtonController(AddButtonController controller) {
        this.addButtonController = controller;
    }

    public void registerButtonsFieldController(ButtonsFieldController controller) {
        this.buttonsFieldController = controller;
    }

    public void registerEditTextController(EditTextController controller) {
        this.editTextController = controller;
    }

    public void registerMenuBarController(MenuBarController controller) {
        this.menuBarController = controller;
    }

    public void registerPinBarController(PinBarController controller) {
        this.pinBarController = controller;
    }

    // SINGLETON
    private MotherController() {
    }

    public static MotherController get() {
        return ControllerMediatorHolder.INSTANCE;
    }

    private static class ControllerMediatorHolder {
        private static final MotherController INSTANCE = new MotherController();
    }
}
