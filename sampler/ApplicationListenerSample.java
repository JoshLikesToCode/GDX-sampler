package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class ApplicationListenerSample extends SampleBase {

    // To interrupt render from displaying every 60 seconds:
    private boolean renderInterrupted = true;

    // Logger to replace line :
    // 		Gdx.app.debug("ApplicationListener", "create()");

    // Declare logger
    private static final Logger log =
            new Logger(ApplicationListener.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO =
            new SampleInfo(ApplicationListenerSample.class);

    // used to initialize comment and load resources
    @Override
    public void create() {
        // enable logging
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        log.debug("create()");
    }

    // used to handle setting a new screen size
    @Override
    public void resize(int width, int height) {
        log.debug("resize() width = " + width + " height = " + height);
    }

    // used to render the game elements. it's called 60 times
    // per second
    @Override
    public void render() {
        if (renderInterrupted) {
            log.debug("render()");
            renderInterrupted = false;
        }

    }

    // used to save game state when it loses focus, which doesn't
    // involve the actual game play unless dev wants it to pause
    @Override
    public void pause() {
        log.debug("pause()");
        // reset renderInterrupted
        renderInterrupted = true;

    }

    // used to handle the game from coming back from being paused.
    // it restores the game state from before pause.
    @Override
    public void resume() {
        log.debug("resume()");
        // set renderInterrupted to true
        renderInterrupted = true;

    }

    // used to free our resources and clean up our game
    @Override
    public void dispose() {
        log.debug("dispose()");

    }
}
