package com.alvarpq.GOTF.requirement;
public class OpponentEmptyTileRequirement extends EmptyTileRequirement
{
	@Override
	public RequirementType getType()
	{
		return RequirementType.OPPONENT_EMPTY_TILE;
	}
}
