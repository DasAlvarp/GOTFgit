package com.alvarpq.GOTF.screen;

import com.alvarpq.GOTF.coreGame.Game;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.units.real.TunnelGuard;
import com.alvarpq.GOTF.entity.Entity;
import com.alvarpq.GOTF.entity.EntityManager;
import com.alvarpq.GOTF.gui.BackDraw;
import com.alvarpq.GOTF.gui.BoardDraw;
import com.alvarpq.GOTF.gui.Hex;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
		
		game=new Game(null, null);
		game.getSide(Player.PLAYER1).getHalf().addUnit(new TunnelGuard(1,1));

		board = new BoardDraw();
		//bkgrnd = new BackDraw();
		
	}

	public void update() {
		// TODO Auto-generated method stub
		//checkForClick();
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		EntityManager.renderAll(batch);
		game.update();

		//batch.draw(new Texture(("menuScreen.png")), 200, 100);
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


	//if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			//ScreenManager.setScreen(new MenuScreen());
	public void checkForClick()
	{
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
		{
			//ScreenManager.setScreen(new MenuScreen());
			
		}
	}

}

