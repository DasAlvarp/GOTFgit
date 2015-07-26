package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when the turn is ended.
 */
public interface EndTurnListener
{
	/**
	 * The function called when the turn is ended.
	 */
	public void onTurnEnded();
}
