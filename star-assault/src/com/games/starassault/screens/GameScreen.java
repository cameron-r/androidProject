package com.games.starassault.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.games.starassault.controller.BobController;
import com.games.starassault.model.World;
import com.games.starassault.view.WorldRenderer;

public class GameScreen implements Screen, InputProcessor {
	private static final String TAG = GameScreen.class.getSimpleName();
	
	private World world;
	private WorldRenderer renderer;
	private BobController controller;
	
	private int width, height;
	
	@Override
	public void render(float delta) {
		//Gdx.app.log(TAG, "in render");
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		controller.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(TAG, "in resize, w = " + width + ", h = " + height);
		renderer.setSize(width, height);
	}

	@Override
	public void show() {
		world = new World();
		renderer = new WorldRenderer(world, true);
		controller = new BobController(world);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	}

	
	// * InputProcessor methods ************/
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT)
			controller.leftPressed();
		if (keycode == Keys.RIGHT)
			controller.rightPressed();
		if (keycode == Keys.Z)
			controller.jumpPressed();
		if (keycode == Keys.X)
			controller.firePressed();
		if (keycode == Keys.D)
			renderer.toggleDebug();
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			controller.leftReleased();
		if (keycode == Keys.RIGHT)
			controller.rightReleased();
		if (keycode == Keys.Z)
			controller.jumpReleased();
		if (keycode == Keys.X)
			controller.fireReleased();
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (screenX < width/2 && screenY > height/2) {
			controller.leftPressed();
		}
		if (screenX > width/2 && screenY > height/2) {
			controller.rightPressed();
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (screenX < width/2 && screenY > height/2) {
			controller.leftReleased();
		}
		if (screenX > width/2 && screenY > height/2) {
			controller.rightReleased();
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
