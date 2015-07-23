package com.alvarpq.GOTF.gui;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a tile and it's unit
public class Tile extends Actor
{
	//holds eventual unit
	private Unit unit;
	//holds the unit's sprite
	private Sprite unitSprite;
	//holds the unselected tile sprite
	private Sprite tile;
	//holds the animated highlightedTile animation
	private Animation highlightedTile;
	//holds the current time in the animation
	private float animationTime;
	//whether this tile is selected or not
	boolean highlighted;
	//holds the font for drawing stats
	private BitmapFont font;
	//constructs a new unselected tile
	public Tile(Sprite tile, Animation highlightedTile)
	{
		unit = null;
		unitSprite = null;
		this.tile = tile;
		this.highlightedTile = highlightedTile;
		animationTime = 0;
		highlighted = false;
		font = new BitmapFont();
		font.setColor(Color.BLACK);		
	}
	//draws the tile
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		//checks whether the tile is highlighted or not
		if(highlighted)
		{
			//draws the highlighted animation
			Sprite temp = new Sprite(highlightedTile.getKeyFrame(animationTime));
			temp.setBounds(tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
			temp.rotate90(true);
			temp.draw(batch);
		}
		else
		{
			//draws the normal tile
			tile.draw(batch);
		}
		//draws the unit if there is one
		if(unit!=null)
		{
			unitSprite.draw(batch);
			GlyphLayout temp = new GlyphLayout(font, unit.getAttack()+"");
			font.draw(batch, temp, tile.getX()+15-temp.width/2, tile.getY()+tile.getHeight()/2+temp.height/2);
			temp.setText(font, unit.getCountdown()+"");
			font.draw(batch, temp, tile.getX()+tile.getWidth()/2-temp.width/2, tile.getY()+15+temp.height/2);
			temp.setText(font, unit.getHealth()+"");
			font.draw(batch, temp, tile.getX()+tile.getWidth()-15-temp.width/2, tile.getY()+tile.getHeight()/2+temp.height/2);
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
	//highlighteds the tile and resets the animation to start from the beginning
	public void highlight()
	{
		//if stops animation from restarting when highlighting a highlighted tile
		if(!highlighted)
		{
			highlighted = true;
			animationTime = 0;
		}
	}
	//dehighlight the tile
	public void dehighlight()
	{
		highlighted = false;
	}
	//returns whether the tile is selected
	public boolean isHighlighted()
	{
		return highlighted;
	}
	//sets the tile's unit and fixes it's sprite
	public void setUnit(Unit unit)
	{
		this.unit = unit;
		if(unit==null)
		{
			unitSprite = null;
		}
		else
		{
			if(unit.getImage()==null)
			{
				unitSprite = new Sprite(new Texture("noTexture.png"));
			}
			else
			{
				unitSprite = new Sprite(new Texture(unit.getImage()));
			}
			unitSprite.setBounds(tile.getX()+tile.getWidth()/4, tile.getY(), tile.getWidth()/2, tile.getHeight());
		}
	}
}
