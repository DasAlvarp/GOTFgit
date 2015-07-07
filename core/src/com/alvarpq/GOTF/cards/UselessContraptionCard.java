package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.units.UselessContraption;
public class UselessContraptionCard extends UnitCard
{
	public UselessContraptionCard()
	{
		super(1, new Resource[]{}, new UnitFactory(UselessContraption.class));
	}
}
