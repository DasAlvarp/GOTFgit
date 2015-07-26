package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when units are damaged by units.
 */
public interface UnitDamagedByUnitListener extends Listener
{
	/**
	 * The function called when a unit is damaged by a a unit.
	 * @param event the event with information about what happened
	 */
	public void onUnitDamagedByUnit(UnitDamagedByUnitEvent event);
}