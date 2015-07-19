package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinGuard;
public class GoblinGuardCard extends UnitCard
{
	public GoblinGuardCard()
	{
		super(110104, "Goblin Guard", 2, Arrays.asList(new Resource[]{Resource.EARTH}), new UnitFactory(GoblinGuard.class));
	}
}
