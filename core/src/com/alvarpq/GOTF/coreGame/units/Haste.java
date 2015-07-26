package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.event.UnitCameIntoPlayEvent;
public abstract class Haste
{
	public static void onUnitCameIntoPlay(UnitCameIntoPlayEvent event, Unit playedUnit)
	{
		if(event.getPlayedUnit()==playedUnit)
		{
			event.getMySide().getHalf().changeCountdown(playedUnit, -playedUnit.getCountdown());
		}
	}
}
