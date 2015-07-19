package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
/**
 * The superclass of all unit related events.
 */
public abstract class UnitEvent
{
	/**
	 * The side of the event receiver.
	 */
	private Side mySide;
	/**
	 * The opponents side of the event receiver.
	 */
	private Side opponentsSide;
	/**
	 * Instantiates a new UnitEvent.
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public UnitEvent(Side mySide, Side opponentsSide)
	{
		this.mySide = mySide;
		this.opponentsSide = opponentsSide;
	}
	/**
	 * Returns the side of the event receiver.
	 * @return the side of the event receiver
	 */
	public Side getMySide()
	{
		return mySide;
	}
	/**
	 * Returns the opponents side of the event receiver.
	 * @return the opponents side of the event receiver
	 */
	public Side getOpponentsSide()
	{
		return opponentsSide;
	}
	/**
	 * Inverts my side and opponents side.
	 */
	public void invertSides()
	{
		Side temp = mySide;
		mySide = opponentsSide;
		opponentsSide = temp;
	}
}