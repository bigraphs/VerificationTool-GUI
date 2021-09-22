package it.uniud.mads.jlibbig.proverif.gui.widget;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Grid {

    /**
     * Create a grid with:
     * <p>
     * Vgap: 8
     * <p>
     * Hgap: 8
     * @return the grid
     */
    public static GridPane create() {
        GridPane grid = new GridPane();
        grid.setVgap(8);
        grid.setHgap(10);
        return grid;
    }

    /**
     * Create a grid
     * @param Vgap the vertical gap
     * @param Hgap the horizontal gap
     * @return the grid
     */
    public static GridPane create(int Vgap, int Hgap) {
        GridPane grid = new GridPane();
        grid.setVgap(Vgap);
        grid.setHgap(Hgap);
        return grid;
    }

    /**
     * Create a grid
     * @param alignment the aligment
     * @param Vgap the vertical gap
     * @param Hgap the horizontal gap
     * @param padding the padding
     * @param minWidth the min width
     * @param minHeight the min height
     * @return the grid
     */
    public static GridPane create(Pos alignment, int Vgap, int Hgap, Insets padding, int minWidth, int minHeight) {
        GridPane grid = new GridPane();
        grid.setPadding(padding);
        grid.setMinSize(minWidth, minHeight);
        grid.setAlignment(alignment);
        grid.setVgap(Vgap);
        grid.setHgap(Hgap);
        return grid;
    }

}
