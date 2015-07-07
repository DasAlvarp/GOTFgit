package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Permanent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
public class IlmireRotEater extends Unit implements UnitKilledListener
{
	public IlmireRotEater(int row, int column)
	{
		super("Ilmire Rot Eater", 3, 2, 3, 1, row, column);
	}
	@Override public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf){}
	@Override
	public void onUnitKilled(UnitKilledEvent event)
	{
		if(event.getKilledUnit().getOwner()==getOwner()&&BoardHalf.isAdjacent(getRow(), getColumn(), event.getKilledUnit().getRow(), event.getKilledUnit().getColumn()))
		{
			this.applyEffect(Permanent.ATTACK_HEALTH_1);
		}
	}

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
}
