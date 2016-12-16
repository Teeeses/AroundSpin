package ru.explead.features.Utils;

import android.content.SharedPreferences;

/**
 * Created by develop on 16.12.2016.
 */
public class Utils {

    private static SharedPreferences sPref;

    public static int getCurrentLevel() {
        return sPref.getInt(Const.LEVEL, 1);
    }

    public static void setCurrentLevel(int currentLevel) {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt(Const.LEVEL, currentLevel);
        editor.apply();
    }

    public static SharedPreferences getPref() {
        return sPref;
    }

    public static void setPref(SharedPreferences sPref) {
        Utils.sPref = sPref;
    }
}
