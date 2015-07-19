package com.alvarpq.GOTF.requirement;
/**
 * All requirement classes has to override this interface.
 */
public interface Requirement
{
	/**
	 * Returns the type of requirement.
	 * @return the type of requirement
	 */
	public RequirementType getType();
	/**
	 * Returns whether this requirement has been fulfilled.
	 * @return whether this requirement has been fulfilled
	 */
	public boolean isFulfilled();
	/**
	 * Resets this requirement.
	 */
	public void reset();
}