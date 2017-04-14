package ru.explead.features.fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import ru.explead.features.LevelsActivity;
import ru.explead.features.R;
import ru.explead.features.Surface;
import ru.explead.features.Utils.Utils;
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
    private ImageView btnRestart;
    private ImageView btnHelp;
    private TextView tvNumberLevel;
    private TextView tvLevel;
    private int start_x, start_y, end_x, end_y;
    private long startTouch = 0l, endTouch = 0l;

    private Surface surface;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        rootGameLayout = (RelativeLayout) view.findViewById(R.id.rootGameLayout);
        tvNumberLevel = (TextView) view.findViewById(R.id.tvNumberLevel);
        tvLevel = (TextView) view.findViewById(R.id.tvLevel);
        tvNumberLevel.setTypeface(Utils.getTypeFaceLevel());
        tvLevel.setTypeface(Utils.getTypeFaceLevel());

        createSurface();
        startGame();



        rootGameLayout.addView(surface);

        btnRestart = (ImageView) view.findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        btnHelp = (ImageView) view.findViewById(R.id.btnHelp);
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

    public void createSurface() {
        int size = (int)App.getWidthScreen() - (int)getActivity().getResources().getDimension(R.dimen.big_margin);
        // marginTop = (int)(App.getHeightScreen()*0.75) - (int)(size*0.85);
        App.setSizeSurface(size);

        surface = new Surface(getActivity());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(size, size);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        //params.setMargins(0, marginTop, 0, 0);
        surface.setLayoutParams(params);
    }

    public void createViews() {

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

        tvNumberLevel.setText(String.format("%d", App.getLevel().getLevel()));
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
                            startTouch = System.currentTimeMillis();
                            ((ControllerThree) App.getController()).checkTouchOnCube(start_x, start_y);
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int x = (int) event.getX();
                            int y = (int) event.getY();
                            ((ControllerThree) App.getController()).logicMove(x, y);
                            break;
                        case MotionEvent.ACTION_UP:
                            endTouch = System.currentTimeMillis();
                            if(endTouch - startTouch > 500l && ((ControllerThree) App.getController()).getTouchedCells().size() == 0) {
                                Log.d("TAG", "Long touch");
                                ((ControllerThree) App.getController()).onDeletePath((int) event.getX(), (int) event.getY());
                            }
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
