package com.alvarpq.GOTF.requirement;
public class OpponentUnitRequirement extends UnitRequirement
{
	@Override
	public RequirementType getType()
	{
		return RequirementType.OPPONENT_UNIT;
	}
}