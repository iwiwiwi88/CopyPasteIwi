package pl.iwi.copypaste.model;

import pl.iwi.copypaste.controllers.*;

import java.io.File;

public interface Mediator {
    void registerMainController(MainController controller);

    void mainController_setAlwaysOnTop(boolean shouldBeOnTop);

    void registerAddButtonController(AddButtonController controller);

    void registerButtonsFieldController(ButtonsFieldController controller);

    void buttonsFieldController_loadTabsAndButtons(File xmlFile);

    void buttonsFieldController_addTab(String tabName);

    void buttonsFieldController_addButton(String buttonName, String textToBeCopied);

    void registerEditTextController(EditTextController controller);

    void registerMenuBarController(MenuBarController controller);

    void registerPinBarController(PinBarController controller);

}
