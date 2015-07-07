package com.alvarpq.GOTF.coreGame.effect;
public class Presence implements Effect
{
	public static final Presence ATTACK_1 = new Presence("+1 Attack", 1, 0, 0, 0);
	public static final Presence HEALTH_1 = new Presence("+1 Health", 0, 0, 1, 0);
	String name;
	int attack, baseCountdown, health, baseMove;
	public Presence(String name, int attack, int baseCountdown, int health, int baseMove)
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