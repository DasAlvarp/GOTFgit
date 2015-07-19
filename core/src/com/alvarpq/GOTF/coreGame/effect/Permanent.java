package com.alvarpq.GOTF.coreGame.effect;
/**
 * Used for permanent effects on units.
 */
public class Permanent implements Effect
{
	/**
	 * The name of the permanent effect.
	 */
	String name;
	/**
	 * The attack change of the permanent effect.
	 */
	private int attack;
	/**
	 * The base countdown change of the permanent effect.
	 */
	private int baseCountdown;
	/**
	 * The health change of the permanent effect.
	 */
	private int health;
	/**
	 * The base move change of the permanent effect.
	 */
	private int baseMove;
	/**
	 * Whether this permanent effect makes the unit untargetable.
	 */
	boolean untargetable;
	public Permanent(String name, int attack, int baseCountdown, int health, int baseMove, boolean untargetable)
	{
		this.name = name;
		this.attack = attack;
		this.baseCountdown = baseCountdown;
		this.health = health;
		this.baseMove = baseMove;
		this.untargetable = untargetable;
	}
	/**
	 * Returns the name of the effect.
	 * @return the name of the effect
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the attack change of the effect.
	 * @return the attack change of the effect
	 */
	public int attackChange()
	{
		return attack;
	}
	/**
	 * Returns the base countdown change of the effect.
	 * @return the base countdown change of the effect
	 */
	public int baseCountdownChange()
	{
		return baseCountdown;
	}
	/**
	 * Returns the health change of the effect.
	 * @return the health change of the effect
	 */
	public int healthChange()
	{
		return health;
	}
	/**
	 * Returns the base move change of the effect.
	 * @return the base move change of the effect
	 */
	public int baseMoveChange()
	{
		return baseMove;
	}
	/**
	 * Returns whether the effect makes the unit untargetable.
	 * @return whether the effect makes the unit untargetable
	 */
	public boolean untargetable()
	{
		return untargetable;
	}
}