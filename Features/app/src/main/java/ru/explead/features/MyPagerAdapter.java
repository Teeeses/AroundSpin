package ru.explead.features;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.explead.features.fragments.FourFragment;
import ru.explead.features.fragments.OneFragment;
import ru.explead.features.fragments.ThreeFragment;
import ru.explead.features.fragments.TwoFragment;

/**
 * Created by develop on 13.12.2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 4;
    private Fragment fragment;

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
        switch (position) {
            case 0:
                fragment = new OneFragment();
                return fragment;

            case 1:
                fragment = new TwoFragment();
                return fragment;

            case 2:
                fragment = new ThreeFragment();
                return fragment;

            case 3:
                fragment = new FourFragment();
                return fragment;

            default:
                return fragment = new OneFragment();
        }


    }

}