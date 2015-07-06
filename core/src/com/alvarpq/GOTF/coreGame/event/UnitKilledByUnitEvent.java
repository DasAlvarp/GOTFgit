package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitKilledByUnitEvent extends UnitEvent
{
	private Unit killedUnit;
	private Unit killer;
	public UnitKilledByUnitEvent(Unit killedUnit, Unit killer, BoardHalf mySide, BoardHalf opponentsSide)
	{
		super(mySide, opponentsSide);
		this.killedUnit = killedUnit;
		this.killer = killer;
	}
	public Unit getKilledUnit()
	{
		return killedUnit;
	}
	public void setKilledUnit(Unit killedUnit)
	{
		this.killedUnit = killedUnit;
	}
	public Unit getKiller()
	{
		return killer;
	}
	public void setKiller(Unit killer)
	{
		this.killer = killer;
	}
	
}
