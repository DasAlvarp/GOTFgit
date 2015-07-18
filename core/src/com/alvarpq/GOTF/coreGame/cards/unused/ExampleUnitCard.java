package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.ExampleUnit;
public class ExampleUnitCard extends UnitCard
{
	public ExampleUnitCard()
	{
		super(100104, "Example Unit", 4, Arrays.asList(new Resource[]{Resource.AIR, Resource.EARTH, Resource.FIRE, Resource.WATER}), new UnitFactory(ExampleUnit.class));
	}
}
