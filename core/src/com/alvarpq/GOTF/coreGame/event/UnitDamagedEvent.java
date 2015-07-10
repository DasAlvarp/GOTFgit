package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitDamagedEvent extends UnitEvent
{
	private Unit damagedUnit;
	private int amount;
	public UnitDamagedEvent(Unit damagedUnit, int amount, BoardHalf mySide, BoardHalf opponentsSide)
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