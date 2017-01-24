package ru.explead.features;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import ru.explead.features.app.App;
import ru.explead.features.fragments.BannerFragment;
import ru.explead.features.fragments.GameFragment;
import ru.explead.features.logic.Controller;


/**
 * Created by develop on 15.12.2016.
 */
public class MainActivity extends AppCompatActivity {


    private static Activity activity;
    private static Fragment fragment;
    private static Resources res;

    int start_x, start_y, end_x, end_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        res = getResources();

        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        App.setWidthScreen(displaymetrics.widthPixels);
        App.setHeightScreen(displaymetrics.heightPixels);

        openGameFragment();
    }

    public void openGameFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new GameFragment();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                start_x = (int)event.getX();
                start_y = (int)event.getY();
                break;
            case MotionEvent.ACTION_UP:
                end_x = (int)event.getX();
                end_y = (int)event.getY();
                int side1 = (start_x - end_x);
                int side2 = (start_y - end_y);
                int hypotenuse = (int) (Math.sqrt(Math.abs(side1*side1) + Math.abs(side2*side2)));
                double angle = (Math.asin((double) side2/hypotenuse))*57.295f;
                if (hypotenuse > 30 && ((angle < 30 && angle > -30) || (angle > 60) || (angle < -60))) {
                    //TODO
                }
                break;
            default:
                break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    public static Activity getActivity() {
        return activity;
    }

    public static Fragment getFragment() {
        return fragment;
    }

    public static Resources getRes() {
        return res;
    }
}
