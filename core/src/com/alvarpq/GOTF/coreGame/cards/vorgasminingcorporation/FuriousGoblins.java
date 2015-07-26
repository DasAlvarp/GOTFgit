package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.requirement.Requirement;
public class FuriousGoblins extends SpellCard
{
	public FuriousGoblins(Player owner)
	{
		super(110108, "Furious Goblins", 2, new Element[]{Element.EARTH, Element.EARTH}, owner);
		setRequirements(new Requirement[]{});
	}
	@Override
	public boolean play(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			for(Unit unit:mySide.getHalf().getUnits())
			{
				if(Arrays.asList(unit.getSubtypes()).contains("Goblin"))
				{
					mySide.getHalf().changeCountdown(unit, -1);
				}
			}
			reset();
			return true;
		}
		return false;
	}
}
