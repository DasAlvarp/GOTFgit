package com.alvarpq.GOTF.coreGame.effect;
public interface Enchant extends Effect
{
	public String getName();
	public int attackChange();
	public int countdownChange();
	public int healthChange();
	public int moveChange();
	public void trigger();
}