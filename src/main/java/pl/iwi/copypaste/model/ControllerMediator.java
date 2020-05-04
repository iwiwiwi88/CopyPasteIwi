package pl.iwi.copypaste.model;

import pl.iwi.copypaste.controllers.*;

import java.io.File;

public class ControllerMediator implements Mediator {
    private AddButtonController addButtonController;
    private ButtonsFieldController buttonsFieldController;
    private EditTextController editTextController;
    private MenuBarController menuBarController;
    private PinBarController pinBarController;

    // #### AddButtonController ####
    @Override
    public void registerAddButtonController(AddButtonController controller) {
        this.addButtonController = controller;
    }

    // #### ButtonsFieldController ####
    @Override
    public void registerButtonsFieldController(ButtonsFieldController controller) {
        this.buttonsFieldController = controller;
    }

    @Override
    public void buttonsFieldController_loadTabsAndButtons(File xmlFile) {
        this.buttonsFieldController.loadTabsAndButtons(xmlFile);
    }

    @Override
    public void buttonsFieldController_addTab(String tabName) {
        this.buttonsFieldController.addTab(tabName);
    }

    @Override
    public void buttonsFieldController_addButton(String buttonName, String textToBeCopied) {
        this.buttonsFieldController.addButton(buttonName, textToBeCopied);
    }

    // #### EditTextController ####
    @Override
    public void registerEditTextController(EditTextController controller) {
        this.editTextController = controller;
    }

    @Override
    public void editTextController_setTextToBeEdited(String textToBeEdited) {

    }

    // #### MenuBarController ####
    @Override
    public void registerMenuBarController(MenuBarController controller) {
        this.menuBarController = controller;
    }

    // #### PinBarController ####
    @Override
    public void registerPinBarController(PinBarController controller) {
        this.pinBarController = controller;
    }

    @Override
    public void PinBarController_setPinned() {
        this.pinBarController.setPinned();
    }

    @Override
    public void PinBarController_setPinned(boolean pinned) {
        this.pinBarController.setPinned(pinned);
    }

    // SINGLETON
    private ControllerMediator() {
    }

    public static ControllerMediator getInstance() {
        return ControllerMediatorHolder.INSTANCE;
    }

    private static class ControllerMediatorHolder {
        private static final ControllerMediator INSTANCE = new ControllerMediator();
    }
}
