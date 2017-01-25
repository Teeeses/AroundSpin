package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import ru.explead.features.app.App;

/**
 * Created by develop on 20.01.2017.
 */

public class Cube {

    private int id;

    private int x;
    private int y;

    private float xPixels;
    private float yPixels;

    private int color;
    private Paint paint;

    private Field field;

    private int status;
    private float speed;


    public Cube(int x, int y, int color, Field field) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.field = field;
        xPixels = x*field.getWidthCell();
        yPixels = y*field.getWidthCell();

        Log.d("TAG", "SIZE: " + xPixels + " "  + yPixels);
        createPaint();
    }


    public void onDraw(Canvas canvas) {
        canvas.drawRect(yPixels, xPixels, yPixels + field.getWidthCell(), xPixels + field.getWidthCell(), paint);
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
