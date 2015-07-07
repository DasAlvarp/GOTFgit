package com.alvarpq.GOTF.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hex 
{
	int x, y;
	Sprite hx;
	Sprite selected;

	private BitmapFont font;
	private static int LENGTH = 39;
	private static int HEIGHT = 45;

	public Hex(int x1, int y1, Sprite sprit, Sprite sel)
	{
		hx = sprit;
		x = x1;
		y = y1;
		selected = sel;
		
		font = new BitmapFont();
		font.setColor(Color.RED);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public void drawit(SpriteBatch batch)
	{

		font.draw(batch, "x: " + Gdx.input.getX() + " y: " + Gdx.input.getY(), 200, 200);
		if(getValidLocations(this.x,this.y, Gdx.input.getX(), Gdx.input.getY()))
			select(batch);
		else
			deselect(batch);
		
	}
	
	public void deselect(SpriteBatch batch)
	{
		batch.draw(hx, x, y, 39, 45);
	}
	public void select(SpriteBatch batch)
	{
		batch.draw(selected, x , y, 39, 45);
	}
	
	public boolean getValidLocations(int x, int y, int mouseX, int mouseY)
	{
		
		if(x < mouseX && x + LENGTH > mouseX)
		{
			if(HEIGHT / 4 + y < Gdx.graphics.getHeight() - mouseY && y + HEIGHT * 3 / 4 > Gdx.graphics.getHeight() - mouseY)// had to subtract top of window to get this to work. Apparently mouse and draw Y coordinates are different.
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
