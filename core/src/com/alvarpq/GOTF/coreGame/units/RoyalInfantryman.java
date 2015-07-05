package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class RoyalInfantryman extends Unit
{
	public RoyalInfantryman(int row, int column)
	{
		super("Royal Infantryman", 1, 2, 2, row, column);
	}
	@Override
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide)
	{
		super.updateUnits(mySide, opponentsSide);
		for(int i=0;i<mySide.numberOfColumns();i++)
		{
			if(i!=column&&mySide.getUnitAt(row, i)!=null)
			{
				mySide.getUnitAt(row, i).health++;
			}
		}
	}
}