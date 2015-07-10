package com.alvarpq.GOTF.coreGame.cards.real;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.real.ExampleUnit;
public class ExampleUnitCard extends UnitCard
{
	public ExampleUnitCard()
	{
		super("Example Unit", 4, new Resource[]{Resource.AIR, Resource.EARTH, Resource.FIRE, Resource.WATER}, new UnitFactory(ExampleUnit.class));
	}
}
