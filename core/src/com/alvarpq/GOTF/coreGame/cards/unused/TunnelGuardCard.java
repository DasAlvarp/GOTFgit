package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.TunnelGuard;
public class TunnelGuardCard extends UnitCard
{
	public TunnelGuardCard()
	{
		super(100108, "Tunnel Guard", 3, Arrays.asList(new Element[]{Element.EARTH}), new UnitFactory(TunnelGuard.class));
	}
}
