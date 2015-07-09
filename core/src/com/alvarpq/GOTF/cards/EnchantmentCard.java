package com.alvarpq.GOTF.cards;
import java.lang.reflect.InvocationTargetException;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.requirement.OwnUnitRequirement;
import com.alvarpq.GOTF.requirement.Requirement;
public abstract class EnchantmentCard extends Card
{
	private EnchantmentFactory enchantmentFactory;
	private OwnUnitRequirement target;
	public EnchantmentCard(int thresholdCost, Resource[] resourceCost, EnchantmentFactory enchantmentFactory)
	{
		super(thresholdCost, resourceCost);
		target = new OwnUnitRequirement();
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
