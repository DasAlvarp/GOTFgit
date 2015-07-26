package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinGeologist;
public class GoblinGeologistCard extends UnitCard
{
	public GoblinGeologistCard(Player owner)
	{
		super(110111, "Goblin Geologist", 2, new Element[]{Element.EARTH}, owner, new UnitFactory(GoblinGeologist.class));
	}
}
