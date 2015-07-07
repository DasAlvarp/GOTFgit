package com.alvarpq.GOTF.cards;

import java.lang.reflect.InvocationTargetException;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;

public abstract class UnitCard extends Card
{
	private UnitFactory unitFactory;
	private int row;
	private int column;
	private Player owner;
	public UnitCard(int thresholdCost, Resource[] resourceCost, UnitFactory unitFactory)
	{
		super(thresholdCost, resourceCost, new Requirement[]{Requirement.OWN_EMPTY_HEX});
		this.unitFactory = unitFactory;
		row = -1;
		column = -1;
		owner = Player.NONE;
	}
	@Override
	public void inputHex(Player side, int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	@Override
	public void play(BoardHalf mySide, BoardHalf opponentsSide)
	{
		if(row>=0&&row<mySide.numberOfRows()&&column>=0&&column<mySide.numberOfColumns())
		{
			try
			{
				mySide.addUnit(unitFactory.create(row, column));
			}
			catch(InstantiationException e){}
			catch(IllegalAccessException e){}
			catch(IllegalArgumentException e){}
			catch(InvocationTargetException e){}
			catch(SecurityException e){}
		}
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
