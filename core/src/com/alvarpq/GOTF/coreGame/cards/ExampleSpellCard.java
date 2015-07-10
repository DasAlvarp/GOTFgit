package com.alvarpq.GOTF.coreGame.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class ExampleSpellCard extends SpellCard
{
	private UnitRequirement target;
	public ExampleSpellCard()
	{
		super("Example Spell", 4, new Resource[]{Resource.AIR, Resource.EARTH, Resource.FIRE, Resource.WATER});
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
