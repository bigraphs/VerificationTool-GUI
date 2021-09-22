package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.scene.control.Button;

public class ButtonStandard {

    public static Button createButton(String text) {
        Button button = new Button();
        button.setText(text);
        return button;
    }
}
