package com.alvarpq.GOTF.coreGame.event;

import com.alvarpq.GOTF.coreGame.units.Unit;

public abstract class UnitEvent
{
	private Unit target;
	public UnitEvent(Unit target)
	{
		this.target = target;
	}
	public Unit getTarget()
	{
		return target;
	}
}
