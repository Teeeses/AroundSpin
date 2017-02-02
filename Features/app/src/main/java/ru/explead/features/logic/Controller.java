package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ru.explead.features.LevelsActivity;
import ru.explead.features.MainActivity;
import ru.explead.features.R;
import ru.explead.features.Utils.Utils;
import ru.explead.features.Utils.UtilsFieldLevel;
import ru.explead.features.app.App;
import ru.explead.features.fragments.GameFragment;

/**
 * Created by develop on 30.12.2016.
 */

public class Controller {

    /**
     * левый нижний угол - (0, *), координаты.
     */
    public static int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3, NO_ACTIVE = -1;

    public static int ACTIVE_GAME = 1, FINISH = 2;
    private int status;

    private Level level;
    private Field field;
    private ArrayList<Cube> cube = new ArrayList<>();

    private Paint paintWall;


    //**********
    //Тестовые данные
    private int maxIterations = 5;
    //**********

    public Controller() {
        createPaint();
    }

    public void startGame() {
        level = App.getLevel();
        UtilsFieldLevel.getDataLevel(level.getLevel(), level.getComplexity());
        status = ACTIVE_GAME;
    }

    public void startTest() {
        int lastDirection = NO_ACTIVE;
        algorithm(lastDirection, 0, new ArrayList<String>());
    }

