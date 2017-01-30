package ru.explead.features.fragments;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
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
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import ru.explead.features.LevelsActivity;
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

        Button btnStartTest = (Button) view.findViewById(R.id.btnStartTest);
        btnStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.setLevel(new Level(Level.VERY_HARD, 99));
                cubes.clear();
                ((LevelsActivity)getActivity()).openNewActivity();
            }
        });

        Button btnPhoto = (Button) view.findViewById(R.id.btnPhoto);
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date now = new Date();
                android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

                try {
                    // image naming and path  to include sd card  appending name you choose for file
                    String mPath = Environment.getExternalStorageDirectory() + "/Pictures/Screens/" + now + ".jpg";

                    // create bitmap screen capture
                    View v1 = getActivity().getWindow().getDecorView().getRootView();
                    v1.setDrawingCacheEnabled(true);
                    Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
                    v1.setDrawingCacheEnabled(false);

                    File imageFile = new File(mPath);

                    FileOutputStream outputStream = new FileOutputStream(imageFile);
                    int quality = 100;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
                    outputStream.flush();
                    outputStream.close();
                    Toast.makeText(getActivity(), "Готово", Toast.LENGTH_SHORT).show();

                } catch (Throwable e) {
                    // Several error may come out with file handling or OOM
                    Toast.makeText(getActivity(), "Не получилось", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
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

    public static ArrayList<Cube> addCubes() {
        int xr = 0, yr = 0, xg = 0, yg = 0;
        for(int i = 0; i < number; i++) {
            for(int j = 0; j < number; j++) {
                if(table[i][j] > 0 && table[i][j] < 6) {
                    if(table[i][j] == 1) {
                        xr = i;
                        yr = j;
                    }
                    if(table[i][j] == 2) {
                        xg = i;
                        yg = j;
                    }
                }
            }
        }
        cubes.add(new Cube(xr, yr, Color.RED, new EndPosition(xg, yg, Color.RED)));
        cubes.add(new Cube(xg, yg, Color.GREEN, new EndPosition(xr, yr, Color.GREEN)));

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