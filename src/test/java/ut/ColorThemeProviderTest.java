package ut;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.iwi.copypaste.model.tools.colortheme.ColorThemeProvider;

public class ColorThemeProviderTest {

    private static final String CORRECT_CORAL_CSS = "* {\n" +
            "  -iwi-base-background-color: #B1F1ED;\n" +
            "  -iwi-base-line-color: #FD7C6F;\n" +
            "  -iwi-base-text-fill-color: #FD7C6F;\n" +
            "  -iwi-button-selected-color: #11CDDE;\n" +
            "  -iwi-textfield-background-color: #FFFFFF;\n" +
            "  -iwi-textfield-border-color: #11CDDE;\n" +
            "  -iwi-text-input-color: #3197E9;\n" +
            "}";

    @Test
    public void prepareCssChange_shouldPrepareCorrectCssForEnum() {
        String coralCss = ColorThemeProvider.prepareCssChange("Coral");
        Assertions.assertThat(coralCss).isEqualTo(CORRECT_CORAL_CSS);
    }
}
