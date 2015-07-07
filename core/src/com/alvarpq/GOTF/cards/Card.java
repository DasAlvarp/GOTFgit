package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
public abstract class Card
{
	private int thresholdCost;
	private Resource[] resourceCost;
	private Requirement[] requirements;
	public Card(int thresholdCost, Resource[] resourceCost, Requirement[] requirements)
	{
		this.thresholdCost = thresholdCost;
		this.resourceCost = resourceCost;
		this.requirements = requirements;
	}
	public abstract void inputHex(Player side, int row, int column);
	public abstract void play(BoardHalf mySide, BoardHalf opponentsSide);
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
}
