package ru.explead.features.beans;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ru.explead.features.logic.Cube;
import ru.explead.features.logic.Field;

/**
 * Created by develop on 25.01.2017.
 */

public class LevelData {

    private Field field;
    private ArrayList<Cube> cubes = new ArrayList<>();

    public LevelData(Field field, ArrayList<Cube> cubes) {
        this.field = field;
        this.cubes = cubes;
    }

    public Field getField() {
        return field;
    }

    public ArrayList<Cube> getCubes() {
        return cubes;
    }
}
