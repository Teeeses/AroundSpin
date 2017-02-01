package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Paint;

import ru.explead.features.app.App;
import ru.explead.features.beans.EndPosition;

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
    private EndPosition endPosition;

    /**
     * Статус движения(UP, DOWN, RIGHT, LEFT)
     */
    private int status;

    private float speed;
    /**
     * Количество отрисовок на все движение
     */
    private int numberFrame;

    /**
     * Количество отрисовок на одну клетку
     */
    private int numberFrameCell = 3;


    public Cube(int x, int y, int color, EndPosition endPosition) {
        field = App.getController().getField();
        this.endPosition = endPosition;
        this.x = x;
        this.y = y;
        this.color = color;
        xPixels = x*field.getWidthCell();
        yPixels = y*field.getWidthCell();
        speed = field.getWidthCell()/numberFrameCell;
        status = Controller.NO_ACTIVE;
        createPaint();
    }


    public void onDraw(Canvas canvas) {
        canvas.drawRect(yPixels, xPixels, yPixels + field.getWidthCell(), xPixels + field.getWidthCell(), paint);
    }

    public void onMove() {
        if(numberFrame > 0) {
            if (status == Controller.UP) {
                xPixels = xPixels - speed;
            }
            if (status == Controller.RIGHT) {
                yPixels = yPixels + speed;
            }
            if (status == Controller.DOWN) {
                xPixels = xPixels + speed;
            }
            if (status == Controller.LEFT) {
                yPixels = yPixels - speed;
            }
            numberFrame--;
        } else {
            status = Controller.NO_ACTIVE;
            xPixels = x*field.getWidthCell();
            yPixels = y*field.getWidthCell();
        }
    }

    public void setMoveParams(int move, int changeX, int changeY) {
        if(move == Controller.UP) {
            status = Controller.UP;
            numberFrame = changeX * numberFrameCell;
            x = x - changeX;
        }
        if(move == Controller.RIGHT) {
            status = Controller.RIGHT;
            numberFrame = changeY * numberFrameCell;
            y = y + changeY;
        }
        if(move == Controller.DOWN) {
            status = Controller.DOWN;
            numberFrame = changeX * numberFrameCell;
            x = x + changeX;
        }
        if(move == Controller.LEFT) {
            status = Controller.LEFT;
            numberFrame = changeY * numberFrameCell;
            y = y - changeY;
        }
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStatus() {
        return status;
    }

    public EndPosition getEndPosition() {
        return endPosition;
    }
}
