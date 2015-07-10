package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.units.ExampleUnit;
public class ExampleUnitCard extends UnitCard
{
	public ExampleUnitCard()
	{
		super("Example Unit Card", 4, new Resource[]{Resource.AIR, Resource.EARTH, Resource.FIRE, Resource.WATER}, new UnitFactory(ExampleUnit.class));
	}
}
