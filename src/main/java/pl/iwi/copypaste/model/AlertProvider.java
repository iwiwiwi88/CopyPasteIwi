package pl.iwi.copypaste.model;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertProvider {

    public static Alert provideWarningAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert;
    }

    public static void showOnTopAndWait(Alert alert) {
        DialogPane root = alert.getDialogPane();

        Stage dialogStage = new Stage(StageStyle.UTILITY);

        for (ButtonType buttonType : root.getButtonTypes()) {
            ButtonBase button = (ButtonBase) root.lookupButton(buttonType);
            button.setOnAction(evt -> {
                root.setUserData(buttonType);
                dialogStage.close();
            });
        }

        root.getScene().setRoot(new Group());

        root.setPadding(new Insets(10, 0, 10, 0));
        Scene scene = new Scene(root);

        dialogStage.setScene(scene);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setAlwaysOnTop(true);
        dialogStage.setResizable(false);
        dialogStage.showAndWait();
    }
}
