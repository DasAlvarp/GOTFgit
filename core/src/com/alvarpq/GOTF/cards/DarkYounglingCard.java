package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.units.DarkYounling;
public class DarkYounglingCard extends UnitCard
{
	public DarkYounglingCard()
	{
		super("Dark Youngling", 0, new Resource[]{Resource.EARTH, Resource.EARTH}, new UnitFactory(DarkYounling.class));
	}
}
