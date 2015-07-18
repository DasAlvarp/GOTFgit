package com.alvarpq.GOTF.coreGame.units.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.effect.Presence;
import com.alvarpq.GOTF.coreGame.units.PresenceApplier;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class ProtectorOfWhales extends Unit implements PresenceApplier
{
	public ProtectorOfWhales(int row, int column)
	{
		super("Protector of Whales", 2, 2, 2, 1, true, new String[]{"Angel"}, row, column);
	}
	@Override
	public void applyPresence(Side mySide, Side opponentsSide)
	{
		for(Unit unit:mySide.getHalf().getUnits())
		{
			if(Arrays.asList(unit.getSubtypes()).contains("Whale"))
			{
				unit.applyEffect(Presence.UNTARGETABLE);
			}
		}
	}

	@Override
	public void update(){}
}
