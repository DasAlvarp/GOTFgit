package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when idols are damaged by units.
 */
public interface IdolDamagedByUnitListener extends Listener
{
	/**
	 * The function called when an idol is damaged by a a unit.
	 * @param event the event with information about what happened
	 */
	public void onIdolDamagedByUnit(IdolDamagedByUnitEvent event);
}