package com.alvarpq.GOTF.coreGame.hexEnchant;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.effect.Presence;
import com.alvarpq.GOTF.coreGame.units.PresenceApplier;
public class ExampleHexEnchantment extends HexEnchantment implements PresenceApplier
{
	public ExampleHexEnchantment(int row, int column)
	{
		super("Hill", row, column);
	}
	@Override
	public void applyPresence(Side mySide, Side opponentsSide)
	{
		if(mySide.getHalf().getUnitAt(getRow(), getColumn())!=null)
		{
			mySide.getHalf().getUnitAt(getRow(), getColumn()).applyEffect(Presence.ATTACK_1);
		}
	}
}
