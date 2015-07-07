package com.alvarpq.GOTF.screen;

import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.units.ProudMercenary;
import com.alvarpq.GOTF.entity.Entity;
import com.alvarpq.GOTF.entity.EntityManager;
import com.alvarpq.GOTF.gui.BackDraw;
import com.alvarpq.GOTF.gui.BoardDraw;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends Screen{

	BoardDraw board;
	BackDraw bkgrnd;
	SpriteBatch batch;
	Game game;
	boolean bool=false;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub

		batch=new SpriteBatch();
		game=new Game();
		batch = new SpriteBatch();
		//board = new BoardDraw();
		//bkgrnd = new BackDraw();
		
	}

	public void update() {
		// TODO Auto-generated method stub
		//checkForClick();
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub

	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);      //clears the buffer 

		batch.begin();
		
		//bkgrnd.drawit(batch);//drawit functions are default draw functions
		//board.drawit(batch);
		//batch.draw(new Texture(("menuScreen.png")), 200, 100);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		
	}
	


	public void checkForClick()
	{
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
		{
			ScreenManager.setScreen(new MenuScreen());
			
		//}
	}

}
}
