package com.alvarpq.GOTF;

import com.alvarpq.GOTF.gui.BoardDraw;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GOTF extends ApplicationAdapter {
	SpriteBatch batch;
	BoardDraw board;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		board = new BoardDraw();
	}

	//for VC
	//MORE FOR VC
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		board.drawit(batch);
		batch.end();
	}
}
