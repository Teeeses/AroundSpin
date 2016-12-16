package ru.explead.features.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import ru.explead.features.R;
import ru.explead.features.Surface;

/**
 * Created by develop on 15.12.2016.
 */
public class GameFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        RelativeLayout rootGameLayout = (RelativeLayout) view.findViewById(R.id.rootGameLayout);
        rootGameLayout.addView(new Surface(getActivity()));

        return view;
    }

}
