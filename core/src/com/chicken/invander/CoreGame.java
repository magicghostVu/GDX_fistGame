package com.chicken.invander;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import stateMan.MenuState;
import stateMan.StateMan;

public class CoreGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	StateMan stateMan;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		stateMan=new StateMan(new MenuState());
		//stateMan.getCurrentState().
		stateMan.getCurrentState().setStateMan(stateMan);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//stateMan.
		//stateMan.getCurrentState().update(Gdx.graphics.getDeltaTime());
		stateMan.getCurrentState().update(Gdx.graphics.getDeltaTime());
		stateMan.getCurrentState().render(batch);
		
		
	}
	
}
