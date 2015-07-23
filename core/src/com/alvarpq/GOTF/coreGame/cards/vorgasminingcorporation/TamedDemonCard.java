package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.TamedDemon;
public class TamedDemonCard extends UnitCard
{
	public TamedDemonCard()
	{
		super(110106, "Tamed Demon", 4, Arrays.asList(new Element[]{Element.EARTH, Element.FIRE}), new UnitFactory(TamedDemon.class));
	}
}
