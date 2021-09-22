package it.uniud.mads.jlibbig.proverif.gui.utils;

import javafx.scene.control.TextField;

public class Validator {

    public static boolean isInt(TextField textField) {
        try {
            Integer.parseInt(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNotEmpty(TextField textField) {
        if(textField.getText().isBlank()) {
            textField.setStyle("-fx-faint-focus-color: transparent; -fx-focus-color:rgba(255,0,0,0.2); /* here rgba (corrected) */");
            return false;
        } else {
            return true;
        }
    }
    
}
