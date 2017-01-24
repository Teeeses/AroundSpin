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

    private int xPixels;
    private int yPixels;

    private int color;
    private Paint paint;

    private Field field;

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
        canvas.drawRect(xPixels, yPixels, xPixels + field.getWidthCell(), yPixels + field.getWidthCell(), paint);
        //canvas.drawCircle(40, 40, 30, paint);
    }

    public void createPaint() {
        paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
    }
}
