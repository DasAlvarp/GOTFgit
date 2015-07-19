package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * For handling when units are damaged.
 */
public class UnitDamagedEvent extends UnitEvent
{
	/**
	 * The damaged unit.
	 */
	private Unit damagedUnit;
	/**
	 * The amount of damage.
	 */
	private int amount;
	/**
	 * Instantiates a new UnitDamagedByUnitEvent.
	 * @param damagedUnit the unit that has been damaged
	 * @param amount the amount of damage dealt
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public UnitDamagedEvent(Unit damagedUnit, int amount, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.damagedUnit = damagedUnit;
		this.amount = amount;
	}
	/**
	 * Returns the damaged unit.
	 * @return the damged unit
	 */
	public Unit getDamagedUnit()
	{
		return damagedUnit;
	}
	/**
	 * Returns the amount of damage.
	 * @return the amount of damage
	 */
	public int getAmount()
	{
		return amount;
	}
}