package ru.explead.features.beans;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import ru.explead.features.app.App;
import ru.explead.features.logic.Field;

/**
 * Created by Александр on 27.01.2017.
 */

public class EndPosition {

    private int x;
    private int y;
    private Field field;

    private int color;
    private Paint paint;


    private float xPixels;
    private float yPixels;


    public EndPosition(int x, int y, int color) {
        field = App.getController().getField();
        this.x = x;
        this.y = y;
        this.color = color;
        xPixels = x*field.getWidthCell();
        yPixels = y*field.getWidthCell();
        createPaint();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawRect(yPixels + field.getWidthCell()*0.25f, xPixels + field.getWidthCell()*0.25f,
                yPixels + field.getWidthCell() - field.getWidthCell()*0.25f, xPixels + field.getWidthCell() - field.getWidthCell()*0.25f, paint);
    }

    public void createPaint() {
        paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
