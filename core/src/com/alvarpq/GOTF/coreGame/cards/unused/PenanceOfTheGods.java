package com.alvarpq.GOTF.coreGame.cards.unused;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RowRequirement;
public class PenanceOfTheGods extends SpellCard
{
	private RowRequirement target;
	public PenanceOfTheGods(Player owner)
	{
		super(100105, "Penance of the Gods", 10, new Element[]{Element.EARTH, Element.EARTH, Element.EARTH, Element.EARTH, Element.EARTH}, owner);
		target = new RowRequirement();
		setRequirements(new Requirement[]{target});
	}
	@Override
	public boolean play(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			mySide.getHalf().setIdol(target.getRow(), 0);
			opponentsSide.getHalf().setIdol(target.getRow(), 0);
			reset();
			return true;
		}
		return false;
	}
}
