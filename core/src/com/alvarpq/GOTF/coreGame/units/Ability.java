package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.Player;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.requirement.Requirement;
/**
 * The superclass of all abilities returned by getAbility in AbilityBearer
 */
public abstract class Ability
{
	/**
	 * The name of the ability.
	 */
	private String name;
	/**
	 * The resource cost of the ability.
	 */
	private int resourceCost;
	/**
	 * The element cost of the ability.
	 */
	private List<Element> elementCost;
	/**
	 * The requirements needed to be fulfilled before activating the ability.
	 */
	private Requirement[] requirements;
	/**
	 * The owner of the ability.
	 */
	private Player owner;
	/**
	 * Instantiates a new ability.
	 * @param name the name of the ability
	 * @param resourceCost the cost in resources to activate the ability
	 * @param elementCost the cost in elements to activate the ability
	 */
	public Ability(String name, int resourceCost, List<Element> elementCost)
	{
		this.name = name;
		this.resourceCost = resourceCost;
		this.elementCost = elementCost;
		this.requirements = new Requirement[]{};
	}
	/**
	 * Resets the ability's requirements.
	 * This function has to be called at the end of triggerAbility (if triggerAbility returns true) in all abilities.
	 */
	public void reset()
	{
		for(Requirement requirement:getRequirements())
		{
			requirement.reset();
		}
	}
	/**
	 * This function is called by the game when the ability is triggered.
	 * Always make sure the ability is ready in triggerAbility.
	 * @param mySide theSide this ability belongs to
	 * @param opponentsSide the opponent to the side this ability belongs to
	 * @return whether the ability was triggered
	 */
	public abstract boolean triggerAbility(Side mySide, Side opponentsSide);
	/**
	 * Returns whether this ability is ready to be triggered.
	 * @return whether this ability is ready to be triggered
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
	 * Returns the name of this ability.
	 * @return the name of this ability
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Sets the name of this ability.
	 * @param name the new name of this ability
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Returns the resource cost of this ability.
	 * @return the resource cost of this ability
	 */
	public int getResourceCost()
	{
		return resourceCost;
	}
	/**
	 * Sets the resource cost of this ability.
	 * @param resourceCost the new resource cost of this ability
	 */
	public void setResourceCost(int resourceCost)
	{
		this.resourceCost = resourceCost;
	}
	/**
	 * Returns the element cost of this ability.
	 * @return the element cost of this ability
	 */
	public List<Element> getElementCost()
	{
		return elementCost;
	}
	/**
	 * Sets the element cost of this ability.
	 * @param elementCost the new element cost of this ability
	 */
	public void setElementCost(List<Element> elementCost)
	{
		this.elementCost = elementCost;
	}
	/**
	 * Returns this ability's requirements.
	 * @return this ability's requirements
	 */
	public Requirement[] getRequirements()
	{
		return requirements;
	}
	/**
	 * Sets this ability's requirements.
	 * @param requirements this  ability's new requirements
	 */
	public void setRequirements(Requirement[] requirements)
	{
		this.requirements = requirements;
	}
	/**
	 * Returns the owner of this ability.
	 * @return the owner of this ability
	 */
	public Player getOwner()
	{
		return owner;
	}
	/**
	 * Sets the owner of this ability.
	 * @param owner the new owner of this ability
	 */
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
}