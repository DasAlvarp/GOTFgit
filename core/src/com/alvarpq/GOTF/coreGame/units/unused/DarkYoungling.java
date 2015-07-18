package com.alvarpq.GOTF.coreGame.units.unused;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class DarkYoungling extends Unit
{
	public DarkYoungling(int row, int column)
	{
		super("Dark Youngling", 1, 1, 1, 1, true, new String[]{"Mulgoon"}, row, column);
	}

	@Override
	public void update(){}
}
