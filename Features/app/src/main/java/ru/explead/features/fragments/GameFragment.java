package ru.explead.features.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

    private RelativeLayout rootGameLayout;

    int start_x, start_y, end_x, end_y;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        rootGameLayout = (RelativeLayout) view.findViewById(R.id.rootGameLayout);

        int size = (int)App.getWidthScreen() - 20;
        App.setSizeSurface(size);
        Controller controller = new Controller();
        App.setController(controller);
        controller.startGame();

        Surface surface = new Surface(getActivity());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(size, size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        surface.setLayoutParams(params);

        rootGameLayout.addView(surface);

        onTouch(view);

        return view;
    }

    public void onTouch(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        start_x = (int)event.getX();
                        start_y = (int)event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        end_x = (int)event.getX();
                        end_y = (int)event.getY();
                        int side1 = (start_x - end_x);
                        int side2 = (start_y - end_y);
                        int hypotenuse = (int) (Math.sqrt(Math.abs(side1*side1) + Math.abs(side2*side2)));
                        double angle = (Math.asin((double) side2/hypotenuse))*57.295f;
                        if (hypotenuse > 50 && ((angle < 30 && angle > -30) || (angle > 60) || (angle < -60))) {
                            if ((side1 <= 0 && side2 >= 0 && angle < 30) || (side1 <= 0 && side2 <= 0 && angle > -30)) {
                                App.getController().onMoveRight();
                            }
                            if ((side1 <= 0 && side2 >= 0 && angle > 60) || (side1 >= 0 && side2 >= 0 && angle > 60 )) {
                                App.getController().onMoveUp();
                            }
                            if ((side1 >= 0 && side2 >= 0 && angle < 30) || (side1 >= 0 && side2 <= 0 && angle > -30)) {
                                App.getController().onMoveLeft();
                            }
                            if ((side1 >= 0 && side2 <= 0 && angle < -60) || (side1 <= 0 && side2 <= 0 && angle < -60)) {
                                App.getController().onMoveDown();
                            }
                        }
                        break;
                    default:
                        break;
                }

                return true;
            }
        });
    }

    public void onWin() {
        Log.d("TAG", "WIN");
        getActivity().onBackPressed();
        Toast.makeText(getActivity(), "WIN", Toast.LENGTH_SHORT).show();
    }

}
