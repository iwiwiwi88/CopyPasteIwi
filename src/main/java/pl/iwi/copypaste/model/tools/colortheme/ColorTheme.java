package pl.iwi.copypaste.model.tools.colortheme;

import javafx.scene.paint.Color;

public enum ColorTheme {

    DRACULA("Dracula", Color.BLACK, Color.web("#172671"), Color.web("#BB580D"),
            Color.web("#262626"), Color.BLACK, Color.web("#172671"), Color.web("#BB580D")),
    CORAL("Coral", Color.web("#B1F1ED"), Color.web("#FD7C6F"), Color.web("#FD7C6F"),
            Color.web("#11CDDE"), Color.WHITE, Color.web("#11CDDE"), Color.web("#3197E9")),
    GREY("Grey", Color.web("#5D646F"), Color.web("#4C535F"), Color.web("#3EC0CD"),
            Color.web("#4D6469"), Color.web("#6E7F87"), Color.web("#4D6469"), Color.web("#4C535F"));

    public final String colorThemeName;
    final Color baseBackground;
    final Color baseLine;
    final Color baseTextFill;
    final Color buttonSelected;
    final Color textFieldBackground;
    final Color textFieldBorder;
    final Color textInput;

    ColorTheme(String name, Color baseBackground, Color baseLine, Color baseTextFill,
               Color buttonSelected, Color textFieldBackground,
               Color textFieldBorder, Color textInput) {
        this.colorThemeName = name;
        this.baseBackground = baseBackground;
        this.baseLine = baseLine;
        this.baseTextFill = baseTextFill;
        this.buttonSelected = buttonSelected;
        this.textFieldBackground = textFieldBackground;
        this.textFieldBorder = textFieldBorder;
        this.textInput = textInput;
    }

}
