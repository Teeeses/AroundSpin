package ru.explead.features.logic;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;

import ru.explead.features.app.App;

/**
 * Created by develop on 30.12.2016.
 */

public class Controller {

    private Level level;
    private Field field;

    private ArrayList<Cube> cubes = new ArrayList<>();

    public Controller(int sizeSurface) {
        level = App.getLevel();
        field = new Field(level, sizeSurface);
        cubes.add(new Cube(3, 3, Color.CYAN, field));
    }

    public void onDraw(Canvas canvas) {
        for(int i = 0; i < cubes.size(); i++) {
            cubes.get(i).onDraw(canvas);
        }
    }

    public Level getLevel() {
        return level;
    }

    public Field getField() {
        return field;
    }
}
