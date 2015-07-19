package com.alvarpq.GOTF.requirement;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * This class is used by cards who needs to target units (mostly spells).
 */
public class UnitRequirement implements Requirement
{
	/**
	 * The unit that has been targeted, can be null.
	 */
	private Unit unit;
	private RequirementType type;
	public UnitRequirement(RequirementType type)
	{
		unit = null;
		this.type = type;
	}
	@Override
	public RequirementType getType()
	{
		return type;
	}
	@Override
	public boolean isFulfilled()
	{
		return unit!=null;
	}
	@Override
	public void reset()
	{
		unit = null;
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