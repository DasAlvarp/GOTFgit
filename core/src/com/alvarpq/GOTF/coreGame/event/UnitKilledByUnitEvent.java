package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitKilledByUnitEvent extends UnitEvent
{
	private Unit killedUnit;
	private Unit killer;
	public UnitKilledByUnitEvent(Unit killedUnit, Unit killer, BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		super(myHalf, opponentsHalf);
		this.killedUnit = killedUnit;
		this.killer = killer;
	}
	public Unit getKilledUnit()
	{
		return killedUnit;
	}
	public Unit getKiller()
	{
		return killer;
	}
}
