package com.alvarpq.GOTF.screen;

import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.Deck;
import com.alvarpq.GOTF.coreGame.cards.ExampleSpellCard;
import com.alvarpq.GOTF.coreGame.cards.ExampleUnitCard;
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
		batch = new SpriteBatch();
		batch=new SpriteBatch();
		game=new Game(new Deck(Arrays.asList(new Card[]{new ExampleUnitCard(), new ExampleUnitCard()}), false),
				new Deck(Arrays.asList(new Card[]{new ExampleSpellCard(), new ExampleSpellCard()}), false));
		//board = new BoardDraw();
		//bkgrnd = new BackDraw();
		
	}

	public void update() {
		checkForClick();
	}

	@Override
	public void render(SpriteBatch batch) {
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);      //clears the buffer 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  
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
		}
	}


}
