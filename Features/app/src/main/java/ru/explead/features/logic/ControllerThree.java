package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;

import ru.explead.features.MainActivity;
import ru.explead.features.Utils.Utils;
import ru.explead.features.fragments.GameFragment;


/**
 * Created by develop on 22.02.2017.
 */

public class ControllerThree extends BaseController {


    private ArrayList<SnakeCoordinate> touchedCells = new ArrayList<>();

    private ArrayList<ArrayList<SnakeCoordinate>> allPath = new ArrayList<>();

    private Coordinate startPosition;
    private Coordinate endPosition;


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
            cube.get(i).onDraw(canvas);
        }
        for(int i = 0; i < allPath.size(); i++) {
            for(int j = 0; j < allPath.get(i).size(); j++) {
                int x = allPath.get(i).get(j).getX();
                int y = allPath.get(i).get(j).getY();
                canvas.drawRect(y*field.getWidthCell(), x*field.getWidthCell(), y*field.getWidthCell() + field.getWidthCell(), x*field.getWidthCell() + field.getWidthCell(), allPath.get(i).get(j).getPaint());
            }
        }
        for(int i = 0; i < touchedCells.size(); i++) {
            int x = touchedCells.get(i).getX();
            int y = touchedCells.get(i).getY();
            canvas.drawRect(y*field.getWidthCell(), x*field.getWidthCell(),
                    y*field.getWidthCell() + field.getWidthCell(), x*field.getWidthCell() + field.getWidthCell(), touchedCells.get(i).getPaint());
        }
    }

    /**
     * Проверка, нажатие на кубик или нет
     */
    public void checkTouchOnCube(int start_x, int start_y) {
        Coordinate coordinate = findCell(start_x, start_y);

        if(coordinate.getX() >= 0 && coordinate.getX() < field.getEmptyField().length && coordinate.getY() >= 0 && coordinate.getY() < field.getEmptyField().length) {
            if (checkSamePath(coordinate)) {
                for (int i = 0; i < cube.size(); i++) {
                    if ((cube.get(i).getX() == coordinate.getX() && cube.get(i).getY() == coordinate.getY())) {
                        touchedCells.add(new SnakeCoordinate(cube.get(i).getX(), cube.get(i).getY(), cube.get(i).getId()));
                        endPosition = new Coordinate(cube.get(i).getEndPosition().getX(), cube.get(i).getEndPosition().getY());
                        startPosition = coordinate;
                        return;
                    }
                    if ((cube.get(i).getEndPosition().getX() == coordinate.getX() && cube.get(i).getEndPosition().getY() == coordinate.getY())) {
                        touchedCells.add(new SnakeCoordinate(cube.get(i).getEndPosition().getX(), cube.get(i).getEndPosition().getY(), cube.get(i).getId()));
                        endPosition = new Coordinate(cube.get(i).getX(), cube.get(i).getY());
                        startPosition = coordinate;
                        return;
                    }
                }
            }
        }
        touchedCells.clear();
    }


    public void logicMove(int end_x, int end_y) {
        if(touchedCells.size() != 0) {
            Coordinate coordinate = findCell(end_x, end_y);
            if(coordinate.getX() >= 0 && coordinate.getX() < field.getEmptyField().length && coordinate.getY() >= 0 && coordinate.getY() < field.getEmptyField().length) {
                if (checkEmployedCell(coordinate) && checkCurrentCellNearLastCell(coordinate) && !checkEndPositionInArray() && !checkNearEndPositionInArray()) {
                    int id = touchedCells.get(0).getId();
                    touchedCells.add(new SnakeCoordinate(coordinate.getX(), coordinate.getY(), id));
                }

                //Удаляем, если мы возвращаемся по цепочки
                if (touchedCells.size() > 1) {
                    if (touchedCells.get(touchedCells.size() - 2).getX() == coordinate.getX() && touchedCells.get(touchedCells.size() - 2).getY() == coordinate.getY()) {
                        touchedCells.remove(touchedCells.size() - 1);
                    }
                }
            }
        }
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

    /**
     * Проверка, можно ли начать цепочку из этого кубика(был он или нет)
     * @return - true - можно
     */
    public boolean checkSamePath(Coordinate coordinate) {
        for(int i = 0; i < allPath.size(); i++) {
            if((allPath.get(i).get(0).getX() == coordinate.getX() && allPath.get(i).get(0).getY() == coordinate.getY()) ||
                    (allPath.get(i).get(allPath.get(i).size()-1).getX() == coordinate.getX() && allPath.get(i).get(allPath.get(i).size()-1).getY() == coordinate.getY()) ) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка, можно ли вступить на клетку
     * @param coordinate - координаты клетки на которой сейчас находимся
     * @return - true - если на эту клетку можно вступить
     */
    public boolean checkEmployedCell(Coordinate coordinate) {
        //Если мы на конечной клетке, то можем на нее вступить
        if(endPosition.getX() == coordinate.getX() && endPosition.getY() == coordinate.getY()) {
            return true;
        }
        //Если это стена
        if(field.getEmptyField()[coordinate.getX()][coordinate.getY()] == 6) {
            return false;
        }
        for(int i = 0; i < touchedCells.size(); i++) {
            if(touchedCells.get(i).getX() == coordinate.getX() && touchedCells.get(i).getY() == coordinate.getY()) {
                return false;
            }
        }
        for(int i = 0; i < allPath.size(); i++) {
            for(int j = 0; j < allPath.get(i).size(); j++) {
                if (allPath.get(i).get(j).getX() == coordinate.getX() && allPath.get(i).get(j).getY() == coordinate.getY()) {
                    return false;
                }
            }
        }
        for(int i = 0; i < cube.size(); i++) {
            //Если мы на какой-то другой клетке, то нельзя
            if(coordinate.getX() == cube.get(i).getX() && coordinate.getY() == cube.get(i).getY() ||
                    coordinate.getX() == cube.get(i).getEndPosition().getX() && coordinate.getY() == cube.get(i).getEndPosition().getY()) {
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
                SnakeCoordinate lastCube = touchedCells.get(touchedCells.size() - 1);
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
            if (touchedCells.get(touchedCells.size() - 1).getX() == endPosition.getX() && touchedCells.get(touchedCells.size() - 1).getY() == endPosition.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверка, рядом с конечной или нет
     * @return - true - если рядом
     */
    public boolean checkNearEndPositionInArray() {
        if(touchedCells.size() != 0){
            if ((endPosition.getX() == touchedCells.get(touchedCells.size() - 1).getX() && Math.abs(endPosition.getY() - touchedCells.get(touchedCells.size() - 1).getY()) == 1 ||
                    (Math.abs(endPosition.getX() - touchedCells.get(touchedCells.size() - 1).getX()) == 1 && endPosition.getY() == touchedCells.get(touchedCells.size() - 1).getY()))) {
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
            if(checkEndPositionInArray() || checkNearEndPositionInArray()) {

                SnakeCoordinate lastCoordinate = touchedCells.get(touchedCells.size()-1);
                if(lastCoordinate.getX() != endPosition.getX() || lastCoordinate.getY() != endPosition.getY()) {
                    int id = touchedCells.get(0).getId();
                    touchedCells.add(new SnakeCoordinate(endPosition.getX(), endPosition.getY(), id));
                }

                ArrayList<SnakeCoordinate> copyList = new ArrayList<>();
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


    public void onDeletePath(int x, int y) {
        Coordinate coordinateTouch = findCell(x, y);
        for(int i = 0; i < allPath.size(); i++) {
            for(int j = 0; j < allPath.get(i).size(); j++) {
                if(allPath.get(i).get(j).getX() == coordinateTouch.getX() && allPath.get(i).get(j).getY() == coordinateTouch.getY()) {
                    allPath.remove(i);
                    return;
                }
            }
        }
    }



    class SnakeCoordinate {

        private int x;
        private int y;
        private int id;

        private Paint paint;

        public SnakeCoordinate(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
            paint = Utils.getDrawableCube(id);
        }

        public int getId() {
            return id;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Paint getPaint() {
            return paint;
        }
    }

}
