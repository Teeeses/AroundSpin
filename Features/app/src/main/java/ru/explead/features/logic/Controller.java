package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ru.explead.features.Utils.UtilsFieldLevel;
import ru.explead.features.app.App;
import ru.explead.features.beans.LevelData;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by develop on 30.12.2016.
 */

public class Controller {

    /**
     * левый нижний угол - (0, *), координаты.
     */

    public int CUBE = 99;
    public static int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    private Level level;
    private Field field;

    private Paint paintWall;
    private int sizeSurface;

    private ArrayList<Cube> cubes = new ArrayList<>();

    public Controller(int sizeSurface) {
        this.sizeSurface = sizeSurface;
        level = App.getLevel();
        LevelData data = UtilsFieldLevel.getDataLevel(level.getLevel(), level.getComplexity(), sizeSurface);
        field = data.getField();
        cubes = data.getCubes();;

        createPaint();
    }

    public void onDraw(Canvas canvas) {
        for(int i = 0; i < cubes.size(); i++) {
            cubes.get(i).onDraw(canvas);
        }
        for(int i = 0; i < field.getField().length; i++) {
            for(int j = 0; j < field.getField().length; j++) {
                if(field.getField()[i][j] == 6) {
                    canvas.drawRect(j*field.getWidthCell(), i*field.getWidthCell(), j*field.getWidthCell() + field.getWidthCell(), i*field.getWidthCell() + field.getWidthCell(), paintWall);
                }
            }
        }
    }

    public void onTick() {
        for(int  i = 0; i < cubes.size(); i++) {
            cubes.get(i).onMove();
        }
    }

    private boolean checkPlaceCube(int n, int placeX, int placeY) {
        for(int i = n; i >= 0; i--) {
            if(placeX == cubes.get(i).getX() && placeY == cubes.get(i).getY()) {
                return false;
            }
        }
        return true;
    }

    public void onMoveUp() {
        Log.d("TAG", "move up");
        Collections.sort(cubes, new Comparator<Cube>() {
            @Override
            public int compare(Cube cubeOne, Cube cubeTwo) {
                if(cubeOne.getX() > cubeTwo.getX())
                    return 1;
                if(cubeOne.getX() < cubeTwo.getX())
                    return -1;
                return 0;
            }
        });

        for(int i = 0; i < cubes.size(); i++) {
            int count = 0;
            int x = cubes.get(i).getX();
            int y = cubes.get(i).getY();

            while (x - count - 1 >= 0 && field.getField()[x - count - 1][y] < 5 && checkPlaceCube(i, x - count - 1, y)) {
                count++;
            }
            cubes.get(i).setMoveParams(UP, count, 0);
        }
    }

    public void onMoveDown() {
        Log.d("TAG", "down up");
        Collections.sort(cubes, new Comparator<Cube>() {
            @Override
            public int compare(Cube cubeOne, Cube cubeTwo) {
                if(cubeOne.getX() < cubeTwo.getX())
                    return 1;
                if(cubeOne.getX() > cubeTwo.getX())
                    return -1;
                return 0;
            }
        });

        for(int i = 0; i < cubes.size(); i++) {
            int count = 0;
            int x = cubes.get(i).getX();
            int y = cubes.get(i).getY();

            while (x + count + 1 < field.getField().length && field.getField()[x + count + 1][y] < 5 && checkPlaceCube(i, x + count + 1, y)) {
                count++;
            }
            cubes.get(i).setMoveParams(DOWN, count, 0);
        }
    }

    public void onMoveRight() {
        Log.d("TAG", "move right");
        Collections.sort(cubes, new Comparator<Cube>() {
            @Override
            public int compare(Cube cubeOne, Cube cubeTwo) {
                if(cubeOne.getY() < cubeTwo.getY())
                    return 1;
                if(cubeOne.getY() > cubeTwo.getY())
                    return -1;
                return 0;
            }
        });

        for(int i = 0; i < cubes.size(); i++) {
            int count = 0;
            int x = cubes.get(i).getX();
            int y = cubes.get(i).getY();

            while (y + count + 1 < field.getField().length && field.getField()[x][y + count + 1] < 5 && checkPlaceCube(i, x, y + count + 1)) {
                count++;
            }
            cubes.get(i).setMoveParams(RIGHT, 0, count);
        }
    }

    public void onMoveLeft() {
        Log.d("TAG", "move left");
        Collections.sort(cubes, new Comparator<Cube>() {
            @Override
            public int compare(Cube cubeOne, Cube cubeTwo) {
                if(cubeOne.getY() > cubeTwo.getY())
                    return 1;
                if(cubeOne.getY() < cubeTwo.getY())
                    return -1;
                return 0;
            }
        });

        for(int i = 0; i < cubes.size(); i++) {
            int count = 0;
            int x = cubes.get(i).getX();
            int y = cubes.get(i).getY();

            while (y - count - 1 >= 0 && field.getField()[x][y - count - 1] < 5 && checkPlaceCube(i, x, y - count - 1)) {
                count++;
            }
            cubes.get(i).setMoveParams(LEFT, 0, count);
        }
    }

    public void writeList() {
        System.out.println();
        for (Cube str : cubes) {
            System.out.print(Integer.toString(str.getX()) + " ");
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

}
