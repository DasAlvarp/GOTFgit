package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitKilledEvent extends UnitEvent
{
	private Unit killedUnit;
	public UnitKilledEvent(Unit killedUnit, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.killedUnit = killedUnit;
	}
	public Unit getKilledUnit()
	{
		return killedUnit;
	}
}
