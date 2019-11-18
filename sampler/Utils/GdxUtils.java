package com.sampler.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class GdxUtils {

    public static void clearScreen() {
        // for black screen
        clearScreen(Color.BLACK);
    }

    // accepts argument colors
    public static void clearScreen(Color color) {
            // clear screen (two lines below) :
            // DRY = Don't Repeat Yourself
            // WET = Waste Everyone's Time
            Gdx.gl.glClearColor( color.r, color.g, color.b, color.a);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

    // private constructor makes it to where we can't instance this class
    private GdxUtils() {}

}
