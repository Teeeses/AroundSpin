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
import android.widget.TextView;
import android.widget.Toast;


import ru.explead.features.LevelsActivity;
import ru.explead.features.R;
import ru.explead.features.Surface;
import ru.explead.features.app.App;
import ru.explead.features.dialog.DialogMenu;
import ru.explead.features.logic.ControllerOne;
import ru.explead.features.logic.ControllerThree;
import ru.explead.features.logic.ControllerTwo;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 15.12.2016.
 */
public class GameFragment extends Fragment {

    private RelativeLayout rootGameLayout;
    private Button btnRestart;
    private Button btnHelp;
    private TextView tvLevel;
    private int start_x, start_y, end_x, end_y;

    private Surface surface;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        rootGameLayout = (RelativeLayout) view.findViewById(R.id.rootGameLayout);
        tvLevel = (TextView) view.findViewById(R.id.tvLevel);

        int size = (int)App.getWidthScreen() - 30;
        App.setSizeSurface(size);
        startGame();

        surface = new Surface(getActivity());
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

        btnHelp = (Button) view.findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHelp();
            }
        });

        if(Level.EASY == App.getLevel().getComplexity()) {
            onTouchOne(view);
        } else if(Level.MEDIUM == App.getLevel().getComplexity()) {
            onTouchTwo(surface);
        } else if(Level.HARD == App.getLevel().getComplexity()) {
            onTouchThree(surface);
        }

        return view;
    }

    public void startGame() {
        if(App.getLevel().getComplexity() == Level.EASY) {
            ControllerOne controller = new ControllerOne();
            App.setController(controller);
            controller.startGame();
        } else if(App.getLevel().getComplexity() == Level.MEDIUM) {
            ControllerTwo controller = new ControllerTwo();
            App.setController(controller);
            controller.startGame();
        }
        else if(App.getLevel().getComplexity() == Level.HARD) {
            ControllerThree controller = new ControllerThree();
            App.setController(controller);
            controller.startGame();
        }

        tvLevel.setText(String.format("Уровень %d", App.getLevel().getLevel()));
    }

    public void onHelp() {

    }

    public void onTouchThree(Surface surface) {
        surface.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(App.getController().getStatus() == ControllerOne.ACTIVE_GAME) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            start_x = (int) event.getX();
                            start_y = (int) event.getY();
                            ((ControllerThree) App.getController()).checkTouchOnCube(start_x, start_y);
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x = (int) event.getX();
                            int y = (int) event.getY();
                            ((ControllerThree) App.getController()).logicMove(x, y);
                            break;
                        case MotionEvent.ACTION_UP:
                            ((ControllerThree) App.getController()).onUpFinger();
                            break;
                        default:
                            break;
                    }
                }

                return true;
            }
        });
    }

    public void onTouchTwo(Surface surface) {
        surface.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(App.getController().getStatus() == ControllerOne.ACTIVE_GAME) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            start_x = (int) event.getX();
                            start_y = (int) event.getY();
                            break;
                        case MotionEvent.ACTION_UP:
                            end_x = (int) event.getX();
                            end_y = (int) event.getY();
                            ((ControllerTwo) App.getController()).logicMove(start_x, start_y, end_x, end_y);
                            break;
                        default:
                            break;
                    }
                }

                return true;
            }
        });
    }

    public void onTouchOne(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                if(App.getController().getStatus() == ControllerOne.ACTIVE_GAME) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            start_x = (int) event.getX();
                            start_y = (int) event.getY();
                            break;
                        case MotionEvent.ACTION_UP:
                            end_x = (int) event.getX();
                            end_y = (int) event.getY();
                            ((ControllerOne) App.getController()).logicMove(start_x, start_y, end_x, end_y);
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
                ((LevelsActivity)LevelsActivity.getActivity()).setCurrentEasyLevel(App.getLevel().getLevel());
                DialogMenu dialog = new DialogMenu(getActivity());
                dialog.show();
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
