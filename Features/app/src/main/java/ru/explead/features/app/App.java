package ru.explead.features.app;

import android.app.Application;

import ru.explead.features.Utils.UtilsBitmaps;
import ru.explead.features.logic.BaseController;
import ru.explead.features.logic.ControllerOne;
import ru.explead.features.logic.ControllerThree;
import ru.explead.features.logic.ControllerTwo;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 30.12.2016.
 */

public class App extends Application {

    private static float widthScreen;
    private static float heightScreen;
    private static float sizeSurface;

    private static BaseController controller;
    private static Level level;
    private static UtilsBitmaps bitmaps;

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

    public static BaseController getController() {
        if(level.getComplexity() == Level.EASY) {
            return (ControllerOne)controller;
        }
        if(level.getComplexity() == Level.MEDIUM) {
            return (ControllerTwo)controller;
        }
        if(level.getComplexity() == Level.HARD) {
            return (ControllerThree)controller;
        }
        return null;
    }

    public static void setController(BaseController controller) {
        App.controller = controller;
    }

    public static Level getLevel() {
        return level;
    }

    public static void setLevel(Level level) {
        App.level = level;
    }

    public static float getSizeSurface() {
        return sizeSurface;
    }

    public static void setSizeSurface(float sizeSurface) {
        App.sizeSurface = sizeSurface;
    }

    public static UtilsBitmaps getBitmaps() {
        return bitmaps;
    }

    public static void setBitmaps(UtilsBitmaps bitmaps) {
        App.bitmaps = bitmaps;
    }

}
