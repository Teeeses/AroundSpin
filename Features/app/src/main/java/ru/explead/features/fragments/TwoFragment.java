package ru.explead.features.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.explead.features.MainActivity;
import ru.explead.features.R;

/**
 * Created by develop on 14.12.2016.
 */
public class TwoFragment extends LevelsFragment {

    private LinearLayout layoutVertical;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_two, container, false);

        layoutVertical = (LinearLayout) view.findViewById(R.id.layoutVertical);
        createButtons(getLayoutInflater(getArguments()), layoutVertical, 15);

        return view;
    }

}