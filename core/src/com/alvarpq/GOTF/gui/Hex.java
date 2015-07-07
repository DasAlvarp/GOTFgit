package com.alvarpq.GOTF.gui;

import com.alvarpq.GOTF.entity.Entity;
import com.alvarpq.GOTF.entity.EntityManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hex extends Entity
{
	int x, y;
	Sprite hx;
	Sprite selected;

	private BitmapFont font;
	private static int LENGTH = 78;
	private static int HEIGHT = 90;
	private boolean highlighted=false;
	
	public Hex(int x1, int y1, Sprite sprit, Sprite sel)
	{
		super();
		System.out.println("Hex at x="+x1+" y="+y1);
		hx = sprit;
		x = x1;
		y = y1;
		selected = sel;
		
		font = new BitmapFont();
		font.setColor(Color.RED);
		
		EntityManager.addEntity(this);
		System.out.println("Added.");
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	
	public void deselect()
	{
		highlighted=false;
	}
	public void select()
	{
		highlighted=true;
	}
	
	public boolean getValidLocations(int mouseX, int mouseY)
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

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub

		if(highlighted){
			return selected;
		}
		return hx;
	}

	@Override
	public Vector2 getLocation() {
		// TODO Auto-generated method stub
		return new Vector2(x,y);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(getValidLocations(Gdx.input.getX(), Gdx.input.getY()))
			select();
		else
			deselect();
	}
}
