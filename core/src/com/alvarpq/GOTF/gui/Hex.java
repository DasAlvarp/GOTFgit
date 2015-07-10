package com.alvarpq.GOTF.gui;

import java.util.ArrayList;

import com.alvarpq.GOTF.entity.AnimatedSprite;
import com.alvarpq.GOTF.entity.Entity;
import com.alvarpq.GOTF.entity.EntityManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Hex extends Entity
{
	int x, y;
	private AnimatedSprite hx;
	private AnimatedSprite sel;
	private AnimatedSprite atk;
	private BitmapFont font;
	private static int LENGTH = 117;
	private static int HEIGHT = 135;
	private boolean highlighted=false;
	private boolean adj=false;
	
	public Hex(int x1, int y1, Sprite sprit, AnimatedSprite sel)
	{
		super();
		this.sel=sel;
		hx = new AnimatedSprite(sprit);
		x = x1;
		y = y1;
		
		font = new BitmapFont();
		font.setColor(Color.RED);
		
		EntityManager.addEntity(this);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public void adjacent(){
		adj=true;
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
	public AnimatedSprite getSprite() {
		// TODO Auto-generated method stub
		if(highlighted){
			return sel;
		}
		return hx;
	}

	public Vector2 getLocation() 
	{
		// TODO Auto-generated method stub
		return new Vector2(x,y);
	}

	@Override
	public void update() {

		if(getValidLocations(Gdx.input.getX(), Gdx.input.getY()) || adj)
			select();
		else deselect();
		adj=false;
	}
}
