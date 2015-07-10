package com.alvarpq.GOTF.coreGame.cards.real;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.real.JumpingWhale;
public class JumpingWhaleCard extends UnitCard
{
	public JumpingWhaleCard()
	{
		super("Jumping Whale", 2, new Resource[]{Resource.AIR, Resource.WATER}, new UnitFactory(JumpingWhale.class));
	}
}
