package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinPyromancer;
public class GoblinPyromancerCard extends UnitCard
{
	public GoblinPyromancerCard()
	{
		super(110109, "Goblin Pyromancer", 3, Arrays.asList(new Element[]{Element.EARTH, Element.FIRE}), new UnitFactory(GoblinPyromancer.class));
	}
}
