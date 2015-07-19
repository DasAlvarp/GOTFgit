package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.RedDevil;
public class RedDevilCard extends UnitCard
{
	public RedDevilCard()
	{
		super(110102, "Red Devil", 1, Arrays.asList(new Resource[]{Resource.EARTH}), new UnitFactory(RedDevil.class));
	}
}
