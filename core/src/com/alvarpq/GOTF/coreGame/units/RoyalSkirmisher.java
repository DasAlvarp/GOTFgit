package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class RoyalSkirmisher extends Unit
{
	public RoyalSkirmisher(int row, int column)
	{
		super("Royal Skirmisher", 3,2, 3, 1, row, column);
		this.setAttackType(AttackType.RELENTLESS);
	}
	@Override
	public void applyPresence(BoardHalf mySide, BoardHalf opponentsSide){}
}
