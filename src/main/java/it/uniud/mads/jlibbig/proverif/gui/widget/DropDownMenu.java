package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.scene.control.ChoiceBox;

public class DropDownMenu {

    public static ChoiceBox<String> create(String[] elements, String defaultElement) {
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().addAll(elements);
        choiceBox.setValue(defaultElement);
        return choiceBox;
    }
    
}
