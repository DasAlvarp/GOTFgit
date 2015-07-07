package com.alvarpq.GOTF.cards;

import java.lang.reflect.InvocationTargetException;
import com.alvarpq.GOTF.coreGame.units.Unit;

public class UnitFactory
{
	private Class<? extends Unit> unit;
	public UnitFactory(Class<? extends Unit> unit)
	{
		this.unit = unit;
	}
	public Unit create(int row, int column) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		return (Unit)unit.getConstructors()[0].newInstance(row, column);
	}
}
