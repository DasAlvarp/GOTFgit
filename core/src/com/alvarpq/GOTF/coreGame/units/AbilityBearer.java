package com.alvarpq.GOTF.coreGame.units;
/**
 * This interface should be implemented by all units which has a triggered ability.
 */
public interface AbilityBearer
{
	/**
	 * Returns the unit's ability.
	 * @return the unit's ability
	 */
	public Ability getAbility();
}
