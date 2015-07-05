package com.alvarpq.GOTF.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hex 
{
	int x, y;
	Sprite hx;
	


	public Hex(int x1, int y1, Sprite sprit)
	{
		hx = sprit;
		x = x1;
		y = y1;
	}

	public void drawit(SpriteBatch batch)
	{
		batch.draw(hx, x , y, 39, 45);
	}
}
