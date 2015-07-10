package com.alvarpq.GOTF.cards.real;
import com.alvarpq.GOTF.cards.UnitCard;
import com.alvarpq.GOTF.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.units.real.DarkYounling;
public class DarkYounglingCard extends UnitCard
{
	public DarkYounglingCard()
	{
		super("Dark Youngling", 0, new Resource[]{Resource.EARTH, Resource.EARTH}, new UnitFactory(DarkYounling.class));
	}
}
