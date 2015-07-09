package com.alvarpq.GOTF.cards;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.requirement.Requirement;
public abstract class SpellCard extends Card
{
	public SpellCard(int thresholdCost, Resource[] resourceCost)
	{
		super(thresholdCost, resourceCost);
	}
	//Make sure to call at the end of play in SpellCards, also make sure to use isReady in play
	public void reset()
	{
		for(Requirement requirement:getRequirements())
		{
			requirement.reset();
		}
	}
}
