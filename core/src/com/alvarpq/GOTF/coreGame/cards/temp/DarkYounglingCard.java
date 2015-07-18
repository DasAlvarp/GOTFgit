package com.alvarpq.GOTF.coreGame.cards.temp;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.temp.DarkYoungling;
public class DarkYounglingCard extends UnitCard
{
	public DarkYounglingCard()
	{
		super(10001, "Dark Youngling", 1, new Resource[]{Resource.EARTH}, new UnitFactory(DarkYoungling.class));
	}
}
