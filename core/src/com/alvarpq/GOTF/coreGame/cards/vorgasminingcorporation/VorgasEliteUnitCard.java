package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.VorgasEliteUnit;
public class VorgasEliteUnitCard extends UnitCard
{
	public VorgasEliteUnitCard(Player owner)
	{
		super(110113, "Vorgas' Elite Unit", 3, new Element[]{Element.EARTH}, owner, new UnitFactory(VorgasEliteUnit.class));
	}
}
