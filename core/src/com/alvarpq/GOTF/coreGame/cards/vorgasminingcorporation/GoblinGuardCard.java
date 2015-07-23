package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinGuard;
public class GoblinGuardCard extends UnitCard
{
	public GoblinGuardCard()
	{
		super(110101, "Goblin Guard", 2, Arrays.asList(new Element[]{Element.EARTH}), new UnitFactory(GoblinGuard.class));
	}
}
