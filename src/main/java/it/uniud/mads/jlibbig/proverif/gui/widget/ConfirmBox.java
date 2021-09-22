package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        // Window
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setOnCloseRequest(e -> answer = false);
        // Label
        Label label = new Label();
        label.setText(message);
        // Yes Button
        Button yesButton = ButtonStandard.createButton("Yes");
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        // No Button
        Button noButton = ButtonStandard.createButton("No");
        noButton.setOnAction(e -> {
            answer = false;
            window.close();;
        });
        // Layouts
        VBox layout = new VBox(10);
        HBox buttonline = new HBox(20);
        buttonline.getChildren().addAll(yesButton, noButton);
        buttonline.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, buttonline);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 10, 20, 10));
        // Scene and Window control
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
    
}
