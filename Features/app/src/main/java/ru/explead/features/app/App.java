package ru.explead.features.app;

import android.app.Application;

import ru.explead.features.logic.Controller;

/**
 * Created by develop on 30.12.2016.
 */

public class App extends Application {

    private static float widthScreen;
    private static float heightScreen;

    private static Controller controller;


    public static float getWidthScreen() {
        return widthScreen;
    }

    public static void setWidthScreen(float widthScreen) {
        App.widthScreen = widthScreen;
    }

    public static float getHeightScreen() {
        return heightScreen;
    }

    public static void setHeightScreen(float heightScreen) {
        App.heightScreen = heightScreen;
    }

    public static Controller getController() {
        return controller;
    }

    public static void setController(Controller controller) {
        App.controller = controller;
    }
}
