package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.JumpingWhale;
public class JumpingWhaleCard extends UnitCard
{
	public JumpingWhaleCard()
	{
		super(100105, "Jumping Whale", 2, Arrays.asList(new Element[]{Element.AIR, Element.WATER}), new UnitFactory(JumpingWhale.class));
	}
}
