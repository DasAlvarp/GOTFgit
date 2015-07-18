package com.alvarpq.GOTF.coreGame.cards.temp;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.temp.ExampleUnit;
public class ExampleUnitCard extends UnitCard
{
	public ExampleUnitCard()
	{
		super(10002, "Example Unit", 4, new Resource[]{Resource.AIR, Resource.EARTH, Resource.FIRE, Resource.WATER}, new UnitFactory(ExampleUnit.class));
	}
}
