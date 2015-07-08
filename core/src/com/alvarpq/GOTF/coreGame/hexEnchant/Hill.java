package com.alvarpq.GOTF.coreGame.hexEnchant;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Presence;
public class Hill extends HexEnchantment
{
	public Hill(int row, int column)
	{
		super("Hill", row, column);
	}
	@Override
	public void applyPresence(BoardHalf mySide, BoardHalf opponentsSide)
	{
		if(mySide.getUnitAt(getRow(), getColumn())!=null)
		{
			mySide.getUnitAt(getRow(), getColumn()).applyEffect(Presence.HEALTH_2);
		}
	}
}
