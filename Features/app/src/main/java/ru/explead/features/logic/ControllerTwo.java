package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.Collections;
import java.util.Comparator;

import ru.explead.features.LevelsActivity;
import ru.explead.features.R;

/**
 * Created by develop on 21.02.2017.
 */

public class ControllerTwo extends BaseController {

    private Cube touchCube;

    public ControllerTwo() {
        createPaint();
    }

    public void onDraw(Canvas canvas) {
        for(int i = 0; i < field.getEmptyField().length; i++) {
            for(int j = 0; j < field.getEmptyField().length; j++) {
                if(field.getEmptyField()[i][j] == 6) {
                    canvas.drawRect(j*field.getWidthCell(), i*field.getWidthCell(), j*field.getWidthCell() + field.getWidthCell(), i*field.getWidthCell() + field.getWidthCell(), paintWall);
                }
            }
        }
        for(int i = 0; i < cube.size(); i++) {
            cube.get(i).getEndPosition().onDraw(canvas);
        }
        for(int i = 0; i < cube.size(); i++) {
            cube.get(i).onDraw(canvas);
        }
    }

    public void onMoveUp() {
        if(checkNoActiveMove()) {

            int count = 0;
            int x = touchCube.getX();
            int y = touchCube.getY();

            while (x - count - 1 >= 0 && field.getEmptyField()[x - count - 1][y] < 5 && checkPlaceCube(x - count - 1, y)) {
                count++;
            }
            touchCube.setMoveParams(UP, count);
        }
    }

    public void onMoveDown() {
        if(checkNoActiveMove()) {

            int count = 0;
            int x = touchCube.getX();
            int y = touchCube.getY();

            while (x + count + 1 < field.getEmptyField().length && field.getEmptyField()[x + count + 1][y] < 5 && checkPlaceCube(x + count + 1, y)) {
                count++;
            }
            touchCube.setMoveParams(DOWN, count);
        }
    }

    public void onMoveRight() {
        if(checkNoActiveMove()) {

            int count = 0;
            int x = touchCube.getX();
            int y = touchCube.getY();

            while (y + count + 1 < field.getEmptyField().length && field.getEmptyField()[x][y + count + 1] < 5 && checkPlaceCube(x, y + count + 1)) {
                count++;
            }
            touchCube.setMoveParams(RIGHT, count);
        }
    }

    public void onMoveLeft() {
        if(checkNoActiveMove()) {

            int count = 0;
            int x = touchCube.getX();
            int y = touchCube.getY();

            while (y - count - 1 >= 0 && field.getEmptyField()[x][y - count - 1] < 5 && checkPlaceCube(x, y - count - 1)) {
                count++;
            }
            touchCube.setMoveParams(LEFT, count);
        }
    }

    /**
     * Проверка, нажатие на кубик или нет
     * @return - true - нажали на кубик, иначе false
     */
    private Cube checkTouchOnCube(int start_x, int start_y) {
        Coordinate coordinate = findCell(start_x, start_y);
        for(int i = 0; i < cube.size(); i++) {
            if(cube.get(i).getX() == coordinate.getY() && cube.get(i).getY() == coordinate.getX()) {
                return cube.get(i);
            }
        }
        return null;
    }

    /**
     * Поиск клетки на которую нажали
     * @param start_x - начало по х движения пальца
     * @param start_y - начало по y движения пальца
     * @return - координаты
     */
    private Coordinate findCell(int start_x, int start_y) {
        return new Coordinate((int)(start_x/field.getWidthCell()), (int)(start_y/field.getWidthCell()));
    }

    public void logicMove(int start_x, int start_y, int end_x, int end_y) {
        touchCube = checkTouchOnCube(start_x, start_y);
        if(touchCube != null) {
            Log.d("TAG", "TOUCH " + touchCube.toString());
            int side1 = (start_x - end_x);
            int side2 = (start_y - end_y);
            int hypotenuse = (int) (Math.sqrt(Math.abs(side1 * side1) + Math.abs(side2 * side2)));
            double angle = (Math.asin((double) side2 / hypotenuse)) * 57.295f;
            if (hypotenuse > 50 && ((angle < 30 && angle > -30) || (angle > 60) || (angle < -60))) {
                if ((side1 <= 0 && side2 >= 0 && angle < 30) || (side1 <= 0 && side2 <= 0 && angle > -30)) {
                    onMoveRight();
                } else if ((side1 <= 0 && side2 >= 0 && angle > 60) || (side1 >= 0 && side2 >= 0 && angle > 60)) {
                    onMoveUp();
                } else if ((side1 >= 0 && side2 >= 0 && angle < 30) || (side1 >= 0 && side2 <= 0 && angle > -30)) {
                    onMoveLeft();
                } else if ((side1 >= 0 && side2 <= 0 && angle < -60) || (side1 <= 0 && side2 <= 0 && angle < -60)) {
                    onMoveDown();
                }
            }
        }
    }
}
