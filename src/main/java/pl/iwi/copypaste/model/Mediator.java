package pl.iwi.copypaste.model;

import pl.iwi.copypaste.controllers.*;

import java.io.File;

public interface Mediator {
    // #### AddButtonController ####
    void registerAddButtonController(AddButtonController controller);

    // #### ButtonsFieldController ####
    void registerButtonsFieldController(ButtonsFieldController controller);

    void buttonsFieldController_loadTabsAndButtons(File xmlFile);

    void buttonsFieldController_addTab(String tabName);

    void buttonsFieldController_addButton(String buttonName, String textToBeCopied);

    // #### EditTextController ####
    void registerEditTextController(EditTextController controller);

    void editTextController_setTextToBeEdited(String textToBeEdited);

    // #### MenuBarController ####
    void registerMenuBarController(MenuBarController controller);

    // #### PinBarController ####
    void registerPinBarController(PinBarController controller);

    void PinBarController_setPinned();

    void PinBarController_setPinned(boolean pinned);
}
