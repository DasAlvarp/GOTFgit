package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * For handling when units are killed by units.
 */
public class UnitKilledEvent extends Event
{
	/**
	 * The killed unit.
	 */
	private Unit killedUnit;
	/**
	 * Instantiates a new UnitDamagedByUnitEvent.
	 * @param killedUnit the unit that has been killed
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public UnitKilledEvent(Unit killedUnit, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.killedUnit = killedUnit;
	}
	/**
	 * Returns the killed unit.
	 * @return the killed unit
	 */
	public Unit getKilledUnit()
	{
		return killedUnit;
	}
}
