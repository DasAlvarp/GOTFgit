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
	/**
	 * The type of unit that is required.
	 * @see RequirementType
	 */
	private RequirementType type;
	/**
	 * Instantiates a new UnitRequirement.
	 * @param type the type of unit that is required
	 * @see RequirementType
	 */
	public UnitRequirement(RequirementType type)
	{
		unit = null;
		this.type = type;
	}
	/**
	 * Returns the type of unit that is required.
	 * @return the type of unit that is required
	 * @see RequirementType
	 */
	@Override
	public RequirementType getType()
	{
		return type;
	}
	/**
	 * Returns whether the requirement has been fullfilled or not.
	 * @return whether the requirement has been fullfilled or not
	 */
	@Override
	public boolean isFulfilled()
	{
		return unit!=null;
	}
	/**
	 * Resets the requirement.
	 */
	@Override
	public void reset()
	{
		unit = null;
	}
	/**
	 * Returns the unit that has been targeted, can be null.
	 * @return the unit that has been targeted
	 */
	public Unit getUnit()
	{
		return unit;
	}
	/**
	 * Sets the targeted unit.
	 * @param unit the targeted unit
	 */
	public void setUnit(Unit unit)
	{
		this.unit = unit;
	}
}