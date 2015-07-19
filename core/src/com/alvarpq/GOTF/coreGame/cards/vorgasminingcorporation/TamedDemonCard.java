package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.TamedDemon;
public class TamedDemonCard extends UnitCard
{
	public TamedDemonCard()
	{
		super(110112, "Tamed Demon", 4, Arrays.asList(new Resource[]{Resource.EARTH, Resource.FIRE}), new UnitFactory(TamedDemon.class));
	}
}
