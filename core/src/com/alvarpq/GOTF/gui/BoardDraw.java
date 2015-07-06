package com.alvarpq.GOTF.gui;



import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class BoardDraw 
{
	
	
	private static int LENGTH = 39;//optimal length
	private static int HEIGHT = 45;//optimal height
	private ArrayList<Hex> hexes = new ArrayList<Hex>();
	
	Texture	tex = new Texture("BoardTile.png");
	Texture selTex = new Texture("hex.png");
	Sprite 	hx = new Sprite(tex);
	Sprite sel = new Sprite(selTex);

	
	public BoardDraw()//setting up the board. Probably should be called on every board update, since it will eventaully include the board state.
	{
		hexes.clear();
		hx.setSize(LENGTH, HEIGHT);
		myBoard(5);
		theEnemy(5);
	}
	
	//main draw function
	public void drawit (SpriteBatch batch) 
	{
		for(int x = 0; x < hexes.size(); x++)
		{
			hexes.get(x).drawit(batch);
		}

	}
	
	//draws my end of teh board
	public void myBoard(int col)//col = number of columns. 
	{
		
		//8bit did math. Please send all hatred/questions to him :P
		int hOff = (int) (HEIGHT - Math.sqrt(Math.pow(HEIGHT, 2) / 4 - Math.pow(LENGTH, 2) / 4));
		
		for(int x = 0; x < col; x++)
		{
			if(x %2 == 0)
			{
				makeRow(3, 0, hOff * x);
			}
			else
			{
				makeRow(3, (int)LENGTH / 2, hOff * x);
				
			}
		}
	}
	
	//like my board, but not.
	public void theEnemy(int col)
	{
		int hOff = (int) (HEIGHT - Math.sqrt(Math.pow(HEIGHT, 2) / 4 - Math.pow(LENGTH, 2) / 4));
		
		for(int x = 0; x < col; x++)
		{
			if(x % 2 == 1)
			{
				makeRow(3, (int)(LENGTH * 4), hOff * x);
			}
			else
			{
				makeRow(3, (int)(LENGTH / 2 + LENGTH * 4), hOff * x);
				
			}
		}
	}
	
	//draws a row.
	private void makeRow(int length, int startX, int startY)//length in hexes
	{
		for(int x = 0; x < length; x++)
		{
			hexes.add(new Hex(startX + LENGTH * x, startY, hx, sel));
		}
	}
}
