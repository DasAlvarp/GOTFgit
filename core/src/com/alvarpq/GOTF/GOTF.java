package com.alvarpq.GOTF;

import com.alvarpq.GOTF.gui.BackDraw;
import com.alvarpq.GOTF.gui.BoardDraw;
import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GOTF extends ApplicationAdapter
{

	//Trying Solaus background, change back if needed to
	SpriteBatch batch;
	BoardDraw board;
	BackDraw bkgrnd;
	
	@Override
	public void create () 
	{//batch is what lets images exist..I think. Rest of names are intuitive.
		batch = new SpriteBatch();
		board = new BoardDraw();
		bkgrnd = new BackDraw();
	}

	//for VC
	//MORE FOR VC
	@Override
	public void render ()
	{
		batch.begin();
		bkgrnd.drawit(batch);//drawit functions are default draw functions
		board.drawit(batch);
		batch.end();
	}
}
