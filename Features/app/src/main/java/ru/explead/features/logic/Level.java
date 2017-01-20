package ru.explead.features.logic;

/**
 * Created by develop on 20.01.2017.
 */

public class Level {

    private int EASY = 0, MEDIUM = 1, HARD = 2, VERY_HARD = 3;
    private int complexity;

    private int level;

    public int[][] getFieldLevel(int level) {
        int[][] field = null;
        if(complexity == EASY) {
            getLevelFromEasy(field);
        }
        if(complexity == MEDIUM) {
            getLevelFromMedium(field);
        }
        if(complexity == HARD) {
            getLevelFromHard(field);
        }
        if(complexity == VERY_HARD) {
            getLevelFromVeryHard(field);
        }
        return field;
    }

    private void getLevelFromEasy(int[][] field) {

    }

    private void getLevelFromMedium(int[][] field) {

    }

    private void getLevelFromHard(int[][] field) {

    }

    private void getLevelFromVeryHard(int[][] field) {

    }

}
