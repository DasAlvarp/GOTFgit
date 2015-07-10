package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public abstract class EnchantmentCard extends Card
{
	private EnchantmentFactory enchantmentFactory;
	private UnitRequirement target;
	public EnchantmentCard(String name, int thresholdCost, Resource[] resourceCost, EnchantmentFactory enchantmentFactory)
	{
		super(name, thresholdCost, resourceCost);
		target = new UnitRequirement(RequirementType.UNIT);
		setRequirements(new Requirement[]{target});
		this.enchantmentFactory = enchantmentFactory;
	}
	@Override
	public boolean play(BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		if(isReady())
		{
			try
			{
				target.getUnit().applyEffect(enchantmentFactory.create());
				for(Requirement requirement:getRequirements())
				{
					requirement.reset();
				}
				return true;
			}
			catch(InstantiationException e){}
			catch(IllegalAccessException e){}
			catch(IllegalArgumentException e){}
			catch(InvocationTargetException e){}
			catch(SecurityException e){}
		}
		return false;
	}
}
