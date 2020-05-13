package pl.iwi.copypaste.model.tools.colortheme;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static pl.iwi.copypaste.model.tools.colortheme.ColorTheme.*;
import static pl.iwi.copypaste.model.utils.AlertProvider.provideWarningAlert;
import static pl.iwi.copypaste.model.utils.AlertProvider.showOnTopAndWait;

public class ColorThemeProvider {

    private Map<String, ColorTheme> colorThemes = new HashMap<>();

    private static final String TEMPLATE = "* {\n" +
            "  -iwi-base-background-color: BASE_BACKGROUND;\n" +
            "  -iwi-base-line-color: BASE_LINE;\n" +
            "  -iwi-base-text-fill-color: BASE_TEXT;\n" +
            "  -iwi-button-selected-color: BUTTON_SELECTED;\n" +
            "  -iwi-textfield-background-color: TEXT_FIELD_BACKGROUND;\n" +
            "  -iwi-textfield-border-color: TEXT_FIELD_BORDER;\n" +
            "  -iwi-text-input-color: TEXT_INPUT;\n" +
            "}";

    public static String prepareCssChange(String colorThemeName) {
        ColorTheme colorTheme = ColorThemeProvider.get().colorThemes.get(colorThemeName);
        if (colorTheme == null) {
            showOnTopAndWait(provideWarningAlert("No such ColorTheme", "No such ColorTheme",
                    "There is no such ColorTheme: " + colorThemeName));
            return null;
        } else {
            return useTemplate(colorTheme);
        }
    }

    private static String useTemplate(ColorTheme colorTheme) {
        return TEMPLATE
                .replace("BASE_BACKGROUND", getColorAsHex(colorTheme.baseBackground))
                .replace("BASE_LINE", getColorAsHex(colorTheme.baseLine))
                .replace("BASE_TEXT", getColorAsHex(colorTheme.baseTextFill))
                .replace("BUTTON_SELECTED", getColorAsHex(colorTheme.buttonSelected))
                .replace("TEXT_FIELD_BACKGROUND", getColorAsHex(colorTheme.textFieldBackground))
                .replace("TEXT_FIELD_BORDER", getColorAsHex(colorTheme.textFieldBorder))
                .replace("TEXT_INPUT", getColorAsHex(colorTheme.textInput));
    }

    private static String getColorAsHex(Color color) {
        if (color != null) {
            return String.format((Locale) null, "#%02x%02x%02x",
                    Math.round(color.getRed() * 255),
                    Math.round(color.getGreen() * 255),
                    Math.round(color.getBlue() * 255)).toUpperCase();
        } else {
            return null;
        }
    }

    // SINGLETON
    private ColorThemeProvider() {
        colorThemes.put(DRACULA.colorThemeName, DRACULA);
        colorThemes.put(CORAL.colorThemeName, CORAL);
        colorThemes.put(GREY.colorThemeName, GREY);
    }

    public static ColorThemeProvider get() {
        return ColorThemeProvider.ColorThemeProviderHolder.INSTANCE;
    }

    private static class ColorThemeProviderHolder {
        private static final ColorThemeProvider INSTANCE = new ColorThemeProvider();
    }
}
