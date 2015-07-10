package com.alvarpq.GOTF.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class AnimatedSprite {
	int currentFrame;
	int framesPer;
	int frames;
	boolean still = false;
	ArrayList<Sprite> sprites;
	
	long lastTime;
	long timePassed;
	long millisecondsPerFrame = 50;
	
	//A bunch of different constructors to create sprites. The update method should be called every frame.
	public AnimatedSprite(int framesPer, ArrayList<Sprite> sprites)
	{
		currentFrame=0;
		frames = sprites.size();
		this.sprites=sprites;

		this.framesPer=framesPer;
		
		lastTime = System.currentTimeMillis();
		timePassed = 0;
	}
	
	//constructor 'n' stuff.
	public AnimatedSprite(int framesPer, Sprite... sprites)
	{
		this.sprites = new ArrayList<Sprite>();
		for(int k = 0; k < sprites.length; k++)
		{
			this.sprites.add(sprites[k]);
		}
		currentFrame = 0;
		frames = sprites.length;
		

		this.framesPer=framesPer;
	}
	
	//see above
	public AnimatedSprite(Sprite s)
	{
		still = true;
		sprites = new ArrayList<Sprite>();
		sprites.add(s);
		currentFrame = 0;
	}
	
	
	//sets size of self.
	public void setSize(int width, int height)
	{
		for(Sprite s:sprites)
		{
			s.setSize(width, height);
		}
	}
	
	
	
	//Changes the frame of other
	public void syncFrameWith(AnimatedSprite other){
		other.jumpToFrame(currentFrame);
		timePassed = 0;
	}
	
	public void jumpToFrame(int frame){
		currentFrame=frame;
		timePassed = 0;
	}
	public Sprite getCurrentFrame(){
		return sprites.get(currentFrame);
	}
	
	public void update()
	{
		timePassed = System.currentTimeMillis() - lastTime;
		
	//	if(framesPer > 0 && !still)
	//	{
	//		tick = (tick+1) % framesPer;
			if(timePassed > millisecondsPerFrame && !still)
			{
				currentFrame = (currentFrame + 1) % frames;
				lastTime = System.currentTimeMillis();

			}
	//	}
	}
}
