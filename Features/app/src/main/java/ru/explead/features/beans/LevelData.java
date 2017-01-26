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
    private ArrayList<CubeData> cubeData = new ArrayList<>();

    public LevelData(Field field, ArrayList<CubeData> cubeData) {
        this.field = field;
        this.cubeData = cubeData;
    }

    public Field getField() {
        return field;
    }

    public ArrayList<CubeData> getCubeData() {
        return cubeData;
    }
}
