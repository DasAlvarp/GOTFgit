package com.alvarpq.GOTF.coreGame.cards.unused;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RowRequirement;
public class PenanceOfTheGods extends SpellCard
{
	private RowRequirement target;
	public PenanceOfTheGods()
	{
		super(100106, "Penance of the Gods", 10, Arrays.asList(new Resource[]{Resource.EARTH, Resource.EARTH, Resource.EARTH, Resource.EARTH, Resource.EARTH}));
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