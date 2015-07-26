package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * For handling when units come into play.
 */
public class UnitCameIntoPlayEvent extends Event
{
	/**
	 * The unit that came into play.
	 */
	private Unit playedUnit;
	/**
	 * Instantiates a new UnitCameIntoPlayEvent.
	 * @param playedUnit the unit that has been damaged
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public UnitCameIntoPlayEvent(Unit playedUnit, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.playedUnit = playedUnit;
	}
	/**
	 * Returns the unit that came into play.
	 * @return the unit that came into play
	 */
	public Unit getPlayedUnit()
	{
		return playedUnit;
	}
}