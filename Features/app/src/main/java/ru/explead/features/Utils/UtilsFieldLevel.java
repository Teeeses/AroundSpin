package ru.explead.features.Utils;


import java.util.ArrayList;

import ru.explead.features.app.App;
import ru.explead.features.beans.EndPosition;
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
    }

    private static void getLevelFromEasy(int level) {
        int complexity = Level.EASY;
        if(level == 1) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {6, 0, 6, 6, 6},
                    {6, 0, 6, 0, 0},
                    {0, 0, 6, 6, 0},
                    {0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(2, 3), 1));
            cubeList.add(new Cube(2, 3, new EndPosition(0, 0), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 0, new EndPosition(4, 1), 1));
            cubeList.add(new Cube(4, 1, new EndPosition(4, 0), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 4, new EndPosition(4, 1), 1));
            cubeList.add(new Cube(4, 1, new EndPosition(4, 4), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 4, new EndPosition(4, 4), 1));
            cubeList.add(new Cube(4, 4, new EndPosition(1, 4), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(5, 2, new EndPosition(4, 2), 1));
            cubeList.add(new Cube(4, 2, new EndPosition(5, 2), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 6) {
            int[][] mass = new int[][] {
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 0, 0},
                    {0, 0, 0, 0, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(0, 4), 1));
            cubeList.add(new Cube(0, 4, new EndPosition(0, 0), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(2, 0, new EndPosition(2, 3), 1));
            cubeList.add(new Cube(2, 3, new EndPosition(2, 0), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(2, 3), 1));
            cubeList.add(new Cube(2, 3, new EndPosition(0, 0), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(2, 4, new EndPosition(2, 2), 1));
            cubeList.add(new Cube(2, 2, new EndPosition(2, 4), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 5, new EndPosition(0, 2), 1));
            cubeList.add(new Cube(0, 2, new EndPosition(1, 5), 2));
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
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 6, new EndPosition(6, 6), 1));
            cubeList.add(new Cube(6, 6, new EndPosition(1, 6), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 12) {
            int[][] mass = new int[][] {
                    {0, 0, 6, 6, 6, 6},
                    {6, 0, 0, 0, 6, 6},
                    {0, 0, 6, 0, 0, 0},
                    {0, 6, 6, 6, 6, 0},
                    {0, 0, 6, 0, 0, 0},
                    {6, 0, 0, 0, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(2, 3), 1));
            cubeList.add(new Cube(2, 3, new EndPosition(0, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 13) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 6},
                    {0, 6, 0, 6, 0},
                    {0, 0, 0, 0, 0},
                    {6, 6, 0, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 4, new EndPosition(4, 2), 1));
            cubeList.add(new Cube(4, 2, new EndPosition(0, 4), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 14) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 6, 0, 0},
                    {0, 6, 0, 6, 6, 0},
                    {0, 6, 0, 6, 0, 0},
                    {0, 6, 0, 6, 0, 6},
                    {0, 0, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 4, new EndPosition(5, 0), 1));
            cubeList.add(new Cube(5, 0, new EndPosition(0, 4), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 15) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 6},
                    {6, 6, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {6, 6, 0, 6, 0},
                    {6, 0, 0, 6, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(2, 0, new EndPosition(4, 4), 1));
            cubeList.add(new Cube(4, 4, new EndPosition(2, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 16) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 6, 6, 6, 6, 0},
                    {0, 6, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 6, 6, 6, 6, 6, 6},
                    {0, 6, 0, 6, 0, 0, 0, 6, 0},
                    {0, 6, 0, 6, 0, 0, 6, 6, 0},
                    {0, 6, 0, 0, 0, 0, 0, 6, 0},
                    {0, 6, 6, 6, 6, 6, 6, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(4, 8), 1));
            cubeList.add(new Cube(4, 8, new EndPosition(0, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 17) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 6, 0, 0, 0, 0, 0},
                    {0, 6, 0, 6, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 0, 0, 0, 0, 0},
                    {0, 6, 6, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 6, 0},
                    {0, 0, 0, 0, 0, 0, 6, 6, 0},
                    {6, 0, 6, 6, 6, 6, 6, 0, 0},
                    {6, 0, 0, 0, 6, 0, 0, 0, 6},
                    {6, 6, 6, 0, 0, 0, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 2, new EndPosition(5, 5), 1));
            cubeList.add(new Cube(5, 5, new EndPosition(1, 2), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 18) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 6, 0, 0, 0},
                    {0, 0, 0, 0, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(0, 4), 1));
            cubeList.add(new Cube(0, 4, new EndPosition(0, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 19) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 6, 6, 6, 6},
                    {0, 6, 6, 0, 0, 0, 0, 0},
                    {0, 0, 6, 0, 0, 6, 0, 0},
                    {6, 0, 6, 0, 6, 6, 6, 0},
                    {6, 0, 0, 0, 6, 0, 0, 0},
                    {6, 6, 6, 0, 6, 0, 6, 6},
                    {6, 6, 0, 0, 6, 0, 0, 6},
                    {6, 6, 0, 6, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(7, 2, new EndPosition(6, 6), 1));
            cubeList.add(new Cube(6, 6, new EndPosition(7, 2), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 20) {
            int[][] mass = new int[][] {
                    {6, 6, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 6, 6, 6},
                    {0, 0, 6, 0, 6, 0, 6, 0, 0},
                    {0, 0, 6, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 6, 6, 0, 0, 0, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(7, 3, new EndPosition(3, 8), 1));
            cubeList.add(new Cube(3, 8, new EndPosition(7, 3), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 21) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 6, 0, 6, 0, 0},
                    {6, 6, 0, 6, 0, 6, 0, 0},
                    {0, 0, 0, 6, 0, 6, 0, 0},
                    {0, 6, 6, 6, 0, 6, 0, 0},
                    {0, 6, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 6, 6, 6},
                    {6, 6, 6, 0, 0, 0, 0, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 0, new EndPosition(7, 6), 1));
            cubeList.add(new Cube(7, 6, new EndPosition(1, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 22) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 6, 6, 6, 6, 6},
                    {0, 0, 0, 0, 0, 0, 0, 0, 6},
                    {0, 6, 0, 6, 6, 6, 6, 0, 6},
                    {0, 6, 0, 6, 6, 6, 6, 0, 6},
                    {0, 6, 0, 6, 6, 6, 6, 0, 6},
                    {0, 6, 0, 0, 0, 0, 0, 0, 6},
                    {0, 6, 6, 0, 0, 0, 6, 6, 6},
                    {0, 0, 0, 0, 0, 0, 0, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 8, new EndPosition(8, 6), 1));
            cubeList.add(new Cube(8, 6, new EndPosition(0, 8), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 23) {
            int[][] mass = new int[][] {
                    {0, 0, 6, 6, 6, 6},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 6, 0},
                    {0, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 1, new EndPosition(1, 5), 1));
            cubeList.add(new Cube(1, 5, new EndPosition(0, 1), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 24) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {6, 6, 0, 6, 0},
                    {0, 6, 0, 6, 0},
                    {0, 0, 0, 0, 0},
                    {6, 6, 6, 6, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(4, 4), 1));
            cubeList.add(new Cube(4, 4, new EndPosition(0, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 25) {
            int[][] mass = new int[][] {
                    {6, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 0, 6, 0, 0},
                    {6, 6, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 6, 0},
                    {0, 6, 0, 0, 6, 6, 0},
                    {0, 6, 0, 6, 6, 0, 0},
                    {0, 0, 0, 6, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 0, new EndPosition(6, 4), 1));
            cubeList.add(new Cube(6, 4, new EndPosition(1, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 26) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0},
                    {6, 0, 0, 0, 6, 0, 0},
                    {0, 0, 0, 0, 6, 0, 6},
                    {0, 6, 6, 6, 6, 0, 6},
                    {0, 0, 0, 0, 0, 0, 0},
                    {6, 6, 6, 6, 6, 6, 0},
                    {6, 6, 6, 6, 6, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(6, 5), 1));
            cubeList.add(new Cube(6, 5, new EndPosition(0, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 27) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 6, 0, 0, 0},
                    {0, 6, 0, 6, 6, 6, 0},
                    {6, 6, 0, 0, 0, 6, 0},
                    {0, 0, 0, 6, 0, 0, 0},
                    {0, 6, 0, 0, 0, 6, 0},
                    {0, 6, 6, 6, 6, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 0, new EndPosition(0, 4), 1));
            cubeList.add(new Cube(0, 4, new EndPosition(1, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 28) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 0, 6, 6, 0},
                    {6, 0, 0, 6, 0, 6, 6, 0},
                    {0, 0, 6, 6, 0, 6, 6, 0},
                    {0, 0, 0, 0, 0, 6, 6, 0},
                    {0, 6, 0, 6, 0, 6, 6, 0},
                    {0, 6, 0, 6, 0, 6, 6, 0},
                    {0, 6, 0, 0, 0, 6, 6, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(7, 7, new EndPosition(7, 4), 1));
            cubeList.add(new Cube(7, 4, new EndPosition(7, 7), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 29) {
            int[][] mass = new int[][] {
                    {6, 0, 0, 0, 0, 0, 6},
                    {6, 0, 0, 0, 0, 6, 6},
                    {6, 0, 6, 0, 0, 0, 6},
                    {0, 0, 6, 0, 6, 0, 6},
                    {0, 0, 6, 0, 6, 0, 0},
                    {0, 6, 6, 0, 6, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 1, new EndPosition(0, 5), 1));
            cubeList.add(new Cube(0, 5, new EndPosition(4, 1), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 30) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 6, 6},
                    {0, 6, 6, 6, 0, 0, 0},
                    {0, 0, 6, 0, 0, 0, 0},
                    {6, 6, 6, 0, 0, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 0, 6, 0},
                    {0, 6, 6, 0, 6, 6, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(6, 0, new EndPosition(6, 6), 1));
            cubeList.add(new Cube(6, 6, new EndPosition(6, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 31) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 6, 6},
                    {6, 0, 0, 0, 0, 0},
                    {6, 6, 0, 0, 0, 6},
                    {0, 0, 0, 6, 0, 0},
                    {0, 6, 0, 6, 6, 0},
                    {0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(3, 4), 1));
            cubeList.add(new Cube(3, 4, new EndPosition(0, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 32) {
            int[][] mass = new int[][] {
                    {6, 6, 6, 6, 0, 6, 6},
                    {6, 0, 0, 0, 0, 6, 6},
                    {6, 0, 0, 0, 0, 0, 6},
                    {6, 6, 0, 0, 0, 0, 6},
                    {6, 0, 0, 0, 6, 0, 6},
                    {6, 6, 6, 0, 6, 6, 6},
                    {6, 6, 6, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 1, new EndPosition(4, 5), 1));
            cubeList.add(new Cube(4, 5, new EndPosition(4, 1), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 33) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 6, 0, 6},
                    {0, 6, 6, 6, 0, 6},
                    {0, 0, 0, 6, 0, 6},
                    {6, 6, 0, 0, 0, 0},
                    {6, 0, 0, 6, 6, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(3, 0, new EndPosition(5, 5), 1));
            cubeList.add(new Cube(5, 5, new EndPosition(3, 0), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 34) {
            int[][] mass = new int[][] {
                    {6, 0, 0, 0, 0, 0, 0, 0, 6},
                    {6, 0, 6, 6, 6, 6, 6, 0, 6},
                    {6, 0, 6, 0, 0, 0, 6, 0, 6},
                    {0, 0, 6, 6, 0, 0, 6, 0, 0},
                    {0, 0, 0, 6, 6, 0, 6, 6, 0},
                    {6, 6, 0, 6, 6, 0, 0, 0, 0},
                    {6, 6, 0, 6, 6, 6, 0, 0, 6},
                    {6, 0, 0, 0, 0, 6, 0, 0, 6},
                    {6, 6, 6, 6, 0, 0, 0, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(2, 3, new EndPosition(3, 7), 1));
            cubeList.add(new Cube(3, 7, new EndPosition(2, 3), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 35) {
            int[][] mass = new int[][] {
                    {0, 0, 6, 0, 0, 0, 6, 6},
                    {0, 0, 0, 0, 0, 6, 6, 6},
                    {0, 6, 0, 0, 0, 0, 0, 6},
                    {0, 0, 0, 0, 0, 0, 0, 6},
                    {6, 0, 0, 0, 0, 0, 0, 6},
                    {6, 0, 0, 6, 0, 0, 0, 6},
                    {6, 0, 0, 6, 0, 6, 0, 6},
                    {6, 6, 6, 6, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(6, 4, new EndPosition(6, 6), 1));
            cubeList.add(new Cube(6, 6, new EndPosition(6, 4), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 36) {
            int[][] mass = new int[][] {
                    {6, 6, 6, 0, 0, 0, 6, 6, 6},
                    {6, 0, 0, 0, 0, 0, 0, 6, 6},
                    {6, 0, 0, 0, 6, 0, 0, 0, 6},
                    {6, 0, 0, 0, 0, 0, 0, 0, 6},
                    {0, 0, 6, 6, 6, 6, 0, 0, 6},
                    {0, 6, 6, 6, 0, 0, 0, 0, 6},
                    {0, 0, 0, 6, 0, 6, 6, 0, 6},
                    {6, 0, 0, 0, 0, 0, 6, 0, 6},
                    {6, 6, 6, 6, 6, 0, 0, 0, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(3, 3, new EndPosition(7, 1), 1));
            cubeList.add(new Cube(7, 1, new EndPosition(3, 3), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 37) {
            int[][] mass = new int[][] {
                    {6, 6, 6, 6, 6, 6, 6, 6, 6},
                    {6, 0, 0, 0, 0, 0, 0, 0, 6},
                    {6, 0, 0, 0, 0, 0, 0, 0, 0},
                    {6, 0, 0, 0, 0, 0, 0, 6, 6},
                    {6, 0, 0, 0, 0, 0, 0, 0, 6},
                    {6, 6, 0, 0, 0, 0, 0, 0, 6},
                    {6, 0, 0, 0, 0, 0, 0, 0, 0},
                    {6, 0, 0, 6, 0, 0, 0, 0, 6},
                    {6, 6, 6, 6, 6, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(2, 8, new EndPosition(6, 8), 1));
            cubeList.add(new Cube(6, 8, new EndPosition(2, 8), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 38) {
            int[][] mass = new int[][] {
                    {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
                    {6, 6, 6, 0, 0, 0, 6, 6, 6, 6},
                    {6, 0, 0, 0, 0, 0, 0, 0, 0, 6},
                    {6, 0, 0, 6, 0, 0, 0, 0, 0, 6},
                    {6, 0, 0, 6, 0, 0, 0, 0, 6, 6},
                    {6, 6, 0, 0, 0, 6, 0, 0, 6, 6},
                    {6, 0, 0, 0, 6, 6, 0, 0, 0, 6},
                    {6, 0, 0, 0, 0, 0, 0, 6, 6, 6},
                    {6, 6, 0, 0, 0, 6, 6, 6, 6, 6},
                    {6, 6, 6, 6, 6, 6, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(8, 4, new EndPosition(6, 8), 1));
            cubeList.add(new Cube(6, 8, new EndPosition(8, 4), 2));
            App.getController().setCube(cubeList);
        }
    }


    private static void getLevelFromMedium(int level) {
        int complexity = Level.MEDIUM;
        if(level == 1) {
            int[][] mass = new int[][] {
                    {6, 6, 0, 0, 6, 6},
                    {6, 6, 0, 0, 6, 6},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {6, 6, 0, 0, 6, 6},
                    {6, 6, 0, 0, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 2, new EndPosition(3, 0), 1));
            cubeList.add(new Cube(5, 3, new EndPosition(2, 5), 2));
            App.getController().setCube(cubeList);
        }

        if(level == 2) {
            int[][] mass = new int[][] {
                    {6, 6, 6, 6, 6, 6, 6, 6},
                    {6, 0, 6, 0, 0, 0, 6, 6},
                    {6, 0, 0, 0, 6, 0, 0, 6},
                    {6, 0, 6, 0, 6, 6, 0, 6},
                    {6, 0, 6, 0, 3, 0, 0, 6},
                    {6, 0, 0, 0, 6, 0, 0, 6},
                    {6, 0, 6, 0, 6, 0, 0, 6},
                    {6, 6, 6, 6, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(5, 2, new EndPosition(4, 4), 1));
            cubeList.add(new Cube(4, 4, new EndPosition(5, 2), 2));
            App.getController().setCube(cubeList);
        }
    }

    private static void getLevelFromHard(int level) {
        int complexity = Level.HARD;
        if(level == 1) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 6},
                    {0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(0, 0, new EndPosition(1, 4), 1));
            cubeList.add(new Cube(2, 2, new EndPosition(4, 4), 2));
            cubeList.add(new Cube(1, 3, new EndPosition(3, 4), 3));
            App.getController().setCube(cubeList);
        }
        if(level == 2) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 6, 0},
                    {0, 0, 6, 0, 0, 0},
                    {6, 0, 0, 0, 0, 6},
                    {6, 0, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(5, 0, new EndPosition(4, 4), 1));
            cubeList.add(new Cube(1, 1, new EndPosition(3, 2), 2));
            cubeList.add(new Cube(4, 2, new EndPosition(4, 5), 3));
            App.getController().setCube(cubeList);
        }

        if(level == 3) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 3, new EndPosition(1, 4), 1));
            cubeList.add(new Cube(2, 5, new EndPosition(3, 2), 2));
            cubeList.add(new Cube(4, 2, new EndPosition(4, 5), 3));
            cubeList.add(new Cube(0, 2, new EndPosition(4, 4), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 4) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 6, 6, 0, 0, 0},
                    {0, 6, 0, 0, 0, 0, 6, 0},
                    {0, 6, 6, 0, 0, 0, 0, 0},
                    {0, 6, 6, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 0, 0, 0, 0},
                    {0, 0, 0, 6, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(6, 0, new EndPosition(5, 6), 1));
            cubeList.add(new Cube(6, 1, new EndPosition(2, 4), 2));
            cubeList.add(new Cube(4, 1, new EndPosition(2, 6), 3));
            cubeList.add(new Cube(2, 3, new EndPosition(6, 4), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 5) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 6, 6, 6, 6, 6},
                    {0, 0, 0, 0, 0, 0, 0, 6},
                    {0, 0, 6, 6, 6, 0, 6, 6},
                    {0, 0, 0, 0, 0, 0, 6, 6},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 6, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 6, 6, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(3, 2, new EndPosition(2, 5), 1));
            cubeList.add(new Cube(5, 6, new EndPosition(1, 1), 2));
            cubeList.add(new Cube(5, 1, new EndPosition(1, 6), 3));
            cubeList.add(new Cube(4, 3, new EndPosition(6, 0), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 6) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 6},
                    {0, 0, 0, 0, 0, 0, 0, 6},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 6, 6, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 6, 6, 6, 0},
                    {0, 6, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 1, new EndPosition(6, 6), 1));
            cubeList.add(new Cube(4, 0, new EndPosition(2, 7), 2));
            cubeList.add(new Cube(5, 1, new EndPosition(1, 5), 3));
            cubeList.add(new Cube(0, 3, new EndPosition(4, 6), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 7) {
            int[][] mass = new int[][] {
                    {6, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 6, 0, 0, 6, 0},
                    {0, 6, 6, 0, 0, 6, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 6, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(3, 1, new EndPosition(0, 4), 1));
            cubeList.add(new Cube(5, 2, new EndPosition(1, 5), 2));
            cubeList.add(new Cube(5, 0, new EndPosition(4, 5), 3));
            cubeList.add(new Cube(0, 3, new EndPosition(6, 5), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 8) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 6, 6},
                    {0, 0, 6, 6, 0, 0, 6, 6},
                    {0, 0, 6, 6, 0, 0, 0, 6},
                    {6, 0, 0, 0, 0, 0, 0, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 3, new EndPosition(7, 6), 1));
            cubeList.add(new Cube(6, 6, new EndPosition(3, 4), 2));
            cubeList.add(new Cube(2, 1, new EndPosition(0, 7), 3));
            cubeList.add(new Cube(5, 5, new EndPosition(2, 2), 4));
            cubeList.add(new Cube(6, 0, new EndPosition(2, 6), 5));
            App.getController().setCube(cubeList);
        }

        if(level == 9) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 6},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 7, new EndPosition(1, 5), 1));
            cubeList.add(new Cube(4, 4, new EndPosition(1, 6), 2));
            cubeList.add(new Cube(6, 1, new EndPosition(0, 7), 3));
            cubeList.add(new Cube(3, 3, new EndPosition(5, 4), 4));
            cubeList.add(new Cube(0, 1, new EndPosition(4, 6), 5));
            App.getController().setCube(cubeList);
        }

        if(level == 10) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 6, 6},
                    {0, 0, 0, 0, 0, 0, 6, 6}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(7, 2, new EndPosition(0, 7), 1));
            cubeList.add(new Cube(6, 5, new EndPosition(2, 4), 2));
            cubeList.add(new Cube(5, 2, new EndPosition(3, 5), 3));
            cubeList.add(new Cube(4, 7, new EndPosition(6, 4), 4));
            cubeList.add(new Cube(3, 7, new EndPosition(6, 2), 5));
            App.getController().setCube(cubeList);
        }

        if(level == 11) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 0, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 6, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 7, new EndPosition(7, 7), 1));
            cubeList.add(new Cube(0, 8, new EndPosition(4, 7), 2));
            cubeList.add(new Cube(3, 0, new EndPosition(3, 7), 3));
            cubeList.add(new Cube(1, 4, new EndPosition(5, 7), 4));
            cubeList.add(new Cube(2, 1, new EndPosition(8, 4), 5));
            App.getController().setCube(cubeList);
        }

        if(level == 12) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 6, 6, 6, 6, 0},
                    {0, 0, 0, 0, 0, 6, 0, 0},
                    {0, 0, 6, 6, 0, 6, 0, 0},
                    {0, 0, 6, 6, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 6, new EndPosition(5, 4), 1));
            cubeList.add(new Cube(3, 1, new EndPosition(6, 5), 2));
            cubeList.add(new Cube(5, 0, new EndPosition(4, 7), 3));
            cubeList.add(new Cube(4, 0, new EndPosition(6, 6), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 13) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 6, 6},
                    {0, 6, 0, 0, 6, 0, 0, 0},
                    {0, 6, 0, 0, 6, 0, 0, 0},
                    {0, 0, 0, 6, 6, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(6, 1, new EndPosition(3, 5), 1));
            cubeList.add(new Cube(1, 2, new EndPosition(6, 5), 2));
            cubeList.add(new Cube(1, 6, new EndPosition(6, 3), 3));
            cubeList.add(new Cube(3, 1, new EndPosition(6, 6), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 14) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(4, 1, new EndPosition(1, 4), 1));
            cubeList.add(new Cube(1, 1, new EndPosition(4, 4), 2));
            cubeList.add(new Cube(1, 0, new EndPosition(2, 4), 3));
            cubeList.add(new Cube(3, 3, new EndPosition(5, 3), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 15) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(3, 1, new EndPosition(6, 7), 1));
            cubeList.add(new Cube(0, 0, new EndPosition(3, 5), 2));
            cubeList.add(new Cube(0, 1, new EndPosition(7, 7), 3));
            cubeList.add(new Cube(1, 5, new EndPosition(5, 2), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 16) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 6, 6, 0},
                    {0, 0, 0, 0, 0, 6, 6, 0},
                    {0, 0, 0, 6, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 6, 0},
                    {0, 0, 0, 0, 6, 0, 6, 0},
                    {0, 0, 0, 0, 0, 0, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(7, 0, new EndPosition(1, 3), 1));
            cubeList.add(new Cube(2, 3, new EndPosition(3, 6), 2));
            cubeList.add(new Cube(1, 4, new EndPosition(6, 4), 3));
            cubeList.add(new Cube(6, 0, new EndPosition(7, 6), 4));
            App.getController().setCube(cubeList);
        }

        if(level == 17) {
            int[][] mass = new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 6, 6, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 6, 6, 6, 0, 6, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
            Field field = new Field(mass);
            Utils.createCubeBitmap((int)field.getWidthCell(), complexity);
            App.getController().setField(field);
            ArrayList<Cube> cubeList = new ArrayList<>();
            cubeList.add(new Cube(1, 6, new EndPosition(4, 3), 1));
            cubeList.add(new Cube(0, 3, new EndPosition(6, 5), 2));
            cubeList.add(new Cube(6, 1, new EndPosition(6, 7), 3));
            cubeList.add(new Cube(1, 1, new EndPosition(3, 6), 4));
            cubeList.add(new Cube(7, 0, new EndPosition(4, 6), 5));
            App.getController().setCube(cubeList);
        }

    }
}
