package com.alvarpq.GOTF.coreGame.effect;

public abstract class Enchant implements Effect{

	public abstract int atkChange();
	
	public abstract int cdChange();
	
	public abstract int healthChange();
	
	public abstract void trigger();
	
	public abstract String getName();
}
