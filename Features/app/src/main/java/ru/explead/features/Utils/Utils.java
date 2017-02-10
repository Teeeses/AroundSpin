package ru.explead.features.Utils;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by develop on 16.12.2016.
 */
public class Utils {


    public final static String EASY_CURRENT_LEVEL = "easy_current_level";
    public final static String MEDIUM_CURRENT_LEVEL = "medium_current_level";
    public static final String APP_PREFERENCES = "mysettings";

    public static void writeTable(int[][] table) {
        System.out.println();
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void writeArrayList(ArrayList<String> array) {
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}
