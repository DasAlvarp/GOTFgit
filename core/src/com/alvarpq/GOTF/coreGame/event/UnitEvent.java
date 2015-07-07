package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public abstract class UnitEvent
{
	private BoardHalf mySide;
	private BoardHalf opponentsSide;
	public UnitEvent(BoardHalf mySide, BoardHalf opponentsSide)
	{
		this.mySide = mySide;
		this.opponentsSide = opponentsSide;
	}
	public BoardHalf getMySide()
	{
		return mySide;
	}
	public void setMySide(BoardHalf mySide)
	{
		this.mySide = mySide;
	}
	public BoardHalf getOpponentsSide()
	{
		return opponentsSide;
	}
	public void setOpponentsSide(BoardHalf opponentsSide)
	{
		this.opponentsSide = opponentsSide;
	}
	public void invertSides()
	{
		BoardHalf temp = mySide;
		mySide = opponentsSide;
		opponentsSide = temp;
	}
}
