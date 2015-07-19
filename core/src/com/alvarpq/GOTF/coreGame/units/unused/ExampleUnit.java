package com.alvarpq.GOTF.coreGame.units.unused;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class ExampleUnit extends Unit
{
	public ExampleUnit(int row, int column)
	{
		super("Example Unit", 2, 2, 2, 1, true, new String[]{"ExampleSubtype"}, row, column);
	}
}
