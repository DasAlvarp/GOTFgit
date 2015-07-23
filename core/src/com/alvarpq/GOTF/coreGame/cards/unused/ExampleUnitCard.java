package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.ExampleUnit;
public class ExampleUnitCard extends UnitCard
{
	public ExampleUnitCard(Player owner)
	{
		super(100103, "Example Unit", 4, Arrays.asList(new Element[]{Element.AIR, Element.EARTH, Element.FIRE, Element.WATER}), owner, new UnitFactory(ExampleUnit.class));
	}
}
