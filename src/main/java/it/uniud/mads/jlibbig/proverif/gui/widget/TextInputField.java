package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.scene.control.TextField;

public class TextInputField {

    public static TextField create() {
        TextField textField = new TextField();
        return textField;
    }

    public static TextField create(String promptText) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        return textField;
    }
}
