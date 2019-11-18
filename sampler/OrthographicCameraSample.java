package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.Utils.GdxUtils;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class OrthographicCameraSample extends SampleBase {

    private static final Logger log =
            new Logger(OrthographicCameraSample.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO =
            new SampleInfo(OrthographicCameraSample.class);

    // this is not pixels, in world units
    private static final float WORLD_WIDTH = 10.8f; // world units
    private static final float WORLD_HEIGHT = 7.2f; // world units

    // camera speed
    private static final float CAMERA_SPEED = 2.0f; // world units
    private static final float CAMERA_ZOOM_SPEED = 2.0f; // world units

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;

    private Texture texture;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();

        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("raw/level-bg.png"));
        }

    @Override
    public void render() {
        queryInput();

        // first we need to clear our screen
        GdxUtils.clearScreen();

        // rendering or drawing
        // setProjectionMatrix() tells batch about location, rotation, zoom
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // draw() always takes place between begin() and end()
        draw();

        batch.end();
    }

    // create input polling calls for zooming and moving camera
    private void queryInput() {
        // deltaTime is time that has passed between two frames. So it is a
        // really low number. Something like 1/60
        float deltaTime = Gdx.graphics.getDeltaTime();

        // moving keys pressed
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            // we use -= because if we are moving left, our x moves left
            camera.position.x -= CAMERA_SPEED * deltaTime;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.position.x += CAMERA_SPEED * deltaTime;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.position.y += CAMERA_SPEED * deltaTime;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            // we use -= because if we are moving down, our y moves down
            camera.position.y -= CAMERA_SPEED * deltaTime;
        }

        // page up or down
        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_UP)) {
            camera.zoom -= CAMERA_ZOOM_SPEED * deltaTime;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_DOWN)) {
            camera.zoom += CAMERA_ZOOM_SPEED * deltaTime;
        }

        // zoom
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            log.debug("position = " + camera.position);
            log.debug("zoom = " + camera.zoom);
        }

        // anytime we zoom or move we need to update camera
        camera.update();

    }

    private void draw() {
        // we are going to draw our texture using sprite
        batch.draw(texture,
                0,0, // x and y cord
                WORLD_WIDTH, WORLD_HEIGHT);


    }

    @Override
    public void resize(int width, int height) {
        // the final boolean is for a centered camera
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        // dispose our resources -- to avoid memory leaks and crashes
        batch.dispose();
        texture.dispose();
    }





}








