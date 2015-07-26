package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
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
	 * @param owner the owner of the card
	 * @param unitFactory the unitFactory used to spawn units
	 */
	public UnitCard(int id, String name, int resourceCost, Element[] elementCost, Player owner, UnitFactory unitFactory)
	{
		super(id, name, resourceCost, elementCost, owner);
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
				Unit temp = unitFactory.create(position.getRow(), position.getColumn());
				temp.setCard(this);
				mySide.getHalf().addUnit(temp);
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
	/**
	 * Returns this unit card's unit factory.
	 * @return this unit card's unit factory
	 */
	public UnitFactory getUnitFactory()
	{
		return unitFactory;
	}
	/**
	 * Returns a unit created with this unit card's UnitFactory.
	 * @param row the row to create the unit on
	 * @param column the column to create the unit on
	 * @return the created unit
	 */
	public Unit createUnit(int row, int column) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		return unitFactory.create(row, column);
	}
}
