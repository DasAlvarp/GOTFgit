package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Presence;
public class DucalInfantryman extends Unit
{
	public DucalInfantryman(int row, int column)
	{
		super("Ducal Infantryman", 1, 2, 3, 1, row, column);
	}
	@Override
	public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		for(int i=0;i<myHalf.numberOfColumns();i++)
		{
			if(i!=getColumn()&&myHalf.getUnitAt(getRow(), i)!=null)
			{
				myHalf.getUnitAt(getRow(), i).applyEffect(Presence.ATTACK_1);
			}
		}
	}
}