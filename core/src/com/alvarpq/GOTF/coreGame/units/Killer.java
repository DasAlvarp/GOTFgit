package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitEvent;
public abstract class Killer
{
	public static void onUnitDamagedByUnit(UnitDamagedByUnitEvent event, Unit killerUnit)
	{
		if(event.getDamager()==killerUnit)
		{
			event.getOpponentsSide().getHalf().destroyUnit(event.getDamagedUnit());
		}
	}
}
