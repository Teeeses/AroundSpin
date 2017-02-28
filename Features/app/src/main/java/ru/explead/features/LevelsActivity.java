package ru.explead.features;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import github.chenupt.springindicator.SpringIndicator;
import github.chenupt.springindicator.viewpager.ScrollerViewPager;
import ru.explead.features.Utils.Utils;
import ru.explead.features.Utils.UtilsBitmaps;
import ru.explead.features.adapters.MyPagerAdapter;
import ru.explead.features.app.App;
import ru.explead.features.fragments.BannerFragment;


public class LevelsActivity extends AppCompatActivity  {

    private static Activity activity;
    private static Fragment fragment;
    private ViewPager viewPager;
    private MyPagerAdapter adapter;

    private static SharedPreferences sPref;
    private static Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        activity = this;
        res = this.getResources();
        sPref = getSharedPreferences(Utils.APP_PREFERENCES, MODE_PRIVATE);

        UtilsBitmaps bitmaps = new UtilsBitmaps();
        App.setBitmaps(bitmaps);

        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        App.setWidthScreen(displaymetrics.widthPixels);
        App.setHeightScreen(displaymetrics.heightPixels);



        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
        //SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //viewPager.fixScrollSpeed();

        //springIndicator.setViewPager(viewPager);
    }

    public void openBannerFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new BannerFragment();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    public void setCurrentEasyLevel(int currentLevel) {
        System.out.println("Сохранение нового текущего уровня");
        SharedPreferences.Editor editor = sPref.edit();
        if(currentLevel == sPref.getInt(Utils.EASY_CURRENT_LEVEL, 1)) {
            editor.putInt(Utils.EASY_CURRENT_LEVEL, currentLevel + 1);
        }
        if(currentLevel == sPref.getInt(Utils.MEDIUM_CURRENT_LEVEL, 1)) {
            editor.putInt(Utils.MEDIUM_CURRENT_LEVEL, currentLevel + 1);
        }
        if(currentLevel == sPref.getInt(Utils.HARD_CURRENT_LEVEL, 1)) {
            editor.putInt(Utils.HARD_CURRENT_LEVEL, currentLevel + 1);
        }
        editor.apply();
    }

    public static SharedPreferences getPref() {
        return sPref;
    }

    public static Activity getActivity() {
        return activity;
    }

    public void openNewActivity() {
        Intent intent = new Intent(LevelsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public static Resources getRes() {
        return res;
    }
}
