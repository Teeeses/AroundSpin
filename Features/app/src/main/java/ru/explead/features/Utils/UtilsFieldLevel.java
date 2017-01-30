package ru.explead.features.Utils;


import android.graphics.Color;

import java.util.ArrayList;

import ru.explead.features.app.App;
import ru.explead.features.beans.EndPosition;
import ru.explead.features.fragments.TestFragment;
import ru.explead.features.logic.Cube;
import ru.explead.features.logic.Field;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 20.01.2017.
 */

public class UtilsFieldLevel {


    public static void getDataLevel(int level, int complexity) {
        if(complexity == Level.EASY) {
            getLevelFromEasy(level);
        }
        if(complexity == Level.MEDIUM) {
            getLevelFromMedium(level);
        }
        if(complexity == Level.HARD) {
            getLevelFromHard(level);
        }
        if(complexity == Level.VERY_HARD) {
            getLevelFromVeryHard(level);
        }
    }

    private static void getLevelFromEasy(int level) {
        if(level == 1) {
            System.out.println("UTILS GAME LEVEL 1");
            int[][] mass = new int[][] {
                    {0, 0, 0, 0},
                    {6, 0, 6, 0},
                    {0, 0, 0, 0},
                    {6, 0, 6, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, Color.RED, new EndPosition(3, 1, Color.RED)));
            cubeList.add(new Cube(3, 1, Color.GREEN, new EndPosition(0, 0, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 2) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {6, 0, 6, 0, 0},
                    {0, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 6, 6, 6}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 0, Color.RED, new EndPosition(4, 1, Color.RED)));
            cubeList.add(new Cube(4, 1, Color.GREEN, new EndPosition(4, 0, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 3) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0},
                    {6, 6, 0, 6, 0},
                    {6, 6, 0, 6, 0},
                    {6, 0, 0, 6, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 4, Color.RED, new EndPosition(4, 1, Color.RED)));
            cubeList.add(new Cube(4, 1, Color.GREEN, new EndPosition(4, 4, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 4) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 0},
                    {6, 6, 0, 6, 6},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 4, Color.RED, new EndPosition(4, 4, Color.RED)));
            cubeList.add(new Cube(4, 4, Color.GREEN, new EndPosition(1, 4, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 5) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0},
                    {6, 6, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 6, 0},
                    {6, 6, 0, 0, 0, 0},
                    {6, 6, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(5, 2, Color.RED, new EndPosition(4, 2, Color.RED)));
            cubeList.add(new Cube(4, 2, Color.GREEN, new EndPosition(5, 2, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 6) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0},
                    {0, 0, 6, 0},
                    {6, 0, 6, 0},
                    {6, 0, 0, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 0, Color.RED, new EndPosition(3, 3, Color.RED)));
            cubeList.add(new Cube(3, 3, Color.GREEN, new EndPosition(1, 0, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 7) {
            int[][] mass = new int[][] {
                    {6, 6, 6, 0, 0, 0, 0},
                    {6, 6, 6, 0, 6, 6, 0},
                    {0, 0, 6, 0, 6, 6, 0},
                    {6, 0, 6, 6, 6, 6, 0},
                    {0, 0, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 6, 6},
                    {6, 6, 6, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(2, 0, Color.RED, new EndPosition(2, 3, Color.RED)));
            cubeList.add(new Cube(2, 3, Color.GREEN, new EndPosition(2, 0, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 8) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {6, 0, 6, 6, 0},
                    {0, 0, 6, 0, 0},
                    {0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, Color.RED, new EndPosition(2, 3, Color.RED)));
            cubeList.add(new Cube(2, 3, Color.GREEN, new EndPosition(0, 0, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 9) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 0, 6},
                    {0, 6, 0, 6, 0, 0},
                    {0, 0, 0, 6, 6, 0},
                    {0, 0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(2, 4, Color.RED, new EndPosition(2, 2, Color.RED)));
            cubeList.add(new Cube(2, 2, Color.GREEN, new EndPosition(2, 4, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 10) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 6, 6, 6},
                    {0, 0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 6, 0, 6},
                    {0, 0, 0, 0, 0, 0},
                    {6, 0, 0, 6, 0, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 5, Color.RED, new EndPosition(0, 2, Color.RED)));
            cubeList.add(new Cube(0, 2, Color.GREEN, new EndPosition(1, 5, Color.GREEN)));
            App.getController().setCube(cubeList);
        }

        if(level == 11) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 6, 6, 6},
                    {0, 6, 0, 0, 6, 0, 0},
                    {0, 6, 0, 0, 6, 0, 6},
                    {0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 0, 6, 6, 6},
                    {6, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 6, Color.RED, new EndPosition(6, 6, Color.RED)));
            cubeList.add(new Cube(6, 6, Color.GREEN, new EndPosition(1, 6, Color.GREEN)));
            App.getController().setCube(cubeList);
        }
    }



    private static void getLevelFromMedium(int level) {

    }



    private static void getLevelFromHard(int level) {

    }



    private static void getLevelFromVeryHard(int level) {

        if(level == 99) {
            Field field = new Field(TestFragment.removeInTableCube());
            App.getController().setField(field);
            App.getController().setCube(TestFragment.addCubes());

        }
    }
}
