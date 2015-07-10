package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class Spark extends SpellCard
{
	private UnitRequirement target;
	public Spark()
	{
		super("Spark", 2, new Resource[]{Resource.FIRE});
		target = new UnitRequirement(RequirementType.UNIT);
		setRequirements(new Requirement[]{target});
	}
	@Override
	public boolean play(BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		if(isReady())
		{
			opponentsHalf.damage(target.getUnit(), 2);
			for(Requirement requirement:getRequirements())
			{
				requirement.reset();
			}
			return true;
		}
		return false;
	}
}
