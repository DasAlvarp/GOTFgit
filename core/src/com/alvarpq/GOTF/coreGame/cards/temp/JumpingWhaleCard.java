package com.alvarpq.GOTF.coreGame.cards.temp;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.temp.JumpingWhale;
public class JumpingWhaleCard extends UnitCard
{
	public JumpingWhaleCard()
	{
		super(10003, "Jumping Whale", 2, new Resource[]{Resource.AIR, Resource.WATER}, new UnitFactory(JumpingWhale.class));
	}
}
