package com.alvarpq.GOTF.coreGame.units.real;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.entity.AnimatedSprite;
public class DarkYounling extends Unit
{
	public DarkYounling(int row, int column)
	{
		super("Dark Youngling", 1, 1, 1, 1, true, new String[]{"Mulgoon"}, row, column);
	}

	@Override
	public void update(){}
}
