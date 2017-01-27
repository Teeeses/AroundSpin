package ru.explead.features.Utils;


import android.graphics.Color;

import java.util.ArrayList;

import ru.explead.features.app.App;
import ru.explead.features.beans.EndPosition;
import ru.explead.features.logic.Cube;
import ru.explead.features.logic.Field;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 20.01.2017.
 */

public class UtilsFieldLevel {


    public static void getDataLevel(int level, int complexity) {
        if(complexity == Level.EASY) {
            getLevelFromEasy(level);
        }
        if(complexity == Level.MEDIUM) {
            getLevelFromMedium(level);
        }
        if(complexity == Level.HARD) {
            getLevelFromHard(level);
        }
        if(complexity == Level.VERY_HARD) {
            getLevelFromVeryHard(level);
        }
    }

    private static void getLevelFromEasy(int level) {
        if(level == 1) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0},
                    {6, 0, 6, 6, 0, 0},
                    {0, 0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 6, 6, 6},
                    {0, 0, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(5, 0, Color.MAGENTA, new EndPosition(5, 1)));
            cubeList.add(new Cube(5, 1, Color.RED, new EndPosition(5, 0)));
            cubeList.add(new Cube(4, 1, Color.BLACK, new EndPosition(4, 1)));
            App.getController().setCube(cubeList);
        }
    }



    private static void getLevelFromMedium(int level) {

    }



    private static void getLevelFromHard(int level) {

    }



    private static void getLevelFromVeryHard(int level) {

    }
}
