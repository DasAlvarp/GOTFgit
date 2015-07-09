package com.alvarpq.GOTF.requirement;
public class TileRequirement implements Requirement
{
	private int row;
	private int column;
	public TileRequirement()
	{
		row = -1;
		column = -1;
	}
	@Override
	public RequirementType getType()
	{
		return RequirementType.TILE;
	}
	@Override
	public boolean isFulfilled()
	{
		return row>=0&&column>=0;
	}
	@Override
	public void reset()
	{
		row = -1;
		column = -1;
	}
	public int getRow()
	{
		return row;
	}
	public int getColumn()
	{
		return column;
	}
	public void setTile(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
}