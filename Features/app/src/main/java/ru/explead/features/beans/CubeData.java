package ru.explead.features.beans;

import ru.explead.features.logic.Cube;

/**
 * Created by Александр on 27.01.2017.
 */

public class CubeData {

    private Cube cube;
    private EndPosition endPosition;

    public CubeData(Cube cube, EndPosition endPosition) {
        this.cube = cube;
        this.endPosition = endPosition;
    }

    public Cube getCube() {
        return cube;
    }

    public EndPosition getEndPosition() {
        return endPosition;
    }
}
