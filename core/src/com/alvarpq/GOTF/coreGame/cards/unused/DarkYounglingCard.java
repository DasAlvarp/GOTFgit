package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.DarkYoungling;
public class DarkYounglingCard extends UnitCard
{
	public DarkYounglingCard(Player owner)
	{
		super(100101, "Dark Youngling", 1, Arrays.asList(new Element[]{Element.EARTH}), owner, new UnitFactory(DarkYoungling.class));
	}
}
