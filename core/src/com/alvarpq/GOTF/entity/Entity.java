package com.alvarpq.GOTF.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Vector2 pos;
	protected Sprite sprite;
	public Entity(){
		pos=getLocation();
		sprite=getSprite();
		
		
	}
	
	public abstract Sprite getSprite();
	public abstract Vector2 getLocation();
	public abstract void update();
	
	public void render(SpriteBatch sb){
		pos=getLocation();
		sprite=getSprite();
		sprite.setPosition(pos.x, pos.y);
		sprite.draw(sb);
	}
}
