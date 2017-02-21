package ru.explead.features.beans;

import ru.explead.features.LevelsActivity;
import ru.explead.features.Utils.Utils;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 30.01.2017.
 */

public class ButtonLevel {

    private int number;
    private int complexity;

    public static final int STATUS_OPEN = 1, STATUS_CURRENT = 2, STATUS_CLOSE = 3;
    private int status;

    public ButtonLevel(int complexity, int number) {
        this.complexity = complexity;
        this.number = number;
        findStatus();
    }

    public void findStatus() {
        if(complexity == Level.EASY) {
            int easy_current_level = LevelsActivity.getPref().getInt(Utils.EASY_CURRENT_LEVEL, 1);
            installStatus(easy_current_level);
        }
        if(complexity == Level.MEDIUM) {
            int medium_current_level = LevelsActivity.getPref().getInt(Utils.MEDIUM_CURRENT_LEVEL, 1);
            installStatus(medium_current_level);
        }
    }

    private void installStatus(int current) {
        if(number == current) {
            status = STATUS_CURRENT;
        }
        if(number > current) {
            status = STATUS_CLOSE;
        }
        if(number < current) {
            status = STATUS_OPEN;
        }
    }

    public int getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }

    public int getComplexity() {
        return complexity;
    }
}