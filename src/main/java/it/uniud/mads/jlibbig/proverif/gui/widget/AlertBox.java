package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message) {
        // Window
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        // Label
        Label label = new Label();
        label.setText(message);
        // Button
        Button closeButton = ButtonStandard.createButton("Close");
        closeButton.setOnAction(e -> window.close());
        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        // Scene
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
}
