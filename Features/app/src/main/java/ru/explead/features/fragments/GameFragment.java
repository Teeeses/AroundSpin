package ru.explead.features.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import ru.explead.features.R;
import ru.explead.features.Surface;
import ru.explead.features.app.App;
import ru.explead.features.logic.Controller;

/**
 * Created by develop on 15.12.2016.
 */
public class GameFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private Surface viewSurface;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        viewSurface = (Surface) view.findViewById(R.id.viewSurface);

        ViewTreeObserver vto = viewSurface.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                viewSurface.getViewTreeObserver().removeOnPreDrawListener(this);
                int size = (int)App.getWidthScreen() - 20;
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(size, size);
                params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                viewSurface.setLayoutParams(params);

                App.setController(new Controller(size));
                return true;
            }
        });

        return view;
    }


}
