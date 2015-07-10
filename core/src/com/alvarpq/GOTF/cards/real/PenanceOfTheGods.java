package com.alvarpq.GOTF.cards.real;
import com.alvarpq.GOTF.cards.SpellCard;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class PenanceOfTheGods extends SpellCard
{
	private UnitRequirement target;
	public PenanceOfTheGods()
	{
		super("Penance of the Gods", 10, new Resource[]{Resource.EARTH, Resource.EARTH, Resource.EARTH, Resource.EARTH, Resource.EARTH});
		target = new UnitRequirement(RequirementType.UNIT);
		setRequirements(new Requirement[]{target});
	}
	@Override
	public boolean play(BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		if(isReady())
		{
			opponentsHalf.damage(target.getUnit(), 5);
			reset();
			return true;
		}
		return false;
	}
}
