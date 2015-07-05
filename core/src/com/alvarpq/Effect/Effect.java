package com.alvarpq.Effect;

public interface Effect {

	// Effect has 2 types: Enchant, or simply Effect. Enchants will be
	// removable, while Effects will likely not be. We can distinguish between
	// them with instanceof.


	public int atkChange();

	public int cdChange();

	public int healthChange();
	
	public void trigger();

	public String getName();
}
