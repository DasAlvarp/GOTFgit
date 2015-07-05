package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public class DucalInfantryman extends Unit
{
	public DucalInfantryman(int row, int column)
	{
		super("Ducal Infantryman", 1, 2, 3, 1, row, column);
	}
	@Override
	public void updateUnits(BoardHalf mySide, BoardHalf opponentsSide)
	{
		super.updateUnits(mySide, opponentsSide);
		for(int i=0;i<mySide.numberOfColumns();i++)
		{
			if(i!=getColumn()&&mySide.getUnitAt(getRow(), i)!=null)
			{
				mySide.getUnitAt(getRow(), i).updateAttack(1);
			}
		}
	}
}
