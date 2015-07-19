package com.alvarpq.GOTF.coreGame.cards;
import java.util.List;
/**
 * The superclass of all cards.
 */
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.requirement.Requirement;
public abstract class Card
{
	/**
	 * The id of the card.
	 */
	private int id;
	/**
	 * The name of the card.
	 */
	private String name;
	/**
	 * The resource cost of the card.
	 */
	private int resourceCost;
	/**
	 * The element cost of the card.
	 */
	private List<Element> elementCost;
	/**
	 * The requirements needed to be fulfilled before playing the card.
	 */
	private Requirement[] requirements;
	/**
	 * The owner of the card.
	 */
	private Player owner;
	/**
	 * Instantiates a new card.
	 * @param id the id of the card
	 * @param name the name of the card
	 * @param resourceCost the cost in resources to play the card
	 * @param elementCost the cost in elements to play the card
	 */
	public Card(int id, String name, int resourceCost, List<Element> elementCost)
	{
		this.id = id;
		this.name = name;
		this.resourceCost = resourceCost;
		this.elementCost = elementCost;
		this.requirements = new Requirement[]{};
	}
	/**
	 * This function is called by the game when the card is played.
	 * Always make sure the card is ready in play.
	 * @param mySide theSide this card belongs to
	 * @param opponentsSide the opponent to the side this card belongs to
	 * @return whether the card was played
	 */
	public abstract boolean play(Side mySide, Side opponentsSide);
	/**
	 * Returns whether this card is ready to be played.
	 * @return whether this card is ready to be played
	 */
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
	/**
	 * Returns the id of this card.
	 * @return the id of this card
	 */
	public int getID()
	{
		return id;
	}
	/**
	 * Sets the id of this card.
	 * @param id the new name of this card
	 */
	public void setID(int id)
	{
		this.id = id;
	}
	/**
	 * Returns the name of this card.
	 * @return the name of this card
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Sets the name of this card.
	 * @param name the new name of this card
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Returns the resource cost of this card.
	 * @return the resource cost of this card
	 */
	public int getResourceCost()
	{
		return resourceCost;
	}
	/**
	 * Sets the resource cost of this card.
	 * @param resourceCost the new resource cost of this card
	 */
	public void setResourceCost(int resourceCost)
	{
		this.resourceCost = resourceCost;
	}
	/**
	 * Returns the element cost of this card.
	 * @return the element cost of this card
	 */
	public List<Element> getElementCost()
	{
		return elementCost;
	}
	/**
	 * Sets the element cost of this card.
	 * @param elementCost the new element cost of this card
	 */
	public void setElementCost(List<Element> elementCost)
	{
		this.elementCost = elementCost;
	}
	/**
	 * Returns this card's requirements.
	 * @return this card's requirements
	 */
	public Requirement[] getRequirements()
	{
		return requirements;
	}
	/**
	 * Sets this card's requirements.
	 * @param requirements this  card's new requirements
	 */
	public void setRequirements(Requirement[] requirements)
	{
		this.requirements = requirements;
	}
	/**
	 * Returns the owner of this card.
	 * @return the owner of this card
	 */
	public Player getOwner()
	{
		return owner;
	}
	/**
	 * Sets the owner of this card.
	 * @param owner the new owner of this card
	 */
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
}