package ru.explead.features;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import ru.explead.features.app.App;
import ru.explead.features.fragments.GameFragment;


/**
 * Created by develop on 15.12.2016.
 */
public class MainActivity extends AppCompatActivity {


    private static Activity activity;
    private static Fragment fragment;
    private static Resources res;



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
        Log.d("TIME", "Open Game Fragment: " + Long.toString(System.currentTimeMillis() - App.getTestTime()));
        App.setTestTime(System.currentTimeMillis());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new GameFragment();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
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

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
