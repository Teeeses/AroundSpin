package ru.explead.features.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.util.ArrayList;

import ru.explead.features.LevelsActivity;
import ru.explead.features.MainActivity;
import ru.explead.features.R;
import ru.explead.features.app.App;
import ru.explead.features.beans.EndPosition;
import ru.explead.features.logic.Cube;
import ru.explead.features.logic.Field;
import ru.explead.features.logic.Level;

import static android.R.attr.id;

/**
 * Created by Александр on 30.01.2017.
 */

public class TestFragment extends LevelsFragment {


    private int width;

    private LinearLayout layout;
    private int color = R.color.colorPrimary;
    private static int number = 5;

    private Button btnStartTest;


    private ArrayList<Cell> views = new ArrayList<>();

    public static int[][] table;

    public static ArrayList<Cube> cubes = new ArrayList<>();

    private static int id = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment, container, false);


        RelativeLayout rootLayout = (RelativeLayout) view.findViewById(R.id.activity_main);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        width = displaymetrics.widthPixels;

        layout = new LinearLayout(getActivity());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width - 30, width - 30);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.WHITE);

        rootLayout.addView(layout);

        SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                number = progress;
                views.clear();
                layout.removeAllViews();
                cubes.clear();
                createTable();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnStartTest = (Button) view.findViewById(R.id.btnStartTest);
        btnStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.setLevel(new Level(Level.VERY_HARD, 99));

                System.out.println();
                for(int i = 0; i < number; i++) {
                    for(int j = 0; j < number; j++) {
                        System.out.print(table[i][j] + " ");
                    }
                    System.out.println();
                }
                cubes.clear();
                ((LevelsActivity)getActivity()).openNewActivity();
            }
        });

        createTable();
        createView(view);


        return view;
    }

    public void createTable() {
        table = new int[number][number];

        for(int i = 0; i < number; i++) {
            LinearLayout lay = new LinearLayout(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (width - 30)/number);
            lay.setOrientation(LinearLayout.HORIZONTAL);
            lay.setLayoutParams(params);
            for(int j = 0; j < number; j++) {
                table[i][j] = 0;
                View v = new View(getActivity());
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams((width - 30)/number, (width - 30)/number);
                v.setLayoutParams(p);
                lay.addView(v);
                views.add(new Cell(v, i, j));
            }
            layout.addView(lay);
        }

        for(final Cell cell: views) {
            cell.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cell.getView().setBackgroundColor(getResources().getColor(color));
                    table[cell.getX()][cell.getY()] = id;
                }
            });
        }
    }

    public void createView(View view) {
        RelativeLayout viewWhite = (RelativeLayout) view.findViewById(R.id.viewWhite);
        viewWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = android.R.color.white;
                id = 0;
            }
        });

        RelativeLayout view1 = (RelativeLayout) view.findViewById(R.id.view1);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = R.color.red;
                id = 1;
            }
        });

        RelativeLayout view2 = (RelativeLayout) view.findViewById(R.id.view2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = R.color.green;
                id = 2;
            }
        });

        RelativeLayout viewWall = (RelativeLayout) view.findViewById(R.id.viewWall);
        viewWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = R.color.colorPrimary;
                id = 6;
            }
        });
    }

    public static int[][] removeInTableCube() {
        int[][] result = new int[number][number];
        for(int i = 0; i < number; i++) {
            for(int j = 0; j < number; j++) {
                result[i][j] = table[i][j];
                if(table[i][j] > 0 && table[i][j] < 6) {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static ArrayList<Cube> addCunes() {
        for(int i = 0; i < number; i++) {
            for(int j = 0; j < number; j++) {
                if(table[i][j] > 0 && table[i][j] < 6) {
                    if(table[i][j] == 1) {
                        cubes.add(new Cube(i, j, Color.MAGENTA, new EndPosition(j, i)));
                    }
                    if(table[i][j] == 2) {
                        cubes.add(new Cube(i, j, Color.RED, new EndPosition(j, i)));
                    }
                }
            }
        }
        return cubes;
    }


    class Cell {

        private View view;

        private int x;
        private int y;


        public Cell(View view, int x, int y) {
            this.view = view;
            this.x = x;
            this.y = y;
        }

        public View getView() {
            return view;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
