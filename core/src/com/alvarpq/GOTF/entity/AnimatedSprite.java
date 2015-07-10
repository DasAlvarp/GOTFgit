package com.alvarpq.GOTF.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class AnimatedSprite {
	int currentFrame;
	int tick;
	int framesPer;
	int frames;
	boolean still=false;
	ArrayList<Sprite> sprites;
	public AnimatedSprite(int framesPer, ArrayList<Sprite> sprites){
		tick=0;
		currentFrame=0;
		frames=sprites.size();
		this.sprites=sprites;

		this.framesPer=framesPer;
	}
	
	public AnimatedSprite(int framesPer, Sprite... sprites){
		this.sprites=new ArrayList<Sprite>();
		for(int k=0;k<sprites.length;k++){
			this.sprites.add(sprites[k]);
		}
		tick=0;
		currentFrame=0;
		frames=sprites.length;
		

		this.framesPer=framesPer;
	}
	
	public AnimatedSprite(Sprite s){
		still=true;
		sprites=new ArrayList<Sprite>();
		sprites.add(s);
		currentFrame=0;
	}
	
	//Changes the frame of other
	public void syncFrameWith(AnimatedSprite other){
		other.jumpToFrame(currentFrame);
		tick=0;
	}
	
	public void jumpToFrame(int frame){
		currentFrame=frame;
		tick=0;
	}
	public Sprite getCurrentFrame(){
		return sprites.get(currentFrame);
	}
	
	public void update(){
		if(framesPer>0 && !still){
		tick=(tick+1)%framesPer;
		if(tick==0){
			currentFrame=(currentFrame+1)%frames;
		}
		}
	}
}
