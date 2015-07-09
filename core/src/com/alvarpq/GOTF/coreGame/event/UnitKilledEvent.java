package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitKilledEvent extends UnitEvent
{
	private Unit killedUnit;
	public UnitKilledEvent(Unit killedUnit, BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		super(myHalf, opponentsHalf);
		this.killedUnit = killedUnit;
	}
	public Unit getKilledUnit()
	{
		return killedUnit;
	}
}
