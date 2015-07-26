package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedListener;
import com.alvarpq.GOTF.coreGame.units.Coward;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class VorgasEliteUnit extends Unit implements UnitHasAttackedListener
{
	public VorgasEliteUnit(int row, int column)
	{
		super("Vorgas' Elite Unit", null, 3, 1, 1, 1, true, new String[]{"Goblin"}, row, column);
	}
	@Override
	public void onUnitHasAttacked(UnitHasAttackedEvent event)
	{
		Coward.onUnitHasAttacked(event, this);
	}
}
