package com.alvarpq.GOTF.coreGame.units.real;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.entity.AnimatedSprite;
public class ExampleUnit extends Unit
{
	public ExampleUnit(int row, int column)
	{
		super("Example Unit", 2, 2, 2, 1, true, new String[]{"ExampleSubtype"}, row, column);
	}

	@Override
	public void update(){}
}
