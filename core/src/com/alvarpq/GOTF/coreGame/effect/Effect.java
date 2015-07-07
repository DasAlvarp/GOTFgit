package com.alvarpq.GOTF.coreGame.effect;
public interface Effect
{
	public String getName();
	public int attackChange();
	public int baseCountdownChange();
	public int healthChange();
	public int baseMoveChange();
}