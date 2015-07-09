package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Presence;
public class ProudMercenary extends Unit
{
	public ProudMercenary(int row, int column)
	{
		super("Proud Mercenary", 2, 2, 3, 1, row, column);
	}
	@Override
	public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		for(Unit unit:myHalf.getUnits())
		{
			if(BoardHalf.isAdjacent(getRow(), getColumn(), unit.getRow(), unit.getColumn()))
			{
				unit.applyEffect(Presence.ATTACK_1);
			}
		}
	}
}