    public void onDraw(Canvas canvas) {
        for(int i = 0; i < cube.size(); i++) {
            cube.get(i).getEndPosition().onDraw(canvas);
        }
        for(int i = 0; i < cube.size(); i++) {
            cube.get(i).onDraw(canvas);
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
        for (int i = 0; i < cube.size(); i++) {
            cube.get(i).onMove();
        }
        if(status == ACTIVE_GAME) {
            if(checkWin()) {
                ((GameFragment)MainActivity.getFragment()).onWin();
            }
        }
    }

    /**
     * Проверка - вохможно ли передвинуть кубик на данную клетку(занята клетка другим кубиком или нет)
     * @param placeX - позиция проверяемой клетки по х
     * @param placeY - позиция проверяемой клетки по у
     * @return - true - если клетка свободна
     */
    private boolean checkPlaceCube(int placeX, int placeY) {
        for(int i = 0; i < cube.size(); i++) {
            if((placeX == cube.get(i).getX() && placeY == cube.get(i).getY()) || field.getField()[placeX][placeY] > 5) {
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
        for(int i = 0; i < cube.size(); i++) {
            if(cube.get(i).getStatus() != NO_ACTIVE) {
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
        for(int i = 0; i < cube.size(); i++) {
            if(cube.get(i).getX() != cube.get(i).getEndPosition().getX() ||
                    cube.get(i).getY() != cube.get(i).getEndPosition().getY()) {
                return false;
            }
        }
        status = FINISH;
        return true;
    }

    public void onMoveUp() {
        if(checkNoActiveMove()) {
            /*Collections.sort(cube, new Comparator<Cube>() {
                @Override
                public int compare(Cube cubeOne, Cube cubeTwo) {
                    if (cubeOne.getX() > cubeTwo.getX())
                        return 1;
                    if (cubeOne.getX() < cubeTwo.getX())
                        return -1;
                    return 0;
                }
            });*/

            for (int i = 0; i < cube.size(); i++) {
                int count = 0;
                int x = cube.get(i).getX();
                int y = cube.get(i).getY();

                while (x - count - 1 >= 0 && field.getField()[x - count - 1][y] < 5 && checkPlaceCube(x - count - 1, y)) {
                    count++;
                }
                cube.get(i).setMoveParams(UP, count, 0);
            }
        }
    }

    public void onMoveDown() {
        if(checkNoActiveMove()) {
            /*Collections.sort(cube, new Comparator<Cube>() {
                @Override
                public int compare(Cube cubeOne, Cube cubeTwo) {
                    if (cubeOne.getX() < cubeTwo.getX())
                        return 1;
                    if (cubeOne.getX() > cubeTwo.getX())
                        return -1;
                    return 0;
                }
            });*/

            for (int i = 0; i < cube.size(); i++) {
                int count = 0;
                int x = cube.get(i).getX();
                int y = cube.get(i).getY();

                while (x + count + 1 < field.getField().length && field.getField()[x + count + 1][y] < 5 && checkPlaceCube(x + count + 1, y)) {
                    count++;
                }
                cube.get(i).setMoveParams(DOWN, count, 0);
            }
        }
    }

    public void onMoveRight() {
        if(checkNoActiveMove()) {
            /*Collections.sort(cube, new Comparator<Cube>() {
                @Override
                public int compare(Cube cubeOne, Cube cubeTwo) {
                    if (cubeOne.getY() < cubeTwo.getY())
                        return 1;
                    if (cubeOne.getY() > cubeTwo.getY())
                        return -1;
                    return 0;
                }
            });*/

            for (int i = 0; i < cube.size(); i++) {
                int count = 0;
                int x = cube.get(i).getX();
                int y = cube.get(i).getY();

                while (y + count + 1 < field.getField().length && field.getField()[x][y + count + 1] < 5 && checkPlaceCube(x, y + count + 1)) {
                    count++;
                }
                cube.get(i).setMoveParams(RIGHT, 0, count);
            }
        }
    }

    public void onMoveLeft() {
        if(checkNoActiveMove()) {
            /*Collections.sort(cube, new Comparator<Cube>() {
                @Override
                public int compare(Cube cubeOne, Cube cubeTwo) {
                    if (cubeOne.getY() > cubeTwo.getY())
                        return 1;
                    if (cubeOne.getY() < cubeTwo.getY())
                        return -1;
                    return 0;
                }
            });*/

            for (int i = 0; i < cube.size(); i++) {
                int count = 0;
                int x = cube.get(i).getX();
                int y = cube.get(i).getY();

                while (y - count - 1 >= 0 && field.getField()[x][y - count - 1] < 5 && checkPlaceCube(x, y - count - 1)) {
                    count++;
                }
                cube.get(i).setMoveParams(LEFT, 0, count);
            }
        }
    }

    public void findEmptyDirection(int lastDirection, boolean[] directions) {
        int[][] field = App.getController().getField().getField();
        for(int i = 0; i < cube.size(); i++) {
            if(cube.get(i).getX() != 0 && checkPlaceCube(cube.get(i).getX() - 1, cube.get(i).getY())) {
                directions[UP] = true;
            }
            if(cube.get(i).getX() != field.length-1 && checkPlaceCube(cube.get(i).getX() + 1, cube.get(i).getY())) {
                directions[DOWN] = true;
            }
            if(cube.get(i).getY() != 0 && checkPlaceCube(cube.get(i).getX(), cube.get(i).getY() - 1)) {
                directions[LEFT] = true;
            }
            if(cube.get(i).getY() != field.length-1 && checkPlaceCube(cube.get(i).getX(), cube.get(i).getY() + 1)) {
                directions[RIGHT] = true;
            }
        }
        if(lastDirection != NO_ACTIVE) {
            if(lastDirection == UP) {
                directions[UP] = false;
            }
            if(lastDirection == RIGHT) {
                directions[RIGHT] = false;
            }
            if(lastDirection == DOWN) {
                directions[DOWN] = false;
            }
            if(lastDirection == LEFT) {
                directions[LEFT] = false;
            }
        }
    }

    public void algorithm(int lastDirection, int iterations, ArrayList<String> wentList) {
        if(iterations > maxIterations) {
            Utils.writeArrayList(wentList);
            wentList.clear();
            return;
        }
        if(checkWin()) {
            Utils.writeArrayList(wentList);
            return;
        }
        Log.d("TAG", "x: " + cube.get(0).getX() + " y: " + cube.get(0).getY() + " x: " + cube.get(1).getX() + " y: " + cube.get(1).getY());
        boolean[] directions = {false, false, false, false};
        findEmptyDirection(lastDirection, directions);
        iterations++;
        if (directions[UP]) {
            wentList.add("Вверх");
            lastDirection = UP;
            App.getController().onMoveUp();
            algorithm(lastDirection, iterations, wentList);
        }
        if (directions[RIGHT]) {
            wentList.add("Направо");
            lastDirection = RIGHT;
            App.getController().onMoveRight();
            algorithm(lastDirection, iterations, wentList);
        }
        if (directions[DOWN]) {
            wentList.add("Вниз");
            lastDirection = DOWN;
            App.getController().onMoveDown();
            algorithm(lastDirection, iterations, wentList);
        }
        if (directions[LEFT]) {
            wentList.add("Налево");
            lastDirection = LEFT;
            App.getController().onMoveLeft();
            algorithm(lastDirection, iterations, wentList);
        }

    }




    private void createPaint() {
        paintWall = new Paint();
        paintWall.setColor(LevelsActivity.getActivity().getResources().getColor(R.color.colorPrimary));
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

    public void setField(Field field) {
        this.field = field;
    }

    public void setCube(ArrayList<Cube> cube) {
        this.cube = cube;
    }
}
