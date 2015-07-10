package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitDamagedEvent extends UnitEvent
{
	private Unit damagedUnit;
	private int amount;
	public UnitDamagedEvent(Unit damagedUnit, int amount, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.damagedUnit = damagedUnit;
		this.amount = amount;
	}
	public Unit getDamagedUnit()
	{
		return damagedUnit;
	}
	public int getAmount()
	{
		return amount;
	}	
}