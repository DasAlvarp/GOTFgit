package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.requirement.Requirement;
public class RaisedMetalPrices extends SpellCard
{
	public RaisedMetalPrices(Player owner)
	{
		super(110109, "Raised Metal Prices", 1, new Element[]{Element.EARTH}, owner);
		setRequirements(new Requirement[]{});
	}
	@Override
	public boolean play(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			mySide.setResources(mySide.getResources()+4);
			mySide.getElements().addAll(Arrays.asList(new Element[]{Element.EARTH, Element.EARTH, Element.EARTH, Element.EARTH}));
			reset();
			return true;
		}
		return false;
	}
}
