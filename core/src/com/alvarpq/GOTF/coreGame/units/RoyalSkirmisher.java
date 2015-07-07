package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class RoyalSkirmisher extends Unit
{
	public RoyalSkirmisher(int row, int column)
	{
		super("Royal Skirmisher", 3,2, 3, 1, row, column);
		this.setAttackType(AttackType.RELENTLESS);
	}
	@Override
<<<<<<< HEAD
	public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf){}
=======
	public void applyPresence(BoardHalf mySide, BoardHalf opponentsSide){}
	
	public Texture getTexture(){
		Texture f1=new Texture(Gdx.files.internal("animFrame1.png"));
		Texture f2=new Texture(Gdx.files.internal("animFrame2.png"));
		Texture[] anim={f1,f2};
		return anim[frame];
	}
	@Override
	public void update() {
		double rand=Math.random();
		if(rand>.98){
			frame=1-frame;
		}
		
	}
>>>>>>> Stuff.
}
