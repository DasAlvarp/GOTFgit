package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when units are damaged.
 */
public interface UnitDamagedListener extends Listener
{
	/**
	 * The function called when a unit is damaged.
	 * @param event the event with information about what happened
	 */
	public void onUnitDamaged(UnitDamagedEvent event);
}