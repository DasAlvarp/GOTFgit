package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * For handling when units have attacked.
 */
public class UnitHasAttackedEvent extends Event
{
	/**
	 * The unit that attacked.
	 */
	private Unit attackUnit;
	/**
	 * Instantiates a new UnitHasAttackedEvent.
	 * @param damagedUnit the unit that has been damaged
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public UnitHasAttackedEvent(Unit attackUnit, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.attackUnit = attackUnit;
	}
	/**
	 * Returns the unit that attacked.
	 * @return the unit that attacked
	 */
	public Unit getAttackUnit()
	{
		return attackUnit;
	}
}