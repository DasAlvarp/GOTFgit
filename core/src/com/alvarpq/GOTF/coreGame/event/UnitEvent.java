package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public abstract class UnitEvent
{
	private BoardHalf myHalf;
	private BoardHalf opponentsHalf;
	public UnitEvent(BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		this.myHalf = myHalf;
		this.opponentsHalf = opponentsHalf;
	}
	public BoardHalf getmyHalf()
	{
		return myHalf;
	}
	public BoardHalf getopponentsHalf()
	{
		return opponentsHalf;
	}
	public void invertSides()
	{
		BoardHalf temp = myHalf;
		myHalf = opponentsHalf;
		opponentsHalf = temp;
	}
}
