package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.DarkYoungling;
public class DarkYounglingCard extends UnitCard
{
	public DarkYounglingCard()
	{
		super(100102, "Dark Youngling", 1, Arrays.asList(new Resource[]{Resource.EARTH}), new UnitFactory(DarkYoungling.class));
	}
}
