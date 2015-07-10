package com.alvarpq.GOTF.coreGame.units.real;
import com.alvarpq.GOTF.coreGame.units.MoveType;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.entity.AnimatedSprite;
public class JumpingWhale extends Unit
{
	public JumpingWhale(int row, int column)
	{
		super("Jumping Whale", 3, 2, 3, 1, true, new String[]{"Whale"}, row, column);
		setMoveType(MoveType.NOT_ADJACENT);
	}
	@Override
	public AnimatedSprite getSprite(){return null;}
	@Override
	public void update(){}
}
