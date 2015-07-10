package com.alvarpq.GOTF.coreGame.units.real;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.entity.AnimatedSprite;
public class DarkYounling extends Unit
{
	public DarkYounling(int row, int column)
	{
		super("Dark Youngling", 1, 1, 1, 1, true, new String[]{"Mulgoon"}, row, column);
	}
	@Override
	public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf){}
	@Override
	public AnimatedSprite getSprite(){return null;}
	@Override
	public void update(){}
}
