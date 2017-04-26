package ru.explead.features.logic;

import android.graphics.Paint;

import java.util.ArrayList;

import ru.explead.features.LevelsActivity;
import ru.explead.features.MainActivity;
import ru.explead.features.Utils.UtilsFieldLevel;
import ru.explead.features.app.App;
import ru.explead.features.fragments.GameFragment;

/**
 * Created by develop on 21.02.2017.
 */

public abstract class BaseController {

    /**
     * левый нижний угол - (0, *), координаты.
     */
    public static int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3, NO_ACTIVE = -1;

    public static int ACTIVE_GAME = 1, FINISH = 2;
    protected int status;

    protected Level level;
    protected Field field;
    protected ArrayList<Cube> cube = new ArrayList<>();

    protected Paint paintWall = new Paint();

    public void startGame() {
        level = App.getLevel();
        UtilsFieldLevel.getDataLevel(level.getLevel(), level.getComplexity());
        status = ACTIVE_GAME;
    }

    public void createPaint() {
        paintWall.setColor(LevelsActivity.getActivity().getResources().getColor(android.R.color.darker_gray));
        paintWall.setAntiAlias(true);
    }

    /**
     * Проверяем закончилась игра или нет
     * @return - true - если кубики на своих местах
     */
    private boolean checkWin() {
        for(int i = 0; i < cube.size(); i++) {
            if(cube.get(i).getX() != cube.get(i).getEndPosition().getX() ||
                    cube.get(i).getY() != cube.get(i).getEndPosition().getY()) {
                return false;
            }
        }
        status = FINISH;
        return true;
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
                ((GameFragment) MainActivity.getFragment()).onWin();
            }
        }
    }

    /**
     * Проверка двигается ли какой из кубиков в данный момент
     * @return - false - если двигается
     */
    public boolean checkNoActiveMove() {
        for(int i = 0; i < cube.size(); i++) {
            if(cube.get(i).getStatus() != NO_ACTIVE) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка - вохможно ли передвинуть кубик на данную клетку(занята клетка другим кубиком или нет)
     * @param placeX - позиция проверяемой клетки по х
     * @param placeY - позиция проверяемой клетки по у
     * @return - true - если клетка свободна
     */
    public boolean checkPlaceCube(int placeX, int placeY) {
        for(int i = 0; i < cube.size(); i++) {
            if((placeX == cube.get(i).getX() && placeY == cube.get(i).getY()) || field.getEmptyField()[placeX][placeY] > 5) {
                return false;
            }
        }
        return true;
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
