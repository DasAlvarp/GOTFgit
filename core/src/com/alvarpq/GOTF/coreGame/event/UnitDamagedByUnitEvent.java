package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitDamagedByUnitEvent extends UnitEvent
{
	private Unit damagedUnit;
	private Unit damager;
	private int amount;
	public UnitDamagedByUnitEvent(Unit damagedUnit, Unit damager, int amount, BoardHalf mySide, BoardHalf opponentsSide)
	{
		super(mySide, opponentsSide);
		this.damagedUnit = damagedUnit;
		this.damager = damager;
		this.amount = amount;
	}
	public Unit getDamagedUnit()
	{
		return damagedUnit;
	}
	public Unit getDamager()
	{
		return damager;
	}
	public int getAmount()
	{
		return amount;
	}
}