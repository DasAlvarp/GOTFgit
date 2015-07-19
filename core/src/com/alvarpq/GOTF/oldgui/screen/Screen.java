package com.alvarpq.GOTF.oldgui.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//All screens, including Menu, Deckbuilder, Game, etc will be instances of Screen. Rendering happens afterwards.
public abstract class Screen {

	public abstract void create();
	
	public abstract void update();
	
	public abstract void render(SpriteBatch batch);
	
	public abstract void resize(int width, int height);
	
	public abstract void dispose();
	
	
}
