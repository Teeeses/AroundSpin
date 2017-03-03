package ru.explead.features.beans;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import ru.explead.features.Utils.Utils;
import ru.explead.features.app.App;
import ru.explead.features.logic.Field;

/**
 * Created by Александр on 27.01.2017.
 */

public class EndPosition {

    private int x;
    private int y;
    private Field field;

    private int id;
    private Paint paint;


    private float xPixels;
    private float yPixels;


    public EndPosition(int x, int y) {
        field = App.getController().getField();
        this.x = x;
        this.y = y;
        xPixels = x*field.getWidthCell();
        yPixels = y*field.getWidthCell();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawRect(yPixels + field.getWidthCell()*0.25f, xPixels + field.getWidthCell()*0.25f,
                yPixels + field.getWidthCell()*0.75f, xPixels + field.getWidthCell()*0.75f, paint);
    }

    public void onDrawNormal(Canvas canvas) {
        canvas.drawRect(yPixels, xPixels,
                yPixels + field.getWidthCell(), xPixels + field.getWidthCell(), paint);
    }

    public void findDraweble() {
        paint = Utils.getDrawableCube(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getxPixels() {
        return xPixels;
    }

    public float getyPixels() {
        return yPixels;
    }
}
