package com.alvarpq.GOTF.coreGame.units.temp;
import com.alvarpq.GOTF.coreGame.units.Ability;
import com.alvarpq.GOTF.coreGame.units.AbilityBearer;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class AngelOfDestruction extends Unit implements AbilityBearer
{
	public AngelOfDestruction(int row, int column)
	{
		super("Angel of Destruction", 4, 2, 4, 1, true, new String[]{"Angel"}, row, column);
	}

	@Override
	public void update(){}
	@Override
	public Ability getAbility()
	{
		return new AngelOfDestructionAbility();
	}
}
