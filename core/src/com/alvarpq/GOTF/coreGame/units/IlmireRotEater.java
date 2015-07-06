package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Permanent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledListener;
public class IlmireRotEater extends Unit implements UnitKilledListener
{
	public IlmireRotEater(int row, int column)
	{
		super("Ilmire Rot Eater", 3, 2, 3, 1, row, column);
	}
	@Override public void applyPresence(BoardHalf mySide, BoardHalf opponentsSide){}
	@Override
	public void onUnitKilled(UnitKilledEvent event)
	{
		if(event.getKilledUnit().getOwner()==getOwner()&&BoardHalf.isAdjacent(getRow(), getColumn(), event.getKilledUnit().getRow(), event.getKilledUnit().getColumn()))
		{
			this.applyEffect(Permanent.ATTACK_HEALTH_1);
		}
	}
}
