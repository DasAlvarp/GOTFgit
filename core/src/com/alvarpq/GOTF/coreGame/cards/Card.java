package com.alvarpq.GOTF.coreGame.cards;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.requirement.Requirement;
public abstract class Card
{
	private int id;			//ID # of unit
	private String name;
	private int thresholdCost;
	private Resource[] resourceCost;
	private Requirement[] requirements;
	private Player owner;
	public Card(int ident, String name, int thresholdCost, Resource[] resourceCost)
	{
		this.id = ident;
		this.name = name;
		this.thresholdCost = thresholdCost;
		this.resourceCost = resourceCost;
		this.requirements = new Requirement[]{};
	}
	public abstract boolean play(Side mySide, Side opponentsSide);
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
	
	public int getID()
	{
		return id;
	}
	public void setID(int id)
	{
		this.id = id;
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