package ru.explead.features.logic;

import android.util.Log;

import ru.explead.features.Utils.UtilsFieldLevel;
import ru.explead.features.app.App;

/**
 * Created by develop on 20.01.2017.
 */

public class Field {

    private float width;
    private int numberCell;
    private float widthCell;

    private int[][] field;

    public Field(int[][] field) {
        this.field = field;
        this.width = App.getSizeSurface();
        numberCell = field.length;
        widthCell = width/ numberCell;
        Log.d("TAG", "Width: " + width + " widthCell: " + widthCell);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public int getNumberCell() {
        return numberCell;
    }

    public void setNumberCell(int numberCell) {
        this.numberCell = numberCell;
    }

    public float getWidthCell() {
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
