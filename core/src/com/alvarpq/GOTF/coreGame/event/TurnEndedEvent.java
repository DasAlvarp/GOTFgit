package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
/**
 * For handling when the turn is ended.
 */
public class TurnEndedEvent extends Event
{
	/**
	 * Instantiates a new TurnEndedEvent.
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public TurnEndedEvent(Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
	}
}