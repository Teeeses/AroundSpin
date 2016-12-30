package ru.explead.features.logic;

import android.graphics.Color;

import ru.explead.features.app.App;

/**
 * Created by develop on 30.12.2016.
 */

public class Controller {

    private Circle circle;

    public Controller() {
        circle = new Circle(App.getHeightScreen()*0.75f, App.getWidthScreen()/2, App.getWidthScreen()/12f, Color.MAGENTA);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
