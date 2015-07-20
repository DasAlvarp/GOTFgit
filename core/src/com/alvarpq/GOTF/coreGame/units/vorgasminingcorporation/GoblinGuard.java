package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class GoblinGuard extends Unit
{
	public GoblinGuard(int row, int column)
	{
		super("Goblin Guard", "goblin.png", 0, 2, 5, 1, true, new String[]{"Goblin, Soldier"}, row, column);
	}
}
