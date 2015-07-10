package com.alvarpq.GOTF.requirement;
public class RowRequirement implements Requirement
{
	private int row;
	private RequirementType type;
	public RowRequirement()
	{
		row = -1;
		this.type = RequirementType.ROW;
	}
	@Override
	public RequirementType getType()
	{
		return type;
	}
	@Override
	public boolean isFulfilled()
	{
		return row!=-1;
	}
	@Override
	public void reset()
	{
		row = -1;
	}
	public int getRow()
	{
		return row;
	}
	public void setRow(int row)
	{
		this.row = row;
	}
}