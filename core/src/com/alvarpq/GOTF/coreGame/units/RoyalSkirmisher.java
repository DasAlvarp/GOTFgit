package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.entity.AnimatedSprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class RoyalSkirmisher extends Unit
{
	public RoyalSkirmisher(int row, int column)
	{
		super("Royal Skirmisher", 3,2, 3, 1, row, column);
		this.setAttackType(AttackType.RELENTLESS);
		
		//Set sprite stuff here
		Sprite f1= new Sprite(new Texture(Gdx.files.internal("animFrame1.png")));
		Sprite f2= new Sprite(new Texture(Gdx.files.internal("animFrame2.png")));
		f1.setSize(50,90);
		f2.setSize(50,90);
		anim=new AnimatedSprite(30,f1,f2);
	}
	@Override
	public void applyPresence(BoardHalf mySide, BoardHalf opponentsSide){}
	
	public AnimatedSprite getSprite(){

		return anim;
		
	}
	@Override
	public void update() {

		
	}
}
