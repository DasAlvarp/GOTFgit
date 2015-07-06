package com.alvarpq.GOTF.coreGame.effect;
public class Permanent implements Effect
{
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
	@Override public void trigger(){}
}