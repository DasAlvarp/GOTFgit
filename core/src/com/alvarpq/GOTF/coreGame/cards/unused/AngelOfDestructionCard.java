package com.alvarpq.GOTF.coreGame.cards.unused;

import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.AngelOfDestruction;

public class AngelOfDestructionCard extends UnitCard
{
	
	public AngelOfDestructionCard()
	{
		super(100101, "Angel Of Destruction", 5, Arrays.asList(new Resource[]{Resource.AIR, Resource.FIRE}), new UnitFactory(AngelOfDestruction.class));
	}
}
