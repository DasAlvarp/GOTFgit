package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.requirement.Requirement;
public abstract class Ability
{
	private String name;
	private int thresholdCost;
	private Resource[] resourceCost;
	private Requirement[] requirements;
	private Player owner;
	public Ability(String name, int thresholdCost, Resource[] resourceCost)
	{
		this.name = name;
		this.thresholdCost = thresholdCost;
		this.resourceCost = resourceCost;
		this.requirements = new Requirement[]{};
	}
	//Make sure to call at the end of triggerAbility, also make sure to use isReady in play
	public void reset()
	{
		for(Requirement requirement:getRequirements())
		{
			requirement.reset();
		}
	}
	public abstract boolean triggerAbility(Side mySide, Side opponentsSide);
	public boolean isReady()
	{
		for(Requirement requirement:requirements)
		{
			if(!requirement.isFulfilled())
			{
				return false;
			}
		}
		return true;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getThresholdCost()
	{
		return thresholdCost;
	}
	public void setThresholdCost(int thresholdCost)
	{
		this.thresholdCost = thresholdCost;
	}
	public Resource[] getResourceCost()
	{
		return resourceCost;
	}
	public void setResourceCost(Resource[] resourceCost)
	{
		this.resourceCost = resourceCost;
	}
	public Requirement[] getRequirements()
	{
		return requirements;
	}
	public void setRequirements(Requirement[] requirements)
	{
		this.requirements = requirements;
	}
	public Player getOwner()
	{
		return owner;
	}
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
}