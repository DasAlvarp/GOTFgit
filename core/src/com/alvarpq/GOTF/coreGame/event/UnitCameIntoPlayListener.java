package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when a unit has come into play.
 */
public interface UnitCameIntoPlayListener extends Listener
{
	/**
	 * The function called when a unit has came into play
	 * @param event the event with information about what happened
	 */
	public void onUnitCameIntoPlay(UnitCameIntoPlayEvent event);
}
