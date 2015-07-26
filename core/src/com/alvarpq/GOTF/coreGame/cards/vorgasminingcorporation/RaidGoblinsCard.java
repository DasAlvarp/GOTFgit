package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.RaidGoblins;
public class RaidGoblinsCard extends UnitCard
{
	public RaidGoblinsCard(Player owner)
	{
		super(110114, "Raid Goblins", 4, new Element[]{Element.EARTH, Element.EARTH, Element.EARTH}, owner, new UnitFactory(RaidGoblins.class));
	}
}
