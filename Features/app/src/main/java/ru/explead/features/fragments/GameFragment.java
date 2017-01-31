package ru.explead.features.fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import ru.explead.features.LevelsActivity;
import ru.explead.features.R;
import ru.explead.features.Surface;
import ru.explead.features.app.App;
import ru.explead.features.logic.Controller;

/**
 * Created by develop on 15.12.2016.
 */
public class GameFragment extends Fragment {

    private RelativeLayout rootGameLayout;
    private Button btnRestart;

    int start_x, start_y, end_x, end_y;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        rootGameLayout = (RelativeLayout) view.findViewById(R.id.rootGameLayout);

        int size = (int)App.getWidthScreen() - 30;
        App.setSizeSurface(size);
        startGame();

        Surface surface = new Surface(getActivity());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(size, size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        surface.setLayoutParams(params);

        rootGameLayout.addView(surface);

        btnRestart = (Button) view.findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        onTouch(view);

        return view;
    }

    public void startGame() {
        Controller controller = new Controller();
        App.setController(controller);
        controller.startGame();
    }

    public void onTouch(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                if(App.getController().getStatus() == Controller.ACTIVE_GAME) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            start_x = (int) event.getX();
                            start_y = (int) event.getY();
                            break;
                        case MotionEvent.ACTION_UP:
                            end_x = (int) event.getX();
                            end_y = (int) event.getY();
                            int side1 = (start_x - end_x);
                            int side2 = (start_y - end_y);
                            int hypotenuse = (int) (Math.sqrt(Math.abs(side1 * side1) + Math.abs(side2 * side2)));
                            double angle = (Math.asin((double) side2 / hypotenuse)) * 57.295f;
                            if (hypotenuse > 50 && ((angle < 30 && angle > -30) || (angle > 60) || (angle < -60))) {
                                if ((side1 <= 0 && side2 >= 0 && angle < 30) || (side1 <= 0 && side2 <= 0 && angle > -30)) {
                                    App.getController().onMoveRight();
                                } else if ((side1 <= 0 && side2 >= 0 && angle > 60) || (side1 >= 0 && side2 >= 0 && angle > 60)) {
                                    App.getController().onMoveUp();
                                } else if ((side1 >= 0 && side2 >= 0 && angle < 30) || (side1 >= 0 && side2 <= 0 && angle > -30)) {
                                    App.getController().onMoveLeft();
                                } else if ((side1 >= 0 && side2 <= 0 && angle < -60) || (side1 <= 0 && side2 <= 0 && angle < -60)) {
                                    App.getController().onMoveDown();
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }

                return true;
            }
        });
    }

    public void onWin() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                System.out.println("WIN");
                Toast.makeText(getActivity(), "Победа", Toast.LENGTH_SHORT).show();
                ((LevelsActivity)LevelsActivity.getActivity()).setCurrentEasyLevel(App.getLevel().getLevel() + 1);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
