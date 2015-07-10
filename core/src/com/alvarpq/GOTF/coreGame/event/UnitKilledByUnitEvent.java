package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitKilledByUnitEvent extends UnitEvent
{
	private Unit killedUnit;
	private Unit killer;
	public UnitKilledByUnitEvent(Unit killedUnit, Unit killer, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
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
