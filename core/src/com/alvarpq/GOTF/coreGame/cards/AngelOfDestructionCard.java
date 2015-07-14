package com.alvarpq.GOTF.coreGame.cards;

import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.units.real.AngelOfDestruction;

public class AngelOfDestructionCard extends UnitCard
{
	
	public AngelOfDestructionCard()
	{
		super(10006, "Angel Of Destruction", 5, new Resource[]{Resource.AIR, Resource.FIRE}, new UnitFactory(AngelOfDestruction.class));
	}
}
