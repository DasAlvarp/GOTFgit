package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when units are killed.
 */
public interface UnitKilledListener extends Listener
{
	/**
	 * The function called when a unit is killed.
	 * @param event the event with information about what happened
	 */
	public void onUnitKilled(UnitKilledEvent event);
}
