package com.alvarpq.GOTF.gui;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to add first in gamestage which draws the background
public class GameBackground extends Actor
{
	//draws the background
    @Override
    public void draw(Batch batch, float parentAlpha)
    {
    	Gdx.gl.glClearColor(1, 1, 1, 0);
    }
}