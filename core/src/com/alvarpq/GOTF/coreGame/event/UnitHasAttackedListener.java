package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when a unit has attacked.
 */
public interface UnitHasAttackedListener extends Listener
{
	/**
	 * The function called when a unit has attacked.
	 * @param event the event with information about what happened
	 */
	public void onUnitHasAttacked(UnitHasAttackedEvent event);
}
