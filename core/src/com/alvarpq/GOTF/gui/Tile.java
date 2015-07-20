package com.alvarpq.GOTF.gui;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a tile and it's unit (unit not fixed yet)
public class Tile extends Actor
{
	//holds the unselected tile sprite
	private Sprite tile;
	//holds the animated selectedTile animation
	private Animation selectedTile;
	//holds the current time in the animation
	private float animationTime;
	//whether this tile is selected or not
	boolean selected;
	//constructs a new unselected sprite
	public Tile(Sprite tile, Animation selectedTile)
	{
		this.tile = tile;
		this.selectedTile = selectedTile;
		animationTime = 0;
		selected = false;
	}
	//draws the tile
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		//checks whether the tile is selected or not
		if(selected)
		{
			//draws the selected animation
			Sprite temp = new Sprite(selectedTile.getKeyFrame(animationTime));
			temp.setBounds(tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
			temp.rotate90(true);
			temp.draw(batch);
		}
		else
		{
			//draws the normal tile
			tile.draw(batch);
		}
	}
	@Override
	public void act(float deltaTime)
	{
		//updates the animation
		animationTime+=deltaTime;
	}
	//returns whether a certain coordinate is within the tile's bounds
	public boolean hasInsideBounds(float x, float y)
	{
		if(new Circle(tile.getX()+tile.getWidth()/2, tile.getY()+tile.getHeight()/2, tile.getWidth()/2).contains(x, y))
		{
			return true;
		}
		return false;
	}
	//selects the tile and resets the animation to start from the beginning
	public void select()
	{
		//if stops animation from restarting when selecting a selected tile
		if(!selected)
		{
			selected = true;
			animationTime = 0;
		}
	}
	//deselects the tile
	public void deselect()
	{
		selected = false;
	}
	//returns whether the tile is selected
	public boolean isSelected()
	{
		return selected;
	}
}
