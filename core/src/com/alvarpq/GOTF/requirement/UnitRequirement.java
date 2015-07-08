package com.alvarpq.GOTF.requirement;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class UnitRequirement implements Requirement
{
	private Unit unit;
	public UnitRequirement()
	{
		unit = null;
	}
	@Override
	public RequirementType getType()
	{
		return RequirementType.UNIT;
	}
	@Override
	public boolean isFulfilled()
	{
		return unit!=null;
	}
	public Unit getUnit()
	{
		return unit;
	}
	public void setUnit(Unit unit)
	{
		this.unit = unit;
	}
}