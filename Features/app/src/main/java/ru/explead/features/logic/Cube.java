package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import ru.explead.features.app.App;
import ru.explead.features.app.Helper;
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
    private Paint paintblackLine;

    private Field field;
    private EndPosition endPosition;
    private Helper helper;

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

    public Cube(int x, int y, int color, EndPosition endPosition, Helper helper) {
        field = App.getController().getField();
        this.endPosition = endPosition;
        this.x = x;
        this.y = y;
        this.color = color;
        this.helper = helper;
        xPixels = x*field.getWidthCell();
        yPixels = y*field.getWidthCell();
        speed = field.getWidthCell()/numberFrameCell;
        status = Controller.NO_ACTIVE;
        createPaint();
    }


    public void onDraw(Canvas canvas) {
        if(helper != null) {
            canvas.drawLine(yPixels + field.getMid(), xPixels + field.getMid(),
                    helper.getY()*field.getWidthCell() + field.getMid(), helper.getX()*field.getWidthCell() + field.getMid(), paintblackLine);
        }
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

    public void setMoveParams(int move, int count) {
        numberFrame = count * numberFrameCell;
        if(move == Controller.UP) {
            status = Controller.UP;
            x = x - count;
        }
        if(move == Controller.RIGHT) {
            status = Controller.RIGHT;
            y = y + count;
        }
        if(move == Controller.DOWN) {
            status = Controller.DOWN;
            x = x + count;
        }
        if(move == Controller.LEFT) {
            status = Controller.LEFT;
            y = y - count;
        }
    }

    public void createPaint() {
        paint = new Paint();
        paintblackLine = new Paint();
        paintblackLine.setStrokeWidth(3);
        paint.setColor(color);
        paintblackLine.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paintblackLine.setAntiAlias(true);
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

    public void setStatus(int status) {
        this.status = status;
    }

    public void setNumberFrame(int numberFrame) {
        this.numberFrame = numberFrame;
    }

    public EndPosition getEndPosition() {
        return endPosition;
    }

    public int getNumberFrameCell() {
        return numberFrameCell;
    }
}
