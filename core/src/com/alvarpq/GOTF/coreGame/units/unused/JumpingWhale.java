package com.alvarpq.GOTF.coreGame.units.unused;
import com.alvarpq.GOTF.coreGame.units.MoveType;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class JumpingWhale extends Unit
{
	public JumpingWhale(int row, int column)
	{
		super("Jumping Whale", 3, 2, 3, 1, true, new String[]{"Whale"}, row, column);
		setMoveType(new MoveType.NonAdjacent());
	}

	@Override
	public void update(){}
}
