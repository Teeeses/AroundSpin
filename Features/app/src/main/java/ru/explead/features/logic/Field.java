package ru.explead.features.logic;


import ru.explead.features.app.App;

/**
 * Created by develop on 20.01.2017.
 */

public class Field {

    /**
     * Длинна поля
     */
    private float width;
    /**
     * Длинна клетки
     */
    private float widthCell;

    /**
     * Длинна пол клетки
     */
    private float mid;

    private int[][] emptyField;

    public Field(int[][] emptyField) {
        this.emptyField = emptyField;
        this.width = App.getSizeSurface();
        widthCell = width/ emptyField.length;
    }


    public float getMid() {
        return mid;
    }

    public float getWidthCell() {
        return widthCell;
    }

    public int[][] getEmptyField() {
        return emptyField;
    }
}
