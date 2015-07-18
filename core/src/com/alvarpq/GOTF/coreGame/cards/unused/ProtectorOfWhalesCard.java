package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.ProtectorOfWhales;
public class ProtectorOfWhalesCard extends UnitCard
{
	public ProtectorOfWhalesCard()
	{
		super(100107, "Protector of Whales", 1, Arrays.asList(new Resource[]{Resource.AIR}), new UnitFactory(ProtectorOfWhales.class));
	}
}
