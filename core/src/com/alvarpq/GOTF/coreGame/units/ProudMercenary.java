package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Presence;
import com.alvarpq.GOTF.entity.AnimatedSprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
public class ProudMercenary extends Unit
{
	public ProudMercenary(int row, int column)
	{
		super("Proud Mercenary", 2, 2, 3, 1, row, column);
		
		Sprite f1= new Sprite(new Texture(Gdx.files.internal("animFrame1.png")));
		Sprite f2= new Sprite(new Texture(Gdx.files.internal("animFrame2.png")));
		f1.setSize(50,90);
		f2.setSize(50,90);
		anim=new AnimatedSprite(30,f1,f2);
	}
	@Override
	public void applyPresence(BoardHalf mySide, BoardHalf opponentsSide)
	{
		for(Unit unit:mySide.getUnits())
		{
			if(BoardHalf.isAdjacent(getRow(), getColumn(), unit.getRow(), unit.getColumn()))
			{
				unit.applyEffect(Presence.ATTACK_1);
			}
		}
	}
	public AnimatedSprite getSprite(){

		return anim;
		
	}
	@Override
	public void update() {

		
	}
}