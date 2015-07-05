package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class ProudMercenary extends Unit
{
	public ProudMercenary(int row, int column)
	{
		super("Proud Mercenary", 2, 2, 3, 1, row, column);
	}
	@Override
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide)
	{
		super.updateUnits(mySide, opponentsSide);
		for(Unit unit:mySide.getUnits())
		{
			if(BoardHalf.isAdjacent(getRow(), getColumn(), unit.getRow(), unit.getColumn()))
			{
				unit.updateAttack(1);
			}
		}
	}
}