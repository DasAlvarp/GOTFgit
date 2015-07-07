package com.alvarpq.GOTF.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Vector2 pos;
	protected Texture texture;
	public Entity(Vector2 pos){
		this.pos=pos;
		texture=getTexture();
		
	}
	
	public abstract Texture getTexture();
	public abstract void update();
	
	public void render(SpriteBatch sb){
		sb.draw(texture, pos.x,pos.y);
	}
}
