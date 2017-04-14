package ru.explead.features.Utils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;

import java.util.ArrayList;

import ru.explead.features.LevelsActivity;
import ru.explead.features.MainActivity;
import ru.explead.features.R;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 16.12.2016.
 */
public class Utils {


    public final static String EASY_CURRENT_LEVEL = "easy_current_level";
    public final static String MEDIUM_CURRENT_LEVEL = "medium_current_level";
    public final static String HARD_CURRENT_LEVEL = "hard_current_level";
    public static final String APP_PREFERENCES = "mysettings";

    public static Bitmap blue_cube;
    public static Bitmap red_cube;
    public static Bitmap inside_blue_cube;
    public static Bitmap inside_red_cube;

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

    public static void createCubeBitmap(int size, int complexity) {
        if(complexity == Level.EASY) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
            blue_cube = BitmapFactory.decodeResource(MainActivity.getRes(), R.drawable.icon_blue_cube, options);
            red_cube = BitmapFactory.decodeResource(MainActivity.getRes(), R.drawable.icon_red_cube, options);
            inside_blue_cube = BitmapFactory.decodeResource(MainActivity.getRes(), R.drawable.icon_inside_blue_cube, options);
            inside_red_cube = BitmapFactory.decodeResource(MainActivity.getRes(), R.drawable.icon_inside_red_cube, options);

            blue_cube = Bitmap.createScaledBitmap(blue_cube, size, size, true);
            red_cube = Bitmap.createScaledBitmap(red_cube, size, size, true);
            inside_blue_cube = Bitmap.createScaledBitmap(inside_blue_cube, size, size, true);
            inside_red_cube = Bitmap.createScaledBitmap(inside_red_cube, size, size, true);
        }
    }

    public static Bitmap getDrawableCube(int id) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if(id == 1) {
            //paint.setColor(Color.RED);
            return red_cube;
        }
        if(id == 2) {
            //paint.setColor(Color.GREEN);
            return blue_cube;
        }
        if(id == 3) {
            paint.setColor(Color.MAGENTA);
        }
        if(id == 4) {
            paint.setColor(Color.YELLOW);
        }
        if(id == 5) {
            paint.setColor(Color.CYAN);
        }
        return null;
    }

    public static Bitmap getEndPositionDrawable(int id) {
        if(id == 1) {
            return inside_red_cube;
        }
        if(id == 2) {
            return inside_blue_cube;
        }
        return null;
    }

    public static Paint getPaintCube(int id) {
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
            paint.setColor(Color.YELLOW);
        }
        if(id == 5) {
            paint.setColor(Color.CYAN);
        }
        return null;
    }
}
