package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Paint;

import ru.explead.features.app.App;

/**
 * Created by develop on 20.01.2017.
 */

public class Cube {

    private int id;

    private int x;
    private int y;

    private int xPixels;
    private int yPixels;

    private int color;
    private Paint paint;

    private Field field;

    public Cube(int x, int y) {
        this.x = x;
        this.y = y;
        field = App.getController().getField();
        xPixels = x*field.getWidthCell();
        yPixels = y*field.getWidthCell();
    }


    public void onDraw(Canvas canvas) {
        canvas.drawRect(xPixels, yPixels, xPixels + field.getWidthCell(), yPixels + field.getWidthCell(), paint);
    }

    public void createPaint() {
        paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
    }
}
