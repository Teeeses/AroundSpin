package ru.explead.features.Utils;


import android.graphics.Color;

import java.util.ArrayList;

import ru.explead.features.beans.CubeData;
import ru.explead.features.beans.EndPosition;
import ru.explead.features.beans.LevelData;
import ru.explead.features.logic.Cube;
import ru.explead.features.logic.Field;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 20.01.2017.
 */

public class UtilsFieldLevel {

    private static LevelData levelData;
    private static int sizeSurface;

    public static LevelData getDataLevel(int level, int complexity, int size) {
        sizeSurface = size;
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
        return levelData;
    }

    private static void getLevelFromEasy(int level) {
        if(level == 1) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0},
                    {6, 0, 6, 6, 0, 0},
                    {0, 0, 6, 6, 0, 0},
                    {1, 2, 0, 0, 0, 0},
                    {0, 0, 6, 6, 6, 6},
                    {0, 0, 6, 6, 6, 6}
            };
            Field field = new Field(sizeSurface, mass);
            ArrayList<CubeData> cubeDataList = new ArrayList<>();
            cubeDataList.add(new CubeData(new Cube(5, 0, Color.MAGENTA, field), new EndPosition(5, 1)));
            cubeDataList.add(new CubeData(new Cube(5, 1, Color.RED, field), new EndPosition(5, 0)));
            levelData = new LevelData(field, cubeDataList);
        }
    }



    private static void getLevelFromMedium(int level) {

    }



    private static void getLevelFromHard(int level) {

    }



    private static void getLevelFromVeryHard(int level) {

    }
}
