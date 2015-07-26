package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.event.IdolDamagedByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.IdolDamagedByUnitListener;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class GoblinMiner extends Unit implements IdolDamagedByUnitListener
{
	public GoblinMiner(int row, int column)
	{
		super("Goblin Miner", null, 1, 2, 1, 1, true, new String[]{"Goblin, Miner"}, row, column);
	}
	@Override
	public void onIdolDamagedByUnit(IdolDamagedByUnitEvent event)
	{
		if(event.getDamager()==this)
		{
			event.getMySide().setMaximumResources(event.getMySide().getMaximumResources()+1);
			event.getMySide().getMaximumElements().add(Element.EARTH);
		}
	}
}
