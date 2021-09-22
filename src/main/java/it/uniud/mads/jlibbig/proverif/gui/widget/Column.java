package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class Column {

    /**
     * Crete a column with:
     * <p>
     * ALIGNMENT: Top_Center
     * <p>
     * PADDING: 10, 30, 10, 30
     * <p>
     * SPACING: 30
     * <p>
     * MIN_WIDTH: 100
     * @return the column
     */
    public static VBox create() {
        VBox column = new VBox();
        column.setAlignment(Pos.TOP_CENTER);
        column.setPadding(new Insets(10, 30, 10, 30));
        column.setSpacing(30);
        column.setMinWidth(100);
        return column;
    }

    /**
     * Crete a column with borders
     * <p>
     * ALIGNMENT: Top_Center
     * <p>
     * PADDING: 10, 30, 10, 30
     * <p>
     * SPACING: 30
     * <p>
     * MIN_WIDTH: 100
     * @return the column
     */
    public static VBox createBold() {
        VBox column = new VBox();
        column.setAlignment(Pos.TOP_CENTER);
        column.setPadding(new Insets(10, 30, 10, 30));
        column.setSpacing(30);
        column.setMinWidth(100);
        column.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, new CornerRadii(2.0),
        BorderWidths.DEFAULT, new Insets(3, 3, 3, 3))));
        return column;
    }

    /**
     * Create a column
     * @param position the alignment
     * @param padding the padding
     * @return the column
     */
    public static VBox create(Pos position, Insets padding) {
        VBox column = new VBox();
        column.setAlignment(position);
        column.setPadding(padding);
        return column;
    }

    /**
     * Create a column
     * @param position the alignment
     * @param spacing the spacing
     * @return the column
     */
    public static VBox create(Pos position, int spacing) {
        VBox column = new VBox();
        column.setAlignment(position);
        column.setSpacing(spacing);
        return column;
    }

    /**
     * Create a column
     * @param position the alignment
     * @param padding the padding
     * @param minWidth the min width
     * @return the column
     */
    public static VBox create(Pos position, Insets padding, int minWidth) {
        VBox column = new VBox();
        column.setAlignment(position);
        column.setPadding(padding);
        column.setMinWidth(minWidth);
        return column;
    }

    /**
     * Create a column
     * @param position the alignment
     * @param padding the padding
     * @param spacing the spacing
     * @param minWidth the min width
     * @return the column
     */
    public static VBox create(Pos position, Insets padding, int spacing, int minWidth) {
        VBox column = new VBox();
        column.setAlignment(position);
        column.setPadding(padding);
        column.setSpacing(spacing);
        column.setMinWidth(minWidth);
        return column;
    }
    
}
