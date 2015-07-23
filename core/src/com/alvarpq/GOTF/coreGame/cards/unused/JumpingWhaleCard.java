package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.JumpingWhale;
public class JumpingWhaleCard extends UnitCard
{
	public JumpingWhaleCard(Player owner)
	{
		super(100104, "Jumping Whale", 2, Arrays.asList(new Element[]{Element.AIR, Element.WATER}), owner, new UnitFactory(JumpingWhale.class));
	}
}
