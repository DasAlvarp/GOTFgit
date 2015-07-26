package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.VorgasClone;
public class VorgasCloneCard extends UnitCard
{
	public VorgasCloneCard(Player owner)
	{
		super(110115, "Vorgas' Clone", 2, new Element[]{Element.EARTH}, owner, new UnitFactory(VorgasClone.class));
	}
}
