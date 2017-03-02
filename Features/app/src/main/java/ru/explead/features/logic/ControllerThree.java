package ru.explead.features.logic;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;

import ru.explead.features.MainActivity;
import ru.explead.features.fragments.GameFragment;


/**
 * Created by develop on 22.02.2017.
 */

public class ControllerThree extends BaseController {


    private ArrayList<Cube> touchedCells = new ArrayList<>();

    private ArrayList<ArrayList<Cube>> allPath = new ArrayList<>();

    public ControllerThree() {
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
            cube.get(i).getEndPosition().onDrawNormal(canvas);
        }
        for(int i = 0; i < cube.size(); i++) {
            //canvas.drawRect(cube.get(i).getY()*getField().getWidthCell() + field.getWidthCell()*0.25f, cube.get(i).getX()*getField().getWidthCell() + field.getWidthCell()*0.75f,
            //        cube.get(i).getY()*getField().getWidthCell() + field.getWidthCell()*0.75f, cube.get(i).getX()*getField().getWidthCell() + field.getWidthCell()*0.25f, cube.get(i).getPaint());
            cube.get(i).onDraw(canvas);
        }
        for(int i = 0; i < touchedCells.size(); i++) {
            touchedCells.get(i).onDraw(canvas);
        }
        for(int i = 0; i < allPath.size(); i++) {
            for(int j = 0; j < allPath.get(i).size() - 1; j++) {
                //allPath.get(i).get(j).onDrawSmall(canvas, allPath.get(i).get(j), allPath.get(i).get(j+1));
                allPath.get(i).get(j).onDraw(canvas);
            }
        }
    }

    /**
     * Проверка, нажатие на кубик или нет
     */
    public void checkTouchOnCube(int start_x, int start_y) {
        Coordinate coordinate = findCell(start_x, start_y);
        if(checkSamePath(coordinate)) {
            for (int i = 0; i < cube.size(); i++) {
                if ((cube.get(i).getX() == coordinate.getX() && cube.get(i).getY() == coordinate.getY()) ||
                        (cube.get(i).getEndPosition().getX() == coordinate.getX() && cube.get(i).getEndPosition().getY() == coordinate.getY())) {
                    touchedCells.add(new Cube(cube.get(i).getX(), cube.get(i).getY(), cube.get(i).getColor(), cube.get(i).getEndPosition()));
                    return;
                }
            }
        }
        touchedCells.clear();
    }

    /**
     * Поиск клетки на которую нажали
     * @param start_x - начало по х движения пальца
     * @param start_y - начало по y движения пальца
     * @return - координаты
     */
    private Coordinate findCell(int start_x, int start_y) {
        return new Coordinate((int)(start_y/field.getWidthCell()), (int)(start_x/field.getWidthCell()));
    }

    public void logicMove(int end_x, int end_y) {
        Log.d("TAG", Integer.toString(touchedCells.size()));
        if(touchedCells.size() != 0) {
            Coordinate coordinate = findCell(end_x, end_y);
            if(checkEmployedCell(coordinate) && checkCurrentCellNearLastCell(coordinate) /*&& !checkEndPositionInArray() && checkPlaceCube(coordinate.getX(), coordinate.getY()) && checkElseEndPosition(coordinate)*/) {
                touchedCells.add(new Cube(coordinate.getX(), coordinate.getY(), touchedCells.get(0).getColor(), touchedCells.get(0).getEndPosition()));
            }

            //Удаляем, если мы возвращаемся по цепочки
            if(touchedCells.size() > 1) {
                if(touchedCells.get(touchedCells.size()-2).getX() == coordinate.getX() && touchedCells.get(touchedCells.size()-2).getY() == coordinate.getY()) {
                    touchedCells.remove(touchedCells.size()-1);
                }
            }
        }
    }

    /**
     * Чужая конечная точка или на которую можно наехать
     * @param coordinate
     * @return
     */
    public boolean checkElseEndPosition(Coordinate coordinate) {
        for(int i = 0; i < cube.size(); i++) {
            if(coordinate.getX() == cube.get(i).getEndPosition().getX() && coordinate.getY() == cube.get(i).getEndPosition().getY()) {
                if(touchedCells.get(0).getX() != cube.get(i).getX() && touchedCells.get(0).getY() != cube.get(i).getY()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Проверка, можно ли начать цепочку из этого кубика(был он или нет)
     * @return - true - можно
     */
    public boolean checkSamePath(Coordinate coordinate) {
        for(int i = 0; i < allPath.size(); i++) {
            if((allPath.get(i).get(0).getX() == coordinate.getX() && allPath.get(i).get(0).getY() == coordinate.getY()) ||
                    (allPath.get(i).get(0).getEndPosition().getX() == coordinate.getX() && allPath.get(i).get(0).getEndPosition().getY() == coordinate.getY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка, проходили мы эту клетку или нет
     * @param coordinate - координаты клетки на которой сейчас находимся
     * @return - true - если на эту клетку мы еще не наступали
     */
    public boolean checkEmployedCell(Coordinate coordinate) {
        for(int i = 0; i < touchedCells.size(); i++) {
            if(touchedCells.get(i).getX() == coordinate.getX() && touchedCells.get(i).getY() == coordinate.getY() ||
                    touchedCells.get(i).getEndPosition().getX() == coordinate.getX() && touchedCells.get(i).getEndPosition().getY() == coordinate.getY()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Можно ли захватить клетку над которой палец, находиться ли она слева, справа, сверхе или снизу предыдущей
     * @param coordinate - соординаты клетки над которой палец
     * @return - true - можно
     */
    public boolean checkCurrentCellNearLastCell(Coordinate coordinate) {
        if(touchedCells.size() != 0) {
            if(coordinate.getX() >= 0 && coordinate.getX() < field.getEmptyField().length && coordinate.getY() >= 0 && coordinate.getY() < field.getEmptyField().length) {
                Cube lastCube = touchedCells.get(touchedCells.size() - 1);
                if ((lastCube.getX() == coordinate.getX() && Math.abs(lastCube.getY() - coordinate.getY()) == 1 ||
                        (Math.abs(lastCube.getX() - coordinate.getX()) == 1 && lastCube.getY() == coordinate.getY()))) {
                    return true;

                }
            }
        }
        return false;
    }

    /**
     * Проверка, есть ли конечная точка в списке
     * @return - true - если есть
     */
    public boolean checkEndPositionInArray() {
        if(touchedCells.size() != 0){
            if (touchedCells.get(touchedCells.size() - 1).getX() == touchedCells.get(0).getEndPosition().getX() && touchedCells.get(touchedCells.size() - 1).getY() == touchedCells.get(0).getEndPosition().getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Вызывается при отпускании пальца
     */
    public void onUpFinger() {
        if(touchedCells.size() != 0) {
            if(checkEndPositionInArray()) {
                ArrayList<Cube> copyList = new ArrayList<>();
                for(int i = 0; i < touchedCells.size(); i++) {
                    copyList.add(touchedCells.get(i));
                }
                allPath.add(copyList);
            }
        }
        touchedCells.clear();

        checkWin();
    }

    private boolean checkWin() {
        if(allPath.size() == cube.size()) {
            status = FINISH;
            ((GameFragment) MainActivity.getFragment()).onWin();
            return true;
        }
        return false;
    }

}
