package ru.explead.features.logic;

import ru.explead.features.Utils.UtilsFieldLevel;

/**
 * Created by develop on 20.01.2017.
 */

public class Field {

    private int width;
    private int numberCell;
    private int widthCell;

    private int[][] field;

    public Field(Level level) {
        field = UtilsFieldLevel.getFieldLevel(level.getLevel(), level.getComplexity());
        numberCell = field.length;
        widthCell = width/ numberCell;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getNumberCell() {
        return numberCell;
    }

    public void setNumberCell(int numberCell) {
        this.numberCell = numberCell;
    }

    public int getWidthCell() {
        return widthCell;
    }

    public void setWidthCell(int widthCell) {
        this.widthCell = widthCell;
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }
}
