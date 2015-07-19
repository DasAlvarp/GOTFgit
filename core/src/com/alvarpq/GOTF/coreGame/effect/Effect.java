package com.alvarpq.GOTF.coreGame.effect;
/**
 * The superclass of all effects on units.
 */
public interface Effect
{
	/**
	 * Returns the name of the effect.
	 * @return the name of the effect
	 */
	public String getName();
	/**
	 * Returns the attack change of the effect.
	 * @return the attack change of the effect
	 */
	public int attackChange();
	/**
	 * Returns the base countdown change of the effect.
	 * @return the base countdown change of the effect
	 */
	public int baseCountdownChange();
	/**
	 * Returns the health change of the effect.
	 * @return the health change of the effect
	 */
	public int healthChange();
	/**
	 * Returns the base move change of the effect.
	 * @return the base move change of the effect
	 */
	public int baseMoveChange();
	/**
	 * Returns whether the effect makes the unit untargetable.
	 * @return whether the effect makes the unit untargetable
	 */
	public boolean untargetable();
}