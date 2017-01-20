package ru.explead.features.Utils;

import ru.explead.features.logic.Level;

/**
 * Created by develop on 20.01.2017.
 */

public class UtilsFieldLevel {

    private static int[][] field;

    public static int[][] getFieldLevel(int level, int complexity) {
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
        return field;
    }

    private static void getLevelFromEasy(int level) {
        if(level == 1) {
            field = new int[][] {
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 0}
            };
        }
    }

    private static void getLevelFromMedium(int level) {

    }

    private static void getLevelFromHard(int level) {

    }

    private static void getLevelFromVeryHard(int level) {

    }
}
