package com.alvarpq.GOTF.coreGame.cards.temp;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.temp.TunnelGuard;
public class TunnelGuardCard extends UnitCard
{
	public TunnelGuardCard()
	{
		super(10005, "Tunnel Guard", 3, new Resource[]{Resource.EARTH}, new UnitFactory(TunnelGuard.class));
	}
}
