package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class KinfolkBrave extends Unit
{
	public KinfolkBrave(int row, int column)
	{
		super("Kinfolk Brave", 2, 1, 2, 1, row, column);
	}
	@Override
	public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf){}
}
