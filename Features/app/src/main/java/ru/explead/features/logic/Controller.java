package ru.explead.features.logic;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ru.explead.features.MainActivity;
import ru.explead.features.Utils.UtilsFieldLevel;
import ru.explead.features.app.App;
import ru.explead.features.beans.CubeData;
import ru.explead.features.beans.LevelData;
import ru.explead.features.fragments.GameFragment;

/**
 * Created by develop on 30.12.2016.
 */

public class Controller {

    /**
     * левый нижний угол - (0, *), координаты.
     */

    public int CUBE = 99;
    public static int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4, NO_ACTIVE = 0;
    private Level level;
    private Field field;

    private Paint paintWall;

    public static int ACTIVE_GAME = 1, FINISH = 2;
    private int status;

    private ArrayList<CubeData> cubeData = new ArrayList<>();

    private Activity activity;

    public Controller(int sizeSurface, Activity activity) {
        this.activity = activity;
        level = App.getLevel();
        LevelData data = UtilsFieldLevel.getDataLevel(level.getLevel(), level.getComplexity(), sizeSurface);
        field = data.getField();
        cubeData = data.getCubeData();
        status = ACTIVE_GAME;
        createPaint();
    }

    public void onDraw(Canvas canvas) {
        for(int i = 0; i < cubeData.size(); i++) {
            cubeData.get(i).getCube().onDraw(canvas);
        }
        for(int i = 0; i < field.getField().length; i++) {
            for(int j = 0; j < field.getField().length; j++) {
                if(field.getField()[i][j] == 6) {
                    canvas.drawRect(j*field.getWidthCell(), i*field.getWidthCell(), j*field.getWidthCell() + field.getWidthCell(), i*field.getWidthCell() + field.getWidthCell(), paintWall);
                }
            }
        }
    }

    /**
     * Каждый тик потока отрисовки
     */
    public void onTick() {
        for(int i = 0; i < cubeData.size(); i++) {
            cubeData.get(i).getCube().onMove();
        }
        checkWin();
    }

    /**
     * Проверка - вохможно ли передвинуть кубик на данную клетку(занята клетка другим кубиком или нет)
     * @param n - индекс с которого необходимо проверять кубики
     * @param placeX - позиция проверяемой клетки по х
     * @param placeY - позиция проверяемой клетки по у
     * @return - true - если клетка свободна
     */
    private boolean checkPlaceCube(int n, int placeX, int placeY) {
        for(int i = n; i >= 0; i--) {
            if(placeX == cubeData.get(i).getCube().getX() && placeY == cubeData.get(i).getCube().getY()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка двигается ли какой из кубиков в данный момент
     * @return - false - если двигается
     */
    private boolean checkNoActiveMove() {
        for(int i = 0; i < cubeData.size(); i++) {
            if(cubeData.get(i).getCube().getStatus() != NO_ACTIVE) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяем закончилась игра или нет
     * @return - true - если кубики на своих местах
     */
    public boolean checkWin() {
        for(int i = 0; i < cubeData.size(); i++) {
            if(cubeData.get(i).getCube().getX() != cubeData.get(i).getEndPosition().getX() ||
                    cubeData.get(i).getCube().getY() != cubeData.get(i).getEndPosition().getY()) {
                return false;
            }
        }

        if(status == ACTIVE_GAME) {
            status = FINISH;
            ((GameFragment)MainActivity.getFragment()).onWin();
        }
        return true;
    }

    public void onMoveUp() {
        if(checkNoActiveMove()) {
            Collections.sort(cubeData, new Comparator<CubeData>() {
                @Override
                public int compare(CubeData cubeOne, CubeData cubeTwo) {
                    if (cubeOne.getCube().getX() > cubeTwo.getCube().getX())
                        return 1;
                    if (cubeOne.getCube().getX() < cubeTwo.getCube().getX())
                        return -1;
                    return 0;
                }
            });

            for (int i = 0; i < cubeData.size(); i++) {
                int count = 0;
                int x = cubeData.get(i).getCube().getX();
                int y = cubeData.get(i).getCube().getY();

                while (x - count - 1 >= 0 && field.getField()[x - count - 1][y] < 5 && checkPlaceCube(i, x - count - 1, y)) {
                    count++;
                }
                cubeData.get(i).getCube().setMoveParams(UP, count, 0);
            }
        }
    }

    public void onMoveDown() {
        if(checkNoActiveMove()) {
            Collections.sort(cubeData, new Comparator<CubeData>() {
                @Override
                public int compare(CubeData cubeOne, CubeData cubeTwo) {
                    if (cubeOne.getCube().getX() < cubeTwo.getCube().getX())
                        return 1;
                    if (cubeOne.getCube().getX() > cubeTwo.getCube().getX())
                        return -1;
                    return 0;
                }
            });

            for (int i = 0; i < cubeData.size(); i++) {
                int count = 0;
                int x = cubeData.get(i).getCube().getX();
                int y = cubeData.get(i).getCube().getY();

                while (x + count + 1 < field.getField().length && field.getField()[x + count + 1][y] < 5 && checkPlaceCube(i, x + count + 1, y)) {
                    count++;
                }
                cubeData.get(i).getCube().setMoveParams(DOWN, count, 0);
            }
        }
    }

    public void onMoveRight() {
        if(checkNoActiveMove()) {
            Collections.sort(cubeData, new Comparator<CubeData>() {
                @Override
                public int compare(CubeData cubeOne, CubeData cubeTwo) {
                    if (cubeOne.getCube().getY() < cubeTwo.getCube().getY())
                        return 1;
                    if (cubeOne.getCube().getY() > cubeTwo.getCube().getY())
                        return -1;
                    return 0;
                }
            });

            for (int i = 0; i < cubeData.size(); i++) {
                int count = 0;
                int x = cubeData.get(i).getCube().getX();
                int y = cubeData.get(i).getCube().getY();

                while (y + count + 1 < field.getField().length && field.getField()[x][y + count + 1] < 5 && checkPlaceCube(i, x, y + count + 1)) {
                    count++;
                }
                cubeData.get(i).getCube().setMoveParams(RIGHT, 0, count);
            }
        }
    }

    public void onMoveLeft() {
        if(checkNoActiveMove()) {
            Collections.sort(cubeData, new Comparator<CubeData>() {
                @Override
                public int compare(CubeData cubeOne, CubeData cubeTwo) {
                    if (cubeOne.getCube().getY() > cubeTwo.getCube().getY())
                        return 1;
                    if (cubeOne.getCube().getY() < cubeTwo.getCube().getY())
                        return -1;
                    return 0;
                }
            });

            for (int i = 0; i < cubeData.size(); i++) {
                int count = 0;
                int x = cubeData.get(i).getCube().getX();
                int y = cubeData.get(i).getCube().getY();

                while (y - count - 1 >= 0 && field.getField()[x][y - count - 1] < 5 && checkPlaceCube(i, x, y - count - 1)) {
                    count++;
                }
                cubeData.get(i).getCube().setMoveParams(LEFT, 0, count);
            }
        }
    }


    private void createPaint() {
        paintWall = new Paint();
        paintWall.setColor(Color.GRAY);
        paintWall.setAntiAlias(true);
    }

    public Level getLevel() {
        return level;
    }

    public Field getField() {
        return field;
    }

    public int getStatus() {
        return status;
    }
}
