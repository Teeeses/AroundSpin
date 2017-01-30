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
            System.out.println(easy_current_level + " " + number);
            if(number == easy_current_level) {
                status = STATUS_CURRENT;
            }
            if(number > easy_current_level) {
                status = STATUS_CLOSE;
            }
            if(number < easy_current_level) {
                status = STATUS_OPEN;
            }
        }
        if(complexity == Level.MEDIUM) {

        }
        if(complexity == Level.HARD) {

        }
        if(complexity == Level.VERY_HARD) {

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