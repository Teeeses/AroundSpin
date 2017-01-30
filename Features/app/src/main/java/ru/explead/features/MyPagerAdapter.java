package ru.explead.features;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import ru.explead.features.fragments.FourFragment;
import ru.explead.features.fragments.LevelsFragment;
import ru.explead.features.fragments.OneFragment;
import ru.explead.features.fragments.TestFragment;
import ru.explead.features.fragments.ThreeFragment;
import ru.explead.features.fragments.TwoFragment;

/**
 * Created by develop on 13.12.2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 5;
    private Fragment[] fragments = {new OneFragment(), new TwoFragment(), new ThreeFragment(), new FourFragment(), new TestFragment()};

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    public String getPageTitle(int position) {
        return Integer.toString(position + 1);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    public void update() {
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                Fragment fragment = getItem(i);
                ((OneFragment) fragment).update();
            }
        }
    }
}