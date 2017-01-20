package ru.explead.features.logic;

import java.util.ArrayList;

import ru.explead.features.app.App;

/**
 * Created by develop on 30.12.2016.
 */

public class Controller {

    private Level level;
    private Field field;

    private ArrayList<Cube> cubes = new ArrayList<>();

    public Controller() {
        level = App.getLevel();
        field = new Field(level);
    }

    public Level getLevel() {
        return level;
    }

    public Field getField() {
        return field;
    }
}
