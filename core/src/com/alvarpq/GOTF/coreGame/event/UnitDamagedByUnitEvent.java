package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * For handling when units are damaged by units.
 */
public class UnitDamagedByUnitEvent extends Event
{
	/**
	 * The damaged unit.
	 */
	private Unit damagedUnit;
	/**
	 * The damager.
	 */
	private Unit damager;
	/**
	 * The amount of damage.
	 */
	private int amount;
	/**
	 * Instantiates a new UnitDamagedByUnitEvent.
	 * @param damagedUnit the unit that has been damaged
	 * @param damager the unit that dealt the damage
	 * @param amount the amount of damage dealt
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public UnitDamagedByUnitEvent(Unit damagedUnit, Unit damager, int amount, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.damagedUnit = damagedUnit;
		this.damager = damager;
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
	 * Returns the damager.
	 * @return the damager
	 */
	public Unit getDamager()
	{
		return damager;
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