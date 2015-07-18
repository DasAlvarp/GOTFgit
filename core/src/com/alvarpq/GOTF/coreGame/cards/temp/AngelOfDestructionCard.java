package com.alvarpq.GOTF.coreGame.cards.temp;

import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.temp.AngelOfDestruction;

public class AngelOfDestructionCard extends UnitCard
{
	
	public AngelOfDestructionCard()
	{
		super(10006, "Angel Of Destruction", 5, new Resource[]{Resource.AIR, Resource.FIRE}, new UnitFactory(AngelOfDestruction.class));
	}
}
