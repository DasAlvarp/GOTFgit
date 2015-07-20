package com.alvarpq.GOTF.coreGame.units.unused;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedListener;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class TunnelGuard extends Unit implements UnitDamagedListener
{
	private int armorValue = 1;
	public TunnelGuard(int row, int column)
	{
		super("Tunnel Guard", null, 1, 2, 4, 1, true, new String[]{"Mulgoon", "Soldier"}, row, column);
	}
	@Override
	public void onUnitDamaged(UnitDamagedEvent event)
	{
		if(event.getDamagedUnit()==this&&armorValue>0)
		{
			//reverts damage
			heal(event.getAmount());
			armorValue--;
		}
	}
}
