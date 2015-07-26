package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinGuard;
public class GoblinGuardCard extends UnitCard
{
	public GoblinGuardCard(Player owner)
	{
		super(110101, "Goblin Guard", 2, new Element[]{Element.EARTH}, owner, new UnitFactory(GoblinGuard.class));
	}
}
