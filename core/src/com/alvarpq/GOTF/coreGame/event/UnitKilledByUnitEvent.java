package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * For handling when units are killed.
 */
public class UnitKilledByUnitEvent extends Event
{
	/**
	 * The killed unit.
	 */
	private Unit killedUnit;
	/**
	 * The killer.
	 */
	private Unit killer;
	/**
	 * Instantiates a new UnitDamagedByUnitEvent.
	 * @param killedUnit the unit that has been killed
	 * @param killer the unit that killed the killed unit
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public UnitKilledByUnitEvent(Unit killedUnit, Unit killer, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.killedUnit = killedUnit;
		this.killer = killer;
	}
	/**
	 * Returns the killed unit.
	 * @return the killed unit
	 */
	public Unit getKilledUnit()
	{
		return killedUnit;
	}
	/**
	 * Returns the killer.
	 * @return the killer
	 */
	public Unit getKiller()
	{
		return killer;
	}
}
