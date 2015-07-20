package com.alvarpq.GOTF.oldgui;
import com.alvarpq.GOTF.oldgui.screen.GameScreen;
import com.alvarpq.GOTF.oldgui.screen.ScreenManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GOTF extends ApplicationAdapter
{

	//Trying Solaus background, change back if needed to
	SpriteBatch batch;

	
	@Override
	public void create() 
	{//batch is what lets images exist..I think. Rest of names are intuitive.
		batch = new SpriteBatch();
		ScreenManager.setScreen(new GameScreen());
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
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  
		batch.begin();
		
		if(ScreenManager.getCurrentScreen()!=null){
			ScreenManager.getCurrentScreen().render(batch);
		}
		if(ScreenManager.getCurrentScreen()!=null){
			ScreenManager.getCurrentScreen().update();
		}
		batch.end();
	}
	
	public void resize(int width, int height){
		if(ScreenManager.getCurrentScreen()!=null){
			ScreenManager.getCurrentScreen().resize(width, height);
		}
	}
}
