package com.alvarpq.GOTF.requirement;

import com.alvarpq.GOTF.coreGame.Player;

public class TileRequirement implements Requirement
{
	private Player side;
	private int row;
	private int column;
	private RequirementType type;
	public TileRequirement(RequirementType type)
	{
		side = Player.NONE;
		row = -1;
		column = -1;
		this.type = type;
	}
	@Override
	public RequirementType getType()
	{
		return type;
	}
	@Override
	public boolean isFulfilled()
	{
		return side!=Player.NONE&&row>=0&&column>=0;
	}
	@Override
	public void reset()
	{
		row = -1;
		column = -1;
	}
	public Player getSide()
	{
		return side;
	}
	public int getRow()
	{
		return row;
	}
	public int getColumn()
	{
		return column;
	}
	public void setTile(Player side, int row, int column)
	{
		this.side = side;
		this.row = row;
		this.column = column;
	}
}