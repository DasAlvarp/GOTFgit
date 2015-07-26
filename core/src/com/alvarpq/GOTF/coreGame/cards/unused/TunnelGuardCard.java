package com.alvarpq.GOTF.coreGame.cards.unused;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.TunnelGuard;
public class TunnelGuardCard extends UnitCard
{
	public TunnelGuardCard(Player owner)
	{
		super(100107, "Tunnel Guard", 3, new Element[]{Element.EARTH}, owner, new UnitFactory(TunnelGuard.class));
	}
}
