package com.alvarpq.GOTF;

import com.alvarpq.GOTF.gui.BackDraw;
import com.alvarpq.GOTF.gui.BoardDraw;
import com.alvarpq.GOTF.screen.GameScreen;
import com.alvarpq.GOTF.screen.MenuScreen;
import com.alvarpq.GOTF.screen.ScreenManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GOTF extends ApplicationAdapter
{

	//Trying Solaus background, change back if needed to
	SpriteBatch batch;
	BoardDraw board;
	BackDraw bkgrnd;
	
	@Override
	public void create() 
	{//batch is what lets images exist..I think. Rest of names are intuitive.
		batch = new SpriteBatch();
		ScreenManager.setScreen(new MenuScreen());
	}

	
	public void dispose(){
		if(ScreenManager.getCurrentScreen()!=null){
			ScreenManager.getCurrentScreen().dispose();
		}
		batch=new SpriteBatch();
	}
	//for VC
	//MORE FOR VC
	@Override
	public void render ()
	{
		if(ScreenManager.getCurrentScreen()!=null){
			ScreenManager.getCurrentScreen().render(batch);
		}
		if(ScreenManager.getCurrentScreen()!=null){
			ScreenManager.getCurrentScreen().update();
		}
	}
	
	public void resize(int width, int height){
		if(ScreenManager.getCurrentScreen()!=null){
			ScreenManager.getCurrentScreen().resize(width, height);
		}
	}
}
