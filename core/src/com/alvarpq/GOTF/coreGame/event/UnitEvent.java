package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
public abstract class UnitEvent
{
	private Side mySide;
	private Side opponentsSide;
	public UnitEvent(Side mySide, Side opponentsSide)
	{
		this.mySide = mySide;
		this.opponentsSide = opponentsSide;
	}
	public Side getMySide()
	{
		return mySide;
	}
	public Side getOpponentsSide()
	{
		return opponentsSide;
	}
	public void invertSides()
	{
		Side temp = mySide;
		mySide = opponentsSide;
		opponentsSide = temp;
	}
}