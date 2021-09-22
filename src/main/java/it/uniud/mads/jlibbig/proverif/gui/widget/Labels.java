package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;

public class Labels {

    /**
     * Create an empty label
     * @return the label
     */
    public static Label create() {
        Label label = new Label();
        return label;
    }

    /**
     * Create a label
     * @param text the text of the label
     * @return the label
     */
    public static Label create(String text) {
        Label label = new Label();
        label.setText(text);
        return label;
    }

    /**
     * Create a label binded to an Observable Property
     * @param property the property to bind
     * @return the label
     */
    public static Label createBinded(ObservableValue<? extends String> property) {
        Label label = create();
        label.textProperty().bind(property);
        return label;
    }
    
}
