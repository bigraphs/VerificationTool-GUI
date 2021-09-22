package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

public class Row {

    /**
     * Create an Row with:
     * <p>
     * ALIGNMENT: Center
     * <p>
     * SPACING: 8,
     * 
     * @return the row
     */
    public static HBox create() {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER);
        row.setSpacing(8);
        return row;
    }

    /**
     * Create an Row with:
     * <p>
     * SPACING: 8,
     * 
     * @param position the alignment
     * @return the row
     */
    public static HBox create(Pos position) {
        HBox row = new HBox();
        row.setAlignment(position);
        row.setSpacing(8);
        return row;
    }

    /**
     * Create an Row
     * 
     * @param position the alignment
     * @param spacing  the spacing between elements
     * @return the row
     */
    public static HBox create(Pos position, int spacing) {
        HBox row = new HBox();
        row.setAlignment(position);
        row.setSpacing(spacing);
        return row;
    }

    /**
     * Create an Row
     * 
     * @param position the alignment
     * @param spacing  the spacing between elements
     * @param padding  the padding
     * @return the row
     */
    public static HBox create(Pos position, int spacing, Insets padding) {
        HBox row = new HBox();
        row.setAlignment(position);
        row.setSpacing(spacing);
        row.setPadding(padding);
        return row;
    }

    /**
     * Create an Row
     * 
     * @param position the alignment
     * @param spacing  the spacing between elements
     * @param padding  the padding
     * @return the row
     */
    public static HBox createBold(Pos position, int spacing, Insets padding) {
        HBox row = new HBox();
        row.setAlignment(position);
        row.setSpacing(spacing);
        row.setPadding(padding);
        row.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, new CornerRadii(2.0),
                BorderWidths.DEFAULT, new Insets(3, 3, 3, 3))));
        return row;
    }
}
