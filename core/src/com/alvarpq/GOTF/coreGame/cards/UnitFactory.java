package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * This class is used by UnitCard to create new units.
 */
public class UnitFactory
{
	/**
	 * The class with the unit to create
	 */
	private Class<? extends Unit> unit;
	/**
	 * Instantiates a new UnitFactory.
	 * @param unit the class of the unit type this unit factory creates.
	 */
	public UnitFactory(Class<? extends Unit> unit)
	{
		this.unit = unit;
	}
	/**
	 * Creates a new unit.
	 * @param row the row to create the unit on
	 * @param column the column to create the unit on
	 * @return the created unit
	 */
	public Unit create(int row, int column) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		return (Unit)unit.getConstructors()[0].newInstance(row, column);
	}
}
