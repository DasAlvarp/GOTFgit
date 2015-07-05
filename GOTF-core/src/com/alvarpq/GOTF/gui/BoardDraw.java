package com.alvarpq.GOTF.gui;


import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardDraw {
	
	Texture hex = new Texture("hex.png");
	private static int LENGTH = 125;


	public void drawit (SpriteBatch batch) 
	{

		drawRow(5, 0, 0, batch);

	}
	
	public void myBoard(BoardHalf mois, SpriteBatch batch)
	{
		
	}
	
	public void theEnemy(BoardHalf evil, SpriteBatch batch)
	{
		
	}
	
	
	private void drawRow(int length, int startX, int startY, SpriteBatch batch)
	{
		for(int x = 0; x < length; x++)
		{
			batch.draw(hex, startX + LENGTH * x, startY, LENGTH, LENGTH);
		}
	}
}
