package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class StoneGiant extends Unit
{
	public StoneGiant(int row, int column)
	{
		super("Stone Giant", 4, 2, 5, 1, true, new String[]{"Giant"}, row, column);
	}

	@Override
	public void update(){}
}
