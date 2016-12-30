package ru.explead.features;

import android.app.Activity;
import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;

        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        App.setWidthScreen(displaymetrics.widthPixels);
        App.setHeightScreen(displaymetrics.heightPixels);

        App.setController(new Controller());

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
}
