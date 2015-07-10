package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.units.TunnelGuard;
public class TunnelGuardCard extends UnitCard
{
	public TunnelGuardCard()
	{
		super("Tunnel Guard", 3, new Resource[]{Resource.EARTH}, new UnitFactory(TunnelGuard.class));
	}
}
