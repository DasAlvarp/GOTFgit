package com.alvarpq.GOTF.coreGame.hexEnchant;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.effect.Presence;
public class Hill extends HexEnchantment
{
	public Hill(int row, int column)
	{
		super("Hill", row, column);
	}
	@Override
	public void applyPresence(Side mySide, Side opponentsSide)
	{
		if(mySide.getHalf().getUnitAt(getRow(), getColumn())!=null)
		{
			mySide.getHalf().getUnitAt(getRow(), getColumn()).applyEffect(Presence.HEALTH_2);
		}
	}
}
