package ru.explead.features.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import ru.explead.features.LevelsActivity;
import ru.explead.features.R;

/**
 * Created by develop on 16.02.2017.
 */

public class UtilsBitmaps {


    private BitmapFactory.Options options;

    private Bitmap bitmapArrow;


    public UtilsBitmaps() {
        options = new BitmapFactory.Options();
        options.inPurgeable = true;

        //bitmapArrow = BitmapFactory.decodeResource(LevelsActivity.getActivity().getResources(), R.drawable.arrow, options);
        //bitmapArrow = Bitmap.createScaledBitmap(bitmapArrow, (int)200, 200,  true);
    }

}
