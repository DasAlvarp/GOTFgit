package com.alvarpq.GOTF.gui;


import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardDraw {
	
	Texture tex = new Texture("hex.png");
	Sprite hex = new Sprite(tex);
	private static int LENGTH = 39;


	public void drawit (SpriteBatch batch) 
	{

		hex.setSize(39, 45);
		myBoard(5, batch);

	}
	
	public void myBoard(int col, SpriteBatch batch)
	{
		float len = hex.getWidth();
		float height = hex.getHeight();
		
		int hOff = (int) (height - Math.sqrt(Math.pow(height, 2) / 4 - Math.pow(len, 2) / 4));
		
		for(int x = 0; x < col; x++)
		{
			if(x %2 == 0)
			{
				drawRow(5, 0, hOff * x,  batch);
			}
			else
			{
				drawRow(5, (int)len / 2, hOff * x, batch);
				
			}
		}
	}
	
	public void theEnemy(BoardHalf evil, SpriteBatch batch)
	{
		
	}
	
	
	private void drawRow(int length, int startX, int startY, SpriteBatch batch)
	{
		for(int x = 0; x < length; x++)
		{
			batch.draw(hex, startX + hex.getWidth() * x, startY, 39, 45);
		}
	}
}
