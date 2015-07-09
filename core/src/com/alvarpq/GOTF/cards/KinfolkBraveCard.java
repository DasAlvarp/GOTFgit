package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.units.KinfolkBrave;
public class KinfolkBraveCard extends UnitCard
{
	public KinfolkBraveCard()
	{
		super(1, new Resource[]{}, new UnitFactory(KinfolkBrave.class));
	}
}
