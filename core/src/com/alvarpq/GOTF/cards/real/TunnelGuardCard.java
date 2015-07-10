package com.alvarpq.GOTF.cards.real;
import com.alvarpq.GOTF.cards.UnitCard;
import com.alvarpq.GOTF.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.units.real.TunnelGuard;
public class TunnelGuardCard extends UnitCard
{
	public TunnelGuardCard()
	{
		super("Tunnel Guard", 3, new Resource[]{Resource.EARTH}, new UnitFactory(TunnelGuard.class));
	}
}
