package com.alvarpq.GOTF.coreGame.cards.temp;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.temp.ProtectorOfWhales;
public class ProtectorOfWhalesCard extends UnitCard
{
	public ProtectorOfWhalesCard()
	{
		super(10004, "Protector of Whales", 1, new Resource[]{Resource.AIR}, new UnitFactory(ProtectorOfWhales.class));
	}
}
