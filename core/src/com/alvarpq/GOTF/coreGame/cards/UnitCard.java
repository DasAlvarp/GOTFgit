package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.TileRequirement;
public abstract class UnitCard extends Card
{
	private UnitFactory unitFactory;
	private TileRequirement position;
	public UnitCard(int id, String name, int resourceCost, List<Element> elementCost, UnitFactory unitFactory)
	{
		super(id, name, resourceCost, elementCost);
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
			catch(InstantiationException e){e.printStackTrace();}
			catch(IllegalAccessException e){e.printStackTrace();}
			catch(IllegalArgumentException e){e.printStackTrace();}
			catch(InvocationTargetException e){e.printStackTrace();}
			catch(SecurityException e){e.printStackTrace();}
		}
		return false;
	}
}
