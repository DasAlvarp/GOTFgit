package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.RedDevil;
public class RedDevilCard extends UnitCard
{
	public RedDevilCard(Player owner)
	{
		super(110104, "Red Devil", 1, new Element[]{Element.EARTH}, owner, new UnitFactory(RedDevil.class));
	}
}
