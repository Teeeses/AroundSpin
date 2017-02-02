package ru.explead.features.logic;


import ru.explead.features.app.App;

/**
 * Created by develop on 20.01.2017.
 */

public class Field {

    private float width;
    private float widthCell;

    private int[][] emptyField;

    public Field(int[][] emptyField) {
        this.emptyField = emptyField;
        this.width = App.getSizeSurface();
        widthCell = width/ emptyField.length;
    }


    public float getWidthCell() {
        return widthCell;
    }

    public int[][] getEmptyField() {
        return emptyField;
    }
}
