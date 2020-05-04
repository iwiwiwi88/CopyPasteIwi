package pl.iwi.copypaste.model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class CommonProperties {

    public static void addTextLimiter(TextField textField, int textLimit) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (textField.getText().length() > textLimit) {
                    String s = textField.getText().substring(0, textLimit);
                    textField.setText(s);
                }
            }
        });
    }
}
