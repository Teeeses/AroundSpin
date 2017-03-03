package ru.explead.features.Utils;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;

import java.util.ArrayList;

import ru.explead.features.LevelsActivity;

/**
 * Created by develop on 16.12.2016.
 */
public class Utils {


    public final static String EASY_CURRENT_LEVEL = "easy_current_level";
    public final static String MEDIUM_CURRENT_LEVEL = "medium_current_level";
    public final static String HARD_CURRENT_LEVEL = "hard_current_level";
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

    public static float finedHypotenuse(int k1, int k2) {
        return (float)Math.sqrt(k1*k1 + k2*k2);
    }


    public static Typeface getTypeFaceLevel() {
        return Typeface.createFromAsset(LevelsActivity.getActivity().getAssets(),"fonts/level_personal.ttf");
    }

    public static Paint getDrawableCube(int id) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if(id == 1) {
            paint.setColor(Color.RED);
        }
        if(id == 2) {
            paint.setColor(Color.GREEN);
        }
        if(id == 3) {
            paint.setColor(Color.MAGENTA);
        }
        if(id == 4) {
            paint.setColor(Color.MAGENTA);
        }
        if(id == 5) {
            paint.setColor(Color.CYAN);
        }
        return paint;
    }
}
