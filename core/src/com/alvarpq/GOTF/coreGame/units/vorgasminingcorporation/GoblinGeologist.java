package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.units.AttackType;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class GoblinGeologist extends Unit
{
	public GoblinGeologist(int row, int column)
	{
		super("Goblin Geologist", null, 0, 2, 3, 1, true, new String[]{"Goblin, Miner"}, row, column);
		setAttackType(new AttackType.IncreaseEarth());
	}
}
