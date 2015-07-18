package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.StoneGiant;
public class StoneGiantCard extends UnitCard
{
	public StoneGiantCard()
	{
		super(210111, "Stone Giant", 4, Arrays.asList(new Resource[]{Resource.EARTH}), new UnitFactory(StoneGiant.class));
	}
}
