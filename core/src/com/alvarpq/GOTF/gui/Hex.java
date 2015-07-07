package com.alvarpq.GOTF.gui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
	private static int SELECTEDFRAMES = 7;

	ArrayList<Texture> textureFrames = new ArrayList<Texture>();
	ArrayList<Texture> attackingFrames = new ArrayList<Texture>();
	
	public boolean selectOut;

	private int currentFrame;
	
	private BitmapFont font;
	private static int LENGTH = 39;
	private static int HEIGHT = 45;

	private int tick;
	
	
	public Hex(int x1, int y1, Sprite sprit, Sprite sel)
	{
		hx = sprit;
		x = x1;
		y = y1;
		selected = sel;
		
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		
		String locationString = "GUI/selectedTiles/selectedTile";
		String loc2string = "GUI/attackingTiles/attackingTile";
		
		for(int x = 0; x < SELECTEDFRAMES; x++)
		{
			textureFrames.add(new Texture(locationString + "(" + x + ").png"));//ghetto-rigged animation is the best kind of animation.
			attackingFrames.add(new Texture(loc2string + "(" + x + ").png"));
		}
		
		currentFrame = 0;
		tick = 0;
		
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	//draws sprite
	public void drawit(SpriteBatch batch)
	{

		tick = (tick + 1) % 4; //amount of frames per current frame switch
		if(tick == 0)
			currentFrame = (currentFrame + 1) % SELECTEDFRAMES;

		
		font.draw(batch, "x: " + Gdx.input.getX() + " y: " + Gdx.input.getY(), 200, 200);
		if(getValidLocations(this.x,this.y, Gdx.input.getX(), Gdx.input.getY()))
			select(batch);
		else
			deselect(batch);
		
	}
	
	//deselects a sprite
	public void deselect(SpriteBatch batch)
	{
		batch.draw(hx, x, y, 39, 45);
	}
	
	//selects a hex
	public void select(SpriteBatch batch)
	{
		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT))
			selected = new Sprite(attackingFrames.get(currentFrame));
		else
			selected = new Sprite(textureFrames.get(currentFrame));
		batch.draw(selected, x , y, 39, 45);
	}
	
	//returns whether a hex placed at x, y, is overlapped by the coordinates of mouseX and mouseY
	public boolean getValidLocations(int x, int y, int mouseX, int mouseY)
	{
		
		if(x < mouseX && x + LENGTH / 2 > mouseX)
		{
			if(HEIGHT / 4 + y - (mouseX - x) * .5 < Gdx.graphics.getHeight() - mouseY && y + HEIGHT * 3 / 4 + (mouseX - x) * .5 > Gdx.graphics.getHeight() - mouseY)// had to subtract top of window to get this to work. Apparently mouse and draw Y coordinates are different.
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(x + LENGTH / 2 < mouseX && x + LENGTH  > mouseX)
		{
			if(y - HEIGHT / 4 + (mouseX - x) * .5 < Gdx.graphics.getHeight() - mouseY && y + HEIGHT * 5 / 4 - (mouseX - x) * .5 > Gdx.graphics.getHeight() - mouseY)// had to subtract top of window to get this to work. Apparently mouse and draw Y coordinates are different.
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
