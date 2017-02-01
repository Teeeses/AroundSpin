package ru.explead.features;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import github.chenupt.springindicator.SpringIndicator;
import github.chenupt.springindicator.viewpager.ScrollerViewPager;
import ru.explead.features.Utils.Utils;
import ru.explead.features.app.App;
import ru.explead.features.fragments.BannerFragment;


public class LevelsActivity extends AppCompatActivity  {

    private static Activity activity;
    private static Fragment fragment;
    private ScrollerViewPager viewPager;
    private MyPagerAdapter adapter;

    private static SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        activity = this;
        sPref = getSharedPreferences(Utils.APP_PREFERENCES, MODE_PRIVATE);

        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        App.setWidthScreen(displaymetrics.widthPixels);
        App.setHeightScreen(displaymetrics.heightPixels);


        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.fixScrollSpeed();

        springIndicator.setViewPager(viewPager);
    }

    public void openBannerFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new BannerFragment();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    public void setCurrentEasyLevel(int currentLevel) {
        System.out.println("Сохранение нового текущего уровня");
        if(currentLevel == sPref.getInt(Utils.EASY_CURRENT_LEVEL, 1)) {
            SharedPreferences.Editor editor = sPref.edit();
            editor.putInt(Utils.EASY_CURRENT_LEVEL, currentLevel + 1);
            editor.apply();
        }
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

}
