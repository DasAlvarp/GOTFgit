package com.alvarpq.GOTF.coreGame.effect;
public class Permanent implements Effect
{
	String name;
	int attack, countdown, health, move;
	public Permanent(String name, int attack, int countdown, int health, int move){
		this.name = name;
		this.attack = attack;
		this.countdown = countdown;
		this.health = health;
		this.move=move;
	}
	@Override
	public int attackChange()
	{
		return attack;
	}
	@Override
	public int countdownChange()
	{
		return countdown;
	}
	@Override
	public int healthChange()
	{
		return health;
	}
	@Override
	public int moveChange()
	{
		return move;
	}
	@Override
	public String getName()
	{
		return name;
	}
	@Override public void trigger(){}
}