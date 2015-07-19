package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.TileRequirement;
/**
 * The superclass of all unit cards.
 */
public abstract class UnitCard extends Card
{
	/**
	 * The unit factory for spawning units.
	 */
	private UnitFactory unitFactory;
	/**
	 * The tile to spawn the unit on.
	 */
	private TileRequirement position;
	/**
	 * Instantiates a new UnitCard.
	 * @param id the id of the card
	 * @param name the name of the card
	 * @param resourceCost the cost in resources to play the card
	 * @param elementCost the cost in elements to play the card
	 * @param unitFactory the unitFactory used to spawn units
	 */
	public UnitCard(int id, String name, int resourceCost, List<Element> elementCost, UnitFactory unitFactory)
	{
		super(id, name, resourceCost, elementCost);
		position = new TileRequirement(RequirementType.OWN_EMPTY_TILE);
		setRequirements(new Requirement[]{position});
		this.unitFactory = unitFactory;
	}
	/**
	 * This function is called by the game when the card is played.
	 * @param mySide theSide this card belongs to
	 * @param opponentsSide the opponent to the side this card belongs to
	 * @return whether the card was played
	 */
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
