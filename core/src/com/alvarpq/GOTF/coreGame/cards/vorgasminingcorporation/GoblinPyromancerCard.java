package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinPyromancer;
public class GoblinPyromancerCard extends UnitCard
{
	public GoblinPyromancerCard()
	{
		super(210109, "Goblin Pyromancer", 3, Arrays.asList(new Resource[]{Resource.EARTH, Resource.FIRE}), new UnitFactory(GoblinPyromancer.class));
	}
}
