package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedListener;
import com.alvarpq.GOTF.coreGame.units.Coward;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class RaidGoblins extends Unit implements UnitHasAttackedListener
{
	public RaidGoblins(int row, int column)
	{
		super("Raid Goblins", null, 4, 1, 3, 1, true, new String[]{"Goblin, Soldier"}, row, column);
	}
	@Override
	public void onUnitHasAttacked(UnitHasAttackedEvent event)
	{
		Coward.onUnitHasAttacked(event, this);
	}
}
