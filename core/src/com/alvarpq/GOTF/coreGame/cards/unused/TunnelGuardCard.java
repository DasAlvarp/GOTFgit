package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.TunnelGuard;
public class TunnelGuardCard extends UnitCard
{
	public TunnelGuardCard()
	{
		super(100108, "Tunnel Guard", 3, Arrays.asList(new Resource[]{Resource.EARTH}), new UnitFactory(TunnelGuard.class));
	}
}
