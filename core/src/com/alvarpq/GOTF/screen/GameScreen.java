package com.alvarpq.GOTF.screen;

import com.alvarpq.GOTF.coreGame.Game;
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
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		batch=new SpriteBatch();
		game=new Game();
=======
		batch = new SpriteBatch();
>>>>>>> origin/WIP-ScreenManager
		//board = new BoardDraw();
		//bkgrnd = new BackDraw();
		
	}

	public void update() {
		// TODO Auto-generated method stub
		checkForClick();
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  
=======
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);      //clears the buffer 
>>>>>>> origin/WIP-ScreenManager
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
	
<<<<<<< HEAD
	public void checkForClick(){
		//if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			//ScreenManager.setScreen(new MenuScreen());
=======
	public void checkForClick()
	{
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
		{
			ScreenManager.setScreen(new MenuScreen());
>>>>>>> origin/WIP-ScreenManager
			
		//}
	}

}
