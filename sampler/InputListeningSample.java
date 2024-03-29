package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.Utils.GdxUtils;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class InputListeningSample extends SampleBase {

	public static final SampleInfo SAMPLE_INFO =
			new SampleInfo(InputListeningSample.class);

	// logger
	private static final Logger log =
			new Logger(InputListeningSample.class.getName(),
					Logger.DEBUG);

	private static final int MAX_MESSAGE_COUNT = 15;

	// array of messages
	private final Array<String> messages = new Array<String>();

	private OrthographicCamera camera;
	private Viewport viewport;
	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		camera = new OrthographicCamera();
		viewport = new FitViewport(1080, 720, camera);
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

		Gdx.input.setInputProcessor(this);
	};

		/*multiplexer.addProcessor(firstProcessor);
		multiplexer.addProcessor(secondProcessor);


		Gdx.input.setInputProcessor(multiplexer);

		gdx.input.setInputProcessor(this);


		// getting input adapapter
		Gdx.input.setInputProcessor(new InputAdapter() {
			public boolean keyDown (int keycode) {
				log.debug("keyDown keycode = " + keycode);
				return true;
			}
		});
	}*/

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void render() {
		// We cant instantiate this class because its our own private
		// utility class located in com.sampler >> Utils >> Gdx Utils
		GdxUtils.clearScreen();


		batch.setProjectionMatrix(camera.combined);
		// anything drawn has to be done so between these two lines
		batch.begin();

		draw();


		batch.end();

	}

	private void draw() {
		// draw messages on screen by looping our array of msgs
		for (int i = 0; i < messages.size; i++) {
			font.draw(batch, messages.get(i),
					// for x
					20.0f,
					// for y, we print our first msg at 40.0f below
					// and then the second msg in array gets printed
					// 40.0f * (i + 1) or 80.0f below the first msg
					720-40.0f * (i + 1)
					);
		}

	}

	private void addMessage(String message) {
		messages.add(message);

		if (messages.size > MAX_MESSAGE_COUNT) {
			// remove last message (or first in our array)
			messages.removeIndex(0);
		}
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		// dispose resources
		batch.dispose();
		font.dispose();

	}

	@Override
	public boolean keyDown(int keycode) {
		String message = "keyDown keycode = " + keycode;
		log.debug(message);
		addMessage(message);
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		String message = "keyUp keycode = " + keycode;
		log.debug(message);
		addMessage(message);
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		String message = "keyTyped keycode = " + character;
		log.debug(message);
		addMessage(message);
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		String message = "touchDown screenX = " + screenX
				+ " screenY = " + screenY;
		log.debug(message);
		addMessage(message);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		String message = "touchUp screenX = " + screenX
				+ " screenY = " + screenY;
		log.debug(message);
		addMessage(message);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		String message = "touchDragged screenX = " + screenX
				+ " screenY = " + screenY;
		log.debug(message);
		addMessage(message);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		String message = "mouseMoved screenX = " + screenX
				+ " screenY = " + screenY;
		log.debug(message);
		addMessage(message);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		String message = "scrolled amount = " + amount;
		log.debug(message);
		addMessage(message);
		return false;
	}
}