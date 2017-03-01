package ru.explead.features.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import ru.explead.features.R;
import ru.explead.features.app.App;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 14.12.2016.
 */
public class TwoFragment extends LevelsFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_two, container, false);

        gvMain = (GridView) view.findViewById(R.id.gvMain);
        createButtons(16, Level.MEDIUM);

        ImageView bottomImage = (ImageView) view.findViewById(R.id.bottomImage);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) App.getWidthScreen(), (int)(App.getWidthScreen()*0.646f));
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottomImage.setLayoutParams(params);

        return view;
    }

}