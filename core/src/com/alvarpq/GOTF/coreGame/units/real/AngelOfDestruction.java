package com.alvarpq.GOTF.coreGame.units.real;
import com.alvarpq.GOTF.coreGame.units.Ability;
import com.alvarpq.GOTF.coreGame.units.AbilityBearer;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.alvarpq.GOTF.entity.AnimatedSprite;
public class AngelOfDestruction extends Unit implements AbilityBearer
{
	public AngelOfDestruction(int row, int column)
	{
		super("Angel of Destruction", 4, 2, 4, 1, true, new String[]{"Angel"}, row, column);
	}
	@Override
	public AnimatedSprite getSprite(){return null;}
	@Override
	public void update(){}
	@Override
	public Ability getAbility()
	{
		return new AngelOfDestructionAbility();
	}
}
