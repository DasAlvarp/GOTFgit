package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.requirement.OpponentUnitRequirement;
import com.alvarpq.GOTF.requirement.Requirement;
public class Spark extends SpellCard
{
	private OpponentUnitRequirement target;
	public Spark()
	{
		super(1, new Resource[]{});
		target = new OpponentUnitRequirement();
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
