package com.alvarpq.GOTF.coreGame.units.real;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Ability;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.RowRequirement;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class AngelOfDestructionAbility extends Ability
{
	private UnitRequirement target1;
	private RowRequirement target2;
	public AngelOfDestructionAbility()
	{
		super("AngelOfDestructionAbility", 0, new Resource[]{});
		target1 = new UnitRequirement(RequirementType.OWN_UNIT);
		target2 = new RowRequirement();
		setRequirements(new Requirement[]{target1, target2});
	}
	@Override
	public boolean triggerAbility(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			//mySide.getHalf().kill(target1.getUnit()); kill functions has to be added
			reset();
			return true;
		}
		return false;
	}
}
