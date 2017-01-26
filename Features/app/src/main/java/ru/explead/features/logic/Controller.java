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
    private int[][] fieldCubes;

    public Controller(int sizeSurface) {
        this.sizeSurface = sizeSurface;
        level = App.getLevel();
        LevelData data = UtilsFieldLevel.getDataLevel(level.getLevel(), level.getComplexity(), sizeSurface);
        field = data.getField();
        cubes = data.getCubes();

        fieldCubes = new int[field.getField().length][field.getField().length];
        for(int i = 0; i < fieldCubes.length; i++) {
            for (int j = 0; j < fieldCubes.length; j++) {
                fieldCubes[i][j] = field.getField()[i][j];
            }
        }
        changeFieldCubes();

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

    private void changeFieldCubes() {
        for(int i =0; i < cubes.size(); i++) {
            fieldCubes[cubes.get(i).getX()][cubes.get(i).getY()] = CUBE;
        }
    }

    public void onMoveRight() {
        Log.d("TAG", "move right");
    }

    public void onMoveLeft() {
        Log.d("TAG", "move left");
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
