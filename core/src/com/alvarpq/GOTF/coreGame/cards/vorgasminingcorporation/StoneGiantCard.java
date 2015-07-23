package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.StoneGiant;
public class StoneGiantCard extends UnitCard
{
	public StoneGiantCard(Player owner)
	{
		super(110105, "Stone Giant", 4, Arrays.asList(new Element[]{Element.EARTH}), owner, new UnitFactory(StoneGiant.class));
	}
}
