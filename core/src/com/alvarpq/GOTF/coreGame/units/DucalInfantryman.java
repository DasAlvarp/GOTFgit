package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class DucalInfantryman extends Unit
{
	public DucalInfantryman(int row, int column)
	{
		super("Ducal Infantryman", 1, 2, 3, row, column);
	}
	@Override
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide)
	{
		super.updateUnits(mySide, opponentsSide);
		for(int i=0;i<mySide.numberOfColumns();i++)
		{
			if(i!=column&&mySide.getUnitAt(row, i)!=null)
			{
				mySide.getUnitAt(row, i).attack++;
			}
		}
	}
}
