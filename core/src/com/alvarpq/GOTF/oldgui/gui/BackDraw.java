package com.alvarpq.GOTF.oldgui.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackDraw 
{
	long lastTime;
	long timePassed;
	
	public BackDraw()//initialize variables.
	{
		lastTime = System.currentTimeMillis();
		timePassed = 0;
	}
	
	
	public void drawit(SpriteBatch batch)
	{
		/*timePassed += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		Gdx.gl.glClearColor((float)Math.abs(Math.tan(timePassed/60000.0*Math.PI*2)), (float)Math.abs(Math.sin(timePassed/60000.0*Math.PI*2)), (float)Math.abs(Math.cos(timePassed/60000.0*Math.PI*2)), 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);*/
		Gdx.gl.glClearColor(0,0,0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
