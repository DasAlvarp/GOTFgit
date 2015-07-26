package com.alvarpq.GOTF.coreGame.cards;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.requirement.Requirement;
public abstract class SpellCard extends Card
{
	/**
	 * Instantiates a new SpellCard.
	 * @param id the id of the card
	 * @param name the name of the card
	 * @param resourceCost the cost in resources to play the card
	 * @param elementCost the cost in elements to play the card
	 * @param owner the owner of the card
	 */
	public SpellCard(int id, String name, int resourceCost, Element[] elementCost, Player owner)
	{
		super(id, name, resourceCost, elementCost, owner);
	}
	/**
	 * Resets the spell card's requirements.
	 * This function has to be called at the end of play (if play returns true) in all spell cards.
	 */
	public void reset()
	{
		for(Requirement requirement:getRequirements())
		{
			requirement.reset();
		}
	}
}
