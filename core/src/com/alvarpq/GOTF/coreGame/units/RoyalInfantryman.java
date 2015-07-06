package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Presence;
public class RoyalInfantryman extends Unit
{
	public RoyalInfantryman(int row, int column)
	{
		super("Royal Infantryman", 1, 2, 2, 1, row, column);
	}
	@Override
	public void applyPresence(BoardHalf mySide, BoardHalf opponentsSide)
	{
		for(int i=0;i<mySide.numberOfColumns();i++)
		{
			if(i!=getColumn()&&mySide.getUnitAt(getRow(), i)!=null)
			{
				mySide.getUnitAt(getRow(), i).applyEffect(Presence.HEALTH_1);
			}
		}
	}
}