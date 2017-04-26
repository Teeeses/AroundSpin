package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.Collections;
import java.util.Comparator;

import ru.explead.features.LevelsActivity;
import ru.explead.features.R;
import ru.explead.features.Utils.Utils;
import ru.explead.features.app.App;

/**
 * Created by develop on 30.12.2016.
 */


public class ControllerOne extends BaseController {


    protected Paint paintDarkCell = new Paint();
    protected Paint paintLightCell = new Paint();

    public ControllerOne() {
        createPaint();
        createCellPaint();
    }

    private void createCellPaint() {
        paintLightCell.setColor(LevelsActivity.getActivity().getResources().getColor(R.color.cell_light));
        paintDarkCell.setColor(LevelsActivity.getActivity().getResources().getColor(R.color.cell_dark));
        paintLightCell.setAntiAlias(true);
        paintDarkCell.setAntiAlias(true);
    }

    public void onDraw(Canvas canvas) {

        int dark_or_light = -1;
        for(int i = 0; i < field.getEmptyField().length; i++) {
            for(int j = 0; j < field.getEmptyField().length; j++) {
                dark_or_light++;
                //Рисуем клетки стенки
                if(field.getEmptyField()[i][j] == 6) {
                    canvas.drawRect(j*field.getWidthCell(), i*field.getWidthCell(), j*field.getWidthCell() + field.getWidthCell(), i*field.getWidthCell() + field.getWidthCell(), paintWall);
                } else {
                    //Рисуем пустую клетку
                    if(dark_or_light % 2 == 0) {
                        canvas.drawRect(j * field.getWidthCell(), i * field.getWidthCell(), j * field.getWidthCell() + field.getWidthCell(), i * field.getWidthCell() + field.getWidthCell(), paintDarkCell);
                    } else {
                        canvas.drawRect(j * field.getWidthCell(), i * field.getWidthCell(), j * field.getWidthCell() + field.getWidthCell(), i * field.getWidthCell() + field.getWidthCell(), paintLightCell);
                    }
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
            Collections.sort(cube, new Comparator<Cube>() {
                @Override
                public int compare(Cube cubeOne, Cube cubeTwo) {
                    if (cubeOne.getX() > cubeTwo.getX())
                        return 1;
                    if (cubeOne.getX() < cubeTwo.getX())
                        return -1;
                    return 0;
                }
            });

            for (int i = 0; i < cube.size(); i++) {
                int count = 0;
                int x = cube.get(i).getX();
                int y = cube.get(i).getY();

                while (x - count - 1 >= 0 && field.getEmptyField()[x - count - 1][y] < 5 && checkPlaceCube(x - count - 1, y)) {
                    count++;
                }
                cube.get(i).setMoveParams(UP, count);
            }
        }
    }

    public void onMoveDown() {
        if(checkNoActiveMove()) {
            Collections.sort(cube, new Comparator<Cube>() {
                @Override
                public int compare(Cube cubeOne, Cube cubeTwo) {
                    if (cubeOne.getX() < cubeTwo.getX())
                        return 1;
                    if (cubeOne.getX() > cubeTwo.getX())
                        return -1;
                    return 0;
                }
            });

            for (int i = 0; i < cube.size(); i++) {
                int count = 0;
                int x = cube.get(i).getX();
                int y = cube.get(i).getY();

                while (x + count + 1 < field.getEmptyField().length && field.getEmptyField()[x + count + 1][y] < 5 && checkPlaceCube(x + count + 1, y)) {
                    count++;
                }
                cube.get(i).setMoveParams(DOWN, count);
            }
        }
    }

    public void onMoveRight() {
        if(checkNoActiveMove()) {
            Collections.sort(cube, new Comparator<Cube>() {
                @Override
                public int compare(Cube cubeOne, Cube cubeTwo) {
                    if (cubeOne.getY() < cubeTwo.getY())
                        return 1;
                    if (cubeOne.getY() > cubeTwo.getY())
                        return -1;
                    return 0;
                }
            });

            for (int i = 0; i < cube.size(); i++) {
                int count = 0;
                int x = cube.get(i).getX();
                int y = cube.get(i).getY();

                while (y + count + 1 < field.getEmptyField().length && field.getEmptyField()[x][y + count + 1] < 5 && checkPlaceCube(x, y + count + 1)) {
                    count++;
                }
                cube.get(i).setMoveParams(RIGHT, count);
            }
        }
    }

    public void onMoveLeft() {
        if(checkNoActiveMove()) {
            Collections.sort(cube, new Comparator<Cube>() {
                @Override
                public int compare(Cube cubeOne, Cube cubeTwo) {
                    if (cubeOne.getY() > cubeTwo.getY())
                        return 1;
                    if (cubeOne.getY() < cubeTwo.getY())
                        return -1;
                    return 0;
                }
            });

            for (int i = 0; i < cube.size(); i++) {
                int count = 0;
                int x = cube.get(i).getX();
                int y = cube.get(i).getY();

                while (y - count - 1 >= 0 && field.getEmptyField()[x][y - count - 1] < 5 && checkPlaceCube(x, y - count - 1)) {
                    count++;
                }
                cube.get(i).setMoveParams(LEFT, count);
            }
        }
    }

    public void logicMove(int start_x, int start_y, int end_x, int end_y) {
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
