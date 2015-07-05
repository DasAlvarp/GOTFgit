package com.alvarpq.GOTF;

import com.alvarpq.GOTF.gui.BoardDraw;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GOTF extends ApplicationAdapter
{
	//Trying Solaus background, change back if needed to
	/*SpriteBatch batch;
	BoardDraw board;
	BitmapFont font;
	Texture gotf;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		board = new BoardDraw();
		gotf = new Texture("thing.jpg");
	}

	//for VC
	//MORE FOR VC
	@Override
	public void render ()
	{
		Gdx.gl.glClearColor(1, 0, 0, 1);//background, I do believe. Totally not sure.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		board.drawit(batch);
		batch.draw(gotf, 0, 150, 230, 100);//important hypey stuff
		batch.end();
	}*/
	SpriteBatch batch;
	Texture background;
	long lastTime;
	long timePassed;
	@Override
	public void create()
	{
		batch = new SpriteBatch();
		background = new Texture("GoF_Board.png");
		lastTime = System.currentTimeMillis();
		timePassed = 0;
	}
	@Override
	public void render()
	{
		timePassed+=System.currentTimeMillis()-lastTime;
		lastTime = System.currentTimeMillis();
		Gdx.gl.glClearColor((float)Math.abs(Math.tan(timePassed/60000.0*Math.PI*2)), (float)Math.abs(Math.sin(timePassed/60000.0*Math.PI*2)), (float)Math.abs(Math.cos(timePassed/60000.0*Math.PI*2)), 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0, 870, 412);
		batch.end();
	}
}
