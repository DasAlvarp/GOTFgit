package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.VorgasAssasin;
public class VorgasAssasinCard extends UnitCard
{
	public VorgasAssasinCard(Player owner)
	{
		super(110112, "Vorgas' Assasin", 3, new Element[]{Element.EARTH, Element.EARTH}, owner, new UnitFactory(VorgasAssasin.class));
	}
}
