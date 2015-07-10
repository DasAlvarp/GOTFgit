package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.TileRequirement;
public abstract class UnitCard extends Card
{
	private UnitFactory unitFactory;
	private TileRequirement position;
	public UnitCard(String name, int thresholdCost, Resource[] resourceCost, UnitFactory unitFactory)
	{
		super(name, thresholdCost, resourceCost);
		position = new TileRequirement(RequirementType.OWN_EMPTY_TILE);
		setRequirements(new Requirement[]{position});
		this.unitFactory = unitFactory;
	}
	@Override
	public boolean play(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			try
			{
				mySide.getHalf().addUnit(unitFactory.create(position.getRow(), position.getColumn()));
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
