package com.alvarpq.GOTF.coreGame.effect;
public class Permanent implements Effect
{
	public static final Permanent ATTACK_HEALTH_1 = new Permanent("+1 Attack and +1 Health", 1, 0, 1, 0);
	String name;
	int attack, baseCountdown, health, baseMove;
	public Permanent(String name, int attack, int baseCountdown, int health, int baseMove)
	{
		this.name = name;
		this.attack = attack;
		this.baseCountdown = baseCountdown;
		this.health = health;
		this.baseMove = baseMove;
	}
	@Override
	public int attackChange()
	{
		return attack;
	}
	@Override
	public int baseCountdownChange()
	{
		return baseCountdown;
	}
	@Override
	public int healthChange()
	{
		return health;
	}
	@Override
	public int baseMoveChange()
	{
		return baseMove;
	}
	@Override
	public String getName()
	{
		return name;
	}
}