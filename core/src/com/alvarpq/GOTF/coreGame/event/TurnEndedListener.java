package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when the turn is ended.
 */
public interface TurnEndedListener extends Listener
{
	/**
	 * The function called when the turn is ended.
	 * @param event the event with information about what happened
	 */
	public void onTurnEnded(TurnEndedEvent event);
}
