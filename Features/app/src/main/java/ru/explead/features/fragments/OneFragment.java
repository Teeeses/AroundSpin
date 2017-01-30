package ru.explead.features.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.explead.features.R;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 13.12.2016.
 */
public class OneFragment extends LevelsFragment {

    private LinearLayout layoutVertical;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_one, container, false);

        layoutVertical = (LinearLayout) view.findViewById(R.id.layoutVertical);
        createButtons(getLayoutInflater(getArguments()), layoutVertical, 20, Level.EASY);

        return view;
    }
}