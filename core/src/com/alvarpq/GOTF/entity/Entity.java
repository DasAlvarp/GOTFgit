package com.alvarpq.GOTF.entity;

import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.gui.BoardDraw;
import com.alvarpq.GOTF.gui.Hex;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity 
{
	
	
	protected Vector2 pos;
	protected AnimatedSprite sprite;
	public Entity()
	{
		if(this instanceof Hex){
			pos=((Hex)this).getLocation();
		}
		else if(this instanceof Unit){
			Unit u=(Unit) this;
		pos=BoardDraw.getRenderLocation(u.getOwner(),u.getRow(), u.getColumn());
		}
		sprite=getSprite();
		
		
	}
	
	public abstract AnimatedSprite getSprite();
	public abstract void update();
	
	public void render(SpriteBatch sb){
		update();
		
		if(this instanceof Hex){
			pos=((Hex)this).getLocation();
		}
		else if(this instanceof Unit){
			Unit u=(Unit) this;
		pos=BoardDraw.getRenderLocation(u.getOwner(),u.getRow(), u.getColumn());
		}
		getSprite().update();
		sprite=getSprite();
		sprite.getCurrentFrame().setPosition(pos.x, pos.y);
		sprite.getCurrentFrame().draw(sb);
	}

}
