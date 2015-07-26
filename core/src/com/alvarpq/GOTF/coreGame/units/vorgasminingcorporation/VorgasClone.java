package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.event.UnitCameIntoPlayEvent;
import com.alvarpq.GOTF.coreGame.event.UnitCameIntoPlayListener;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedListener;
import com.alvarpq.GOTF.coreGame.units.Coward;
import com.alvarpq.GOTF.coreGame.units.Haste;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class VorgasClone extends Unit implements UnitHasAttackedListener, UnitCameIntoPlayListener
{
	public VorgasClone(int row, int column)
	{
		super("Vorgas' Clone", null, 1, 2, 1, 1, true, new String[]{"Goblin"}, row, column);
	}
	@Override
	public void onUnitHasAttacked(UnitHasAttackedEvent event)
	{
		Coward.onUnitHasAttacked(event, this);
	}
	@Override
	public void onUnitCameIntoPlay(UnitCameIntoPlayEvent event)
	{
		Haste.onUnitCameIntoPlay(event, this);
	}
}
