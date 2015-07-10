package com.alvarpq.GOTF.coreGame.cards.real;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.real.DarkYounling;
public class DarkYounglingCard extends UnitCard
{
	public DarkYounglingCard()
	{
		super("Dark Youngling", 1, new Resource[]{Resource.EARTH}, new UnitFactory(DarkYounling.class));
	}
}
