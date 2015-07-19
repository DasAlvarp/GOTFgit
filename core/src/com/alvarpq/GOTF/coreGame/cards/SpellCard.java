package com.alvarpq.GOTF.coreGame.cards;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.requirement.Requirement;
public abstract class SpellCard extends Card
{
	public SpellCard(int id, String name,int resourceCost, List<Element> elementCost)
	{
		super(id, name, resourceCost, elementCost);
	}
	//Make sure to call at the end of play in SpellCards if isReady, also make sure to use isReady in play
	public void reset()
	{
		for(Requirement requirement:getRequirements())
		{
			requirement.reset();
		}
	}
}
