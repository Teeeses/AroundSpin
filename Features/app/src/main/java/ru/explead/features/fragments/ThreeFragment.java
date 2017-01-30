package ru.explead.features.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import ru.explead.features.R;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 14.12.2016.
 */
public class ThreeFragment  extends LevelsFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_three, container, false);

        gvMain = (GridView) view.findViewById(R.id.gvMain);
        createButtons(8, Level.HARD);

        return view;
    }

